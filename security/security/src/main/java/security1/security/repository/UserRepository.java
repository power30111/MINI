package security1.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security1.security.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

    //Username을 기반으로 User객체 반환
    public User findByUsername(String username);
    //JPA 쿼리 메서드? 사용 query method
 }
