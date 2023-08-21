package FirstProject.MINI.domain.User;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Table(name = "USERS")
@AllArgsConstructor
@Builder
public class User {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,unique = true)
    private String userId;
    //아이디
    @Column(nullable = false)
    private String password;
    //비번
    @Column(nullable = false)
    private String name;
    //사용자 이름

    public User(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
    }

    public Long ChangeUserInfo(String userId,String password,String name){
        this.userId =userId;
        this.name=name;
        this.password=password;
        return id;
    }
}
