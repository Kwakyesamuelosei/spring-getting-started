package io.turntabl.springgettingstarted.DAO;

import io.turntabl.springgettingstarted.Transfers.SaleTo;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.ParseException;
import java.util.List;

public interface SalesDAO {
    public void setJdbcTemplate(JdbcTemplate template);
    public List<SaleTo> getAllSalesbyWeek(String startDate, String endDate) throws ParseException;
}
