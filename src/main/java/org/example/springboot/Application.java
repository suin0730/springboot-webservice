package org.example.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//JPA auditing 활성화
@EnableJpaAuditing
//스프링 부트의 자동 설정, 스프링 bean 읽기와 생성이 모두 자동으로 설정됨
//이 위치부터 설정을 읽기떄문에 이 클래스는 프로젝트의 최상단에 위치할 필요가 있음
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        //내장 web application server가 실행됨
        //서버에 tomcat을 설치할 필요가 없고 스프링 부트로 만들어진 jar 파일로 실행 가능
        //외장 서버와 비교해 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있다는 장점이 있음
        //새로운 서버를 추가해도 모든 서버가 쉽게 같은 WAS 환경을 구축할 수 있다.
        SpringApplication.run(Application.class, args);
    }
}