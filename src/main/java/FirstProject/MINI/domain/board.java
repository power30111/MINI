package FirstProject.MINI.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class board {    //게시판관련

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String loginId;
    private String password;
    private String Username;

    private UserGrade grade;
    
}
