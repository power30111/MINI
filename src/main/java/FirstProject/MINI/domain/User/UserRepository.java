package FirstProject.MINI.domain.User;

import FirstProject.MINI.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u.password FROM User u WHERE u.userId = :userId")
    String findPasswordByUserId(String userId);

    Optional<User> findByUserId(String userId);
}
