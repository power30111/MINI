package jpabook.jpashop.domain.item;


import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
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
    
    //비즈니스 로직==//

    /**
     * 재고수량을 증가시키는 메서드
     * @param quantity
     * 현재수량 + quantity
     */
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    /**
     * 재고수량을 감소시키는 메서드
     * @param quantity
     * 현재수량 - quantity. 단, 감소후 현재수량이 0보다 작을경우 NotEnoughStockException발생
     */
    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
