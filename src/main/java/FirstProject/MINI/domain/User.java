package FirstProject.MINI.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity     //@Entity = jpa에서 관리하는 객체라는것을 명시
@Table(name = "user")   //@Table = 아래 클래스가 어떤 Table 명을 가지고있는지 명시
public class User {
    //@Id = Primary Key 명시, @Generatedvalue(어쩌구) - DB에서 관리하는 방법 명시. 현재는 DB에서 알아서 관리한다.ex)auto_increment
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "age")   //@Column = 아래 변수가 어떤 Column 명을 가지고있는지 명시.  만약 이름이 같을경우 생략가능
    private Integer age;
    private String user_id;
    private String password;

    public User(){
    }

    public User(String name, Integer age, String user_id, String password) {
        this.name = name;
        this.age = age;
        this.user_id = user_id;
        this.password = password;
    }
}
