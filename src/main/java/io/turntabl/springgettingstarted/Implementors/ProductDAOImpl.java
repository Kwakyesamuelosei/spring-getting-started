package io.turntabl.springgettingstarted.Implementors;
import io.turntabl.springgettingstarted.DAO.ProductDAO;
import io.turntabl.springgettingstarted.Transfers.ProductTo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setJdbcTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    @Override
    public List<ProductTo> get5MostPopularProducts() {
        List<ProductTo> products = jdbcTemplate.query(
                "select products.product_name,products.unit_price, count(order_details.product_id) from order_details inner join products on order_details.product_id = products.product_id group by products.product_name, products.unit_price limit 5",
                BeanPropertyRowMapper.newInstance(ProductTo.class)
        );
        return products;
    }
}
