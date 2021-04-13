package org.example.springboot.web;
import org .junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//테스트를 실행할 때, junit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
//여기서는 SpringRunner라는 스프링 실행자를 사용한다.
//즉, 스프링 부트 테스트와 junit 사이에 연결자 역할을 한다.
@RunWith(SpringRunner.class)

//스프링 테스트 어노테이션 중 Web(spring mvc)에 집중할 수 있는 어노테이션
//@Controller, @ControllerAdvice 등을 사용할 수 있다.
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    //스프링이 관리하는 bean을 주입받는다.
    @Autowired
    //웹 api를 테스트할 때 사용하며 스프링 mvc 테스트의 시작점
    //이 클래스로 http get, post 등에 대한 api 테스트를 진행할 수 있다.
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        //MockMvc를 통해 /hello 주소로 HTTP GET 요청을 한다.
        //체이닝이 지원되어 여러 검증 기능을 이어서 선언할 수 있음
        mvc.perform(get("/hello"))
                //http header의 status를 검증, 여기서는 200인지 아닌지 검증
                .andExpect(status().isOk())
                //응답 내용의 본문을 검증, 여기서는 hello가 맞는지 검증
                .andExpect(content().string(hello));
    }

    @Test
    public void HelloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        //param으로 api 테스트할 때 사용될 요청 파라미터를 설정
        //단 값은 string만 허용하므로 숫자/날짜 데이터도 문자열로 변경해야 함
        mvc.perform(
                get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount))
        )
                //jsonpath는 응답값을 필드별로 검증할 수 있는 메소드
                //$을 기준으로 필드명 명시
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(name)))
            .andExpect(jsonPath("$.amount", is(amount)));
    }
}
//build.gradle에 종속성 포함했던 junit5에서 문제가 생김