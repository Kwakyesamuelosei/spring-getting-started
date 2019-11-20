package io.turntabl.springgettingstarted.DAO;


import io.turntabl.springgettingstarted.Implementors.ProductDAOImpl;
import io.turntabl.springgettingstarted.Implementors.SalesDAOImpl;

public interface DAOFactory {
    public ProductDAO getCustomerDao();
    public ProductDAOImpl getProductDAO();
    public SalesDAOImpl getSalesDAO();
}
