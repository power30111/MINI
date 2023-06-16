package FirstProject.MINI.repository;

import FirstProject.MINI.domain.Product;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class OrderRepositoryV1 implements OrderList {

    private final JdbcTemplate template;

    public OrderRepositoryV1(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        //커넥션 획득을 위한 template
    }

    @Override
    public void save(Product product) {
    }

    @Override
    public void delete(Product product) {
    }

    @Override
    public void update() {

    }
}
