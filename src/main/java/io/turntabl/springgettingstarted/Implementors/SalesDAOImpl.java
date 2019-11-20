package io.turntabl.springgettingstarted.Implementors;


import io.turntabl.springgettingstarted.DAO.SalesDAO;
import io.turntabl.springgettingstarted.Transfers.SaleTo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class SalesDAOImpl implements SalesDAO {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setJdbcTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    @Override
    public List<SaleTo> getAllSalesbyWeek(String startDate, String endDate) throws ParseException {
        List<SaleTo> sales = jdbcTemplate.query(
                "select products.product_name, customers.contact_name from products inner join order_details on products.product_id = order_details.product_id inner join orders on order_details.order_id = orders.order_id inner join customers on orders.customer_id = customers.customer_id where orders.order_date between ? and ?",
                new Object[]{getDateObject(startDate),getDateObject(endDate)},
                BeanPropertyRowMapper.newInstance(SaleTo.class)
        );
        return sales;
    }

    public java.sql.Date getDateObject(String date) throws ParseException {
        SimpleDateFormat fromatDate = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date newDatew= fromatDate.parse(date);
        java.sql.Date finalDate = new java.sql.Date(newDatew.getTime());
        return finalDate;
    }
}
