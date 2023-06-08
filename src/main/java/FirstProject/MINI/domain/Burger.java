package FirstProject.MINI.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Burger extends Product{

    private String name;    //햄버거 이름

    private String category;    //카테고리

    private Integer price;  //가격

    private Integer Kcal;   //열량

    private ArrayList<Product> option;  //햄버거의 경우 세트여부(Side와 Drink가 Option에 들어가야한다).

}
