package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//클래스 내 모든 필드의 Getter 자동생성
@Getter
//기본 생성자 자동 추가
//public Posts(){}와 같은 효과
@NoArgsConstructor
//주요 어노테이션인 엔티티를 클래스에 가깝게 둔다.
@Entity
//posts 클래스는 실제 DB 테이블과 매칭될 클래스
//JPA를 사용하면 DB 데이터에 작업시 실제 쿼리를 날리는게 아니라 entity 클래스의 수정을 통해 작업하게 됨
//기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름 매칭
public class Posts extends BaseTimeEntity {

    //해당 테이블의 PK 필드
    @Id
    //PK 생성 규칙
    //웬만하면 Auto_increment 사용
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    //컬럼 string size를 늘림
    @Column(length=500, nullable=false)
    private String title;

    //컬럼 타입을 text로 변경
    @Column(columnDefinition="Text", nullable=false)
    private String content;
    private String author;

    //해당 클래스의 빌더 패턴 클래스를 생성
    //서비스 초기 구축 단계에서 테이블 설계(엔티티 설계)가 빈번하게 바뀌므로 롬복 어노테이션 적극 사용은 코드 변경량 최소화에 도움이 됨
    //생성자와 비교했을 때 builder는 어떤 필드에 어떤 값이 채워져야하는지 명확하게 인지할 수 있다.
    @Builder
    public Posts (String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
