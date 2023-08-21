package FirstProject.MINI.domain.User;


import FirstProject.MINI.domain.User.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String userId;
    private String password;
    private String name;

    public User toEntity(){
        User user = User.builder()
                .userId(userId)
                .password(password)
                .name(name)
                .build();
        return user;
    }
}
