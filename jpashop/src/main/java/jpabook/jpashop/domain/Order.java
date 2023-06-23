package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)      //다 대 일 관계
    @JoinColumn(name = "member_id") //join을 어떻게 할건지? 에 대해서 쓰는 어노테이션으로 FK가 member_id 로 설정된다
    private Member member;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)//cascadeType.ALL? -> OrderItem에 있는 필드들을 persist해줌.
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)//Order 저장할때 delivery도 persist해준다.
    @JoinColumn(name = "delivery_id")                       //기본적으로 모든 Entity는 persist를 각자해줘야한다.
    private Delivery delivery;                              //그러나 cascade옵션을 쓰면 Order persist할때 같이 persist.

    private LocalDateTime orderDate;    //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태 [Order,Cancel]

    //연관관계 편의 메서드?
    //서로 객체에 접근해서 변경할경우 실수할수 있는 부분을 묶어서 처리하게끔 하는 메서드.(그냥 진짜 사용자편의)
    public void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }
    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }


}
