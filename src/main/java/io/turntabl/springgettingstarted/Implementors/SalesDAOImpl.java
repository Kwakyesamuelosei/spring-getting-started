package io.turntabl.springgettingstarted.Implementors;

import io.turntabl.DAO.SalesDAO;
import io.turntabl.Transfers.SaleTo;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SalesDAOImpl implements SalesDAO {
    List<SaleTo> saleTos = new ArrayList<>();

    @Override
    public List<SaleTo> getAllSalesbyWeek(String startDate, String endDate) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql:northwind";

            try{
                Connection db_con = DriverManager.getConnection(url,"sammyK","turntabl");
                PreparedStatement query = db_con.prepareStatement(
                        "select products.product_name,products.unit_price, customers.contact_name from products inner join order_details on products.product_id = order_details.product_id inner join orders on order_details.order_id = orders.order_id inner join customers on orders.customer_id = customers.customer_id where orders.order_date between ? and ?"
                );
                query.clearParameters();
                query.setDate(1, getDateObject(startDate));
                query.setDate(2, getDateObject(endDate));

                ResultSet rs = query.executeQuery();
                while(rs.next()){
                    SaleTo saleTo = new SaleTo(rs.getString("product_name"),rs.getString("contact_name"));
                    saleTos.add(saleTo);
                }

            }catch (SQLException sqle){
                System.out.println("Connection err: " + sqle);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return saleTos;
    }
    public java.sql.Date getDateObject(String date) throws ParseException {
        SimpleDateFormat fromatDate = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date newDatew= fromatDate.parse(date);
        java.sql.Date finalDate = new java.sql.Date(newDatew.getTime());
        return finalDate;
    }
}
