package FirstProject.MINI.repository;

import FirstProject.MINI.domain.Product;

public interface OrderList {

    public void save(Product product);  //제품을 주문내역에 저장하기

    public void delete(Product product);    //제품을 주문내역에서 삭제

    public void update();       //제품 변경     이건 나중에

}
