package FirstProject.MINI.repository;

import FirstProject.MINI.domain.Product;
import jakarta.persistence.criteria.Order;

import java.util.ArrayList;

public class OrderReposiotryV1 implements OrderList {

    ArrayList<Product> repository = new ArrayList<>();
    @Override
    public void save(Product product) {
        repository.add(product);
    }

    @Override
    public void delete(Product product) {
        repository.remove(product);
    }

    @Override
    public void update() {

    }
}
