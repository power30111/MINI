package jpabook.jpashop.domain.item;


import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   //이건...검색해봐야할듯; 3가지 전략중 싱글테이블 전략사용
@DiscriminatorColumn(name = "dtype")    //각각에 어떤타입일때 속성이 뭔지??? 잘모르겟음. Book, Album, Movie와 연관이있는데.
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;


    //아래는 공통속성 (상속관계)_
    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
