package FirstProject.MINI.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class User {
    
    @Id
    @Column(name = "user_id")
    private Long id;
    //아이디
    private String password;
    //비번
    private String name;
    //사용자 이름
    private LocalDateTime join_date;
    //가입 날짜
}
