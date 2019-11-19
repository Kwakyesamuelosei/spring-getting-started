package io.turntabl.springgettingstarted.DAO;

import io.turntabl.Transfers.SaleTo;
import io.turntabl.springgettingstarted.Transfers.ProductTo;

import java.util.List;

public interface CategoryDAO {
    List<ProductTo> getProductsByCategory(String name);
    List<SaleTo> getSalesByCategory(String name);
}
