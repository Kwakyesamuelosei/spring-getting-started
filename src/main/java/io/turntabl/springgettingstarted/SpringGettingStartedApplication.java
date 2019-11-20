package io.turntabl.springgettingstarted;

import io.turntabl.springgettingstarted.Implementors.CustomerDAOImpl;
import io.turntabl.springgettingstarted.Implementors.SalesDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;

public class SpringGettingStartedApplication {

	public static void main(String[] args) {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//
//		HumanBean person = (HumanBean)ac.getBean("humanBean");
//		System.out.println(person.fname);
//		System.out.println(person.bestFriend.fname);

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        CustomerDAOImpl customerDAO = (CustomerDAOImpl)ctx.getBean("customerDAO");
        System.out.println(customerDAO.getCustomerProducts("Maria Anders"));

//        ApplicationContext ctx2 = new ClassPathXmlApplicationContext("beans.xml");
//        ProductDAOImpl productDAO = (ProductDAOImpl)ctx2.getBean("productDAO");
//        System.out.println(productDAO.get5MostPopularProducts());

//		ApplicationContext ctx3 = new ClassPathXmlApplicationContext("beans.xml");
//		SalesDAOImpl salesDAO = (SalesDAOImpl)ctx3.getBean("salesDAO");
//		try{
//			String startDate = "1996-07-04";
//			String endDate = "1996-07-11";
//			System.out.println(salesDAO.getAllSalesbyWeek(startDate,endDate));
//		}catch (ParseException e){
//			System.out.println(e.getMessage());
//		}
	}

}
