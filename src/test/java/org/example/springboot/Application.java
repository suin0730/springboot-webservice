package org.example.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
//스프링 부트의 자동 설정, 스프링 bean 읽기와 생성이 모두 자동으로 설정됨
//이 위치부터 설정을 읽기때문에 이 클래스는 프로젝트의 최상단에 위치할 필요가 있음
@SpringBootApplication
public class Application {
    //에러 수정 내역
        //"애플리케이션 JMX 서비스 URL 검색 실패" 오류가 나오는 경우,
        // 2018.3.4부터 IntelliJ는 Spring Boot 액추에이터 엔드 포인트의 데이터를 검색하기 위해 로컬 JMX 커넥터를 사용
        // 로컬 JMX 모니터링은 Spring Boot 애플리케이션과 IntelliJ JVM의 비트 수가 다른 경우 로컬 JMX 커넥터 주소를 가져올 수 없음
        // 따라서 실행 >> 구성편집 >> JMX 활성화 체크 해제 필요
    public static void main(String[] args){
        //내장 web application server가 실행됨
        //서버에 tomcat을 설피할 필요가 없고 스프링 부트로 만들어진 jar 파일로 실행 가능
        //외장 서버와 비교해 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있다는 장점이 있음
        //새로운 서버를 추가해도 모든 서버가 쉽게 같은 WAS 환경을 구축할 수 있다.
        SpringApplication.run(Application.class, args);
    }
}
