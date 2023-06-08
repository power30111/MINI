package FirstProject.MINI.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String name;    //제품이름

    private String category;    //카테고리

    private Integer price;  //가격

    private Integer Kcal;   //열량
}
