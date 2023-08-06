package FirstProject.MINI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    String findByUserId(String userId);

    @Query("SELECT u.password FROM User u WHERE u.username = :username")
    String findPasswordByUserId(String userId);
}
