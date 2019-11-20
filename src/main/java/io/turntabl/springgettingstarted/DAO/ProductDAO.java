package io.turntabl.springgettingstarted.DAO;

import io.turntabl.springgettingstarted.Transfers.ProductTo;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface ProductDAO {
    public void setJdbcTemplate(JdbcTemplate template);
    List<ProductTo> get5MostPopularProducts();
}
