package jpabook.jpashop.domain;


import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  //protected 생성자 생성.
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")  //매핑
    private Order order;
    
    private int orderPrice; //상품가격
    private int count;  //주문 수량

    //==비즈니스 로직==//

    public void cancel(){
        getItem().addStock(count);
        //주문취소이므로, 재고수량을 원래대로 돌려놓는다.
    }

    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }

    //==생성 메서드==//
    public static OrderItem createOrderItem(Item item, int orderPrice, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        //주문이 들어온 만큼 재고수량에서 제거
        item.removeStock(count);
        return orderItem;
    }
}
