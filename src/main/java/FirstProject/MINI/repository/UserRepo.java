package FirstProject.MINI.repository;

import FirstProject.MINI.domain.User;
import FirstProject.MINI.domain.UserUpdateDto;

public interface UserRepo {
    public User save(User user);    //회원가입

    public User delete(User user);  //회원탈퇴

    public void update(Long userId, UserUpdateDto userUpdateDto);  //회원정보 변경
}
