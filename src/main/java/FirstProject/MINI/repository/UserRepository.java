package FirstProject.MINI.repository;

import FirstProject.MINI.domain.User;
import FirstProject.MINI.domain.UserUpdateDto;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Repository
@Transactional      //JPA를 사용할때 데이터변경을 할려면 항상 Transaction을 사용하므로 필수로 넣어줘야한다.(조회는 ㄱㅊ)
public class UserRepository implements UserRepo{

    private final EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public User delete(User user) {

        return null;
    }

    @Override
    public void update(Long userId, UserUpdateDto userUpdateDto) {
        User findUser = em.find(User.class, userId);
        findUser.setAge(userUpdateDto.getAge());
        findUser.setUser_id(userUpdateDto.getUser_id());
        findUser.setPassword(userUpdateDto.getPassword());
        findUser.setName(userUpdateDto.getName());
    }
}
