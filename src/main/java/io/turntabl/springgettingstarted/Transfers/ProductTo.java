package io.turntabl.springgettingstarted.Transfers;

public class ProductTo {
    private String product_name;
    private Integer unit_price;

    public ProductTo() {
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setUnit_price(Integer unit_price) {
        this.unit_price = unit_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public Integer getUnit_price() {
        return unit_price;
    }

    @Override
    public String toString() {
        return "{" +
                "product_name='" + product_name + '\'' +
                ", unit_price=" + unit_price +
                '}';
    }
}
