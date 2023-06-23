package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {


    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    //Many TO Many 의 경우 관계형 DB에서 1 대 다 + 다 대 1 로 풀어서 연결한다
    //그러므로 중간 연결용 테이블을 추가.  (실무에서는 사용X)
    @ManyToMany
    @JoinTable( name = "category_item",
                joinColumns = @JoinColumn(name = "category_id"),
                inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
}
