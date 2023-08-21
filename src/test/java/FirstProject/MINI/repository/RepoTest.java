package FirstProject.MINI.repository;

import FirstProject.MINI.domain.User.User;
import FirstProject.MINI.domain.User.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
public class RepoTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void SAVE테스트() throws Exception{
        //given
        User user = new User("power","30111","윤수범");

        userRepository.save(user);

        //when
        List<User> userList = userRepository.findAll();

        //then
        User testUser = userList.get(0);


        log.info("UserId = "+testUser.getUserId());
        log.info("UserPassword = "+testUser.getPassword());
        log.info("UserName = "+testUser.getName());


        assertThat("power").isEqualTo(testUser.getUserId());
        assertThat("30111").isEqualTo(testUser.getPassword());
        assertThat("윤수범").isEqualTo(testUser.getName());
    }
}
