package org.example.springboot.web;
import org.example.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//해당 컨트롤러를 json을 반환하는 컨트롤러로 만들어준다.
//예전에 @ResponseBody를 각 메소드마다 선언했던 것을 클래스 단위로 한번에 사용할 수 있게 해준다.
@RestController
public class HelloController {
    //http method인 get의 요청을 받을 수 있는 api를 만들어준다.
    //예전에는 RequestMapping으로 사용되었다.
    @GetMapping("/hello/dto")
//1. 이 프로젝트는 이제 /hello로 요청이 오면 문자열 hello를 반환하는 기능을 가진다.
//    public String hello(){
//        return "hello";
//    }
    //2. RequestParam은 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
    //여기서는 외부에서 name(@RequestParam("name"))일나 이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에 저장
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
