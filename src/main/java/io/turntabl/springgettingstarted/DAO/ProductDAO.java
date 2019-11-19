package io.turntabl.springgettingstarted.DAO;

import io.turntabl.springgettingstarted.Transfers.ProductTo;

import java.util.List;

public interface ProductDAO {
    List<ProductTo> get5MostPopularProducts();
}
