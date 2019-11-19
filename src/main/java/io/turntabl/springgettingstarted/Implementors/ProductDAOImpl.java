package io.turntabl.springgettingstarted.Implementors;
import io.turntabl.springgettingstarted.DAO.ProductDAO;
import io.turntabl.springgettingstarted.Transfers.ProductTo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    List<ProductTo> productTos = new ArrayList<>();

    @Override
    public List<ProductTo> get5MostPopularProducts() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql:northwind";

            try{
                Connection db_con = DriverManager.getConnection(url,"sammyK","turntabl");
                PreparedStatement query = db_con.prepareStatement(
                        "select products.product_name,products.unit_price, count(order_details.product_id) from order_details inner join products on order_details.product_id = products.product_id group by products.product_name, products.unit_price limit 5"
                );
                query.clearParameters();

                ResultSet rs = query.executeQuery();
//                while(rs.next()){
//                    ProductTo productTo = new ProductTo(rs.getString("product_name"),rs.getInt("unit_price"));
//                    productTos.add(productTo);
//                }

            }catch (SQLException sqle){
                System.out.println("Connection err: " + sqle);
            }

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productTos;
    }
}
