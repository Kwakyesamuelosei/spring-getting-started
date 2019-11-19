package io.turntabl.springgettingstarted;



import io.turntabl.springgettingstarted.Implementors.CustomerDAOImpl;
import io.turntabl.springgettingstarted.Transfers.ProductTo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args){


        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        CustomerDAOImpl customerDAO = (CustomerDAOImpl)ctx.getBean("customerDAO");
        System.out.println(customerDAO.getCustomerProducts("Maria Anders"));


//        List<ProductTo> response =  customerDAO.getCustomerProducts("Maria Anders");
       // System.out.println("List of Customer Products");
//        System.out.println(response);

//        ProductDAOImpl productDAO = new ProductDAOImpl();
//        List<ProductTo> response2 =  productDAO.get5MostPopularProducts();
//        System.out.println("List of 5 Most Popular Products");
//        System.out.println(response2);
//
//        String startDate = "1996-07-04";
//        String endDate = "1996-07-11";
//        SalesDAOImpl salesDAO = new SalesDAOImpl();
//        List<SaleTo> response3 =  salesDAO.getAllSalesbyWeek(startDate,endDate);
//        System.out.println("List All Sales By Week");
//        System.out.println(response3);
    }




}
