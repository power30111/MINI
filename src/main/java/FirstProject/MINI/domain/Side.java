package FirstProject.MINI.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Side extends Product{

    private String name;    //햄버거 이름

    private String category;    //카테고리

    private Integer price;  //가격

    private Integer Kcal;   //열량
    
    private Boolean option;     // 빨대 유무 (옵션)

}
