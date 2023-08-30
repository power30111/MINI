package FirstProject.MINI.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface GoogleUserRepository extends JpaRepository<GoogleUser,Long>{


    Optional<GoogleUser> findByEmail(String email);
    //소셜 로그인으로 반환되는중 email을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단하기 위한 메서드

}
