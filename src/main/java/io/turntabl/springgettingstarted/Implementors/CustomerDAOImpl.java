package io.turntabl.springgettingstarted.Implementors;

import io.turntabl.springgettingstarted.DAO.CustomerDAO;
import io.turntabl.springgettingstarted.Transfers.ProductTo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate template){
        this.jdbcTemplate = template;
    }

    @Override
    public List<ProductTo> getCustomerProducts(String name) {

        List<ProductTo> products = jdbcTemplate.query(
                "select products.product_name,products.unit_price from products inner join order_details on products.product_id = order_details.product_id inner join orders on order_details.order_id = orders.order_id inner join customers on orders.customer_id = customers.customer_id where customers.contact_name like ?",
                new Object[]{name},
                 BeanPropertyRowMapper.newInstance(ProductTo.class)
                );

        return products;
    }

}
