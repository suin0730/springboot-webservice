//DB Layer 접근자, JPA에서는 Repository라 부르며 인터페이스로 생성
package org.example.springboot.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//인터페이스 생성 후 JpaRepository<Entity 클래스, PK 타입>을 상속하면 CRUD 메소드 자동생성
//Entity class와 Entity repository는 함꼐 위치해야 하므로 둘을 Domain package에서 함께 관리한다.
public interface PostsRepository extends JpaRepository<Posts, Long>{
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
