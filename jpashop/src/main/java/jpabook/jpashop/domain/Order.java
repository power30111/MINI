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

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;    //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태 [Order,Cancel]
}
