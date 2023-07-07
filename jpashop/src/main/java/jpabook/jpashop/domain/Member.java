package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;        //내장타입을 적용햇다는것을 선언

    @OneToMany(mappedBy = "member")                      //1대 다 관계
    private List<Order> orders = new ArrayList<>();
    //(mappedBy 속성을 넣는순간 order에서 매핑된 관계라고 선언. 음.. 그니깐 일종의 읽기전용 Column?
    //이 orders에 뭘 넣는다고해서 Order Table에서 FK값이 변경되지않는다.

}
