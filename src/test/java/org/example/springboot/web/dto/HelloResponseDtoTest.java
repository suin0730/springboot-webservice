package org.example.springboot.web.dto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //Given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        //assertj라는 테스트 검증 라이브러리의 메소드로, 검증하고 싶은 대상을 메소드 인자로 받는다.
        //메소드 체이닝 가능해 isEqualTo와 같이 메소드를 이어서 사용할 수 있다.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

        //junit과 비교한 assertj의 장점
            //만약 junit에서 assertThat을 쓰려면 CoreMatchers가 필요하지만 assertj는 필요없다.
            //자동완성이 좀 더 확실히 지원된다.
    }
}
