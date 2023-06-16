package FirstProject.MINI.domain;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
    private String name;
    private Integer age;
    private String user_id;
    private String password;

}
