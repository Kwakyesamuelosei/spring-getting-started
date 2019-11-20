package io.turntabl.springgettingstarted.Transfers;

public class SaleTo {
    private String product_name;
    private String contact_name;

    public SaleTo() {

    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getContact_name() {
        return contact_name;
    }

    @Override
    public String toString() {
        return "{" +
                "product_name='" + product_name + '\'' +
                ", contact_name='" + contact_name + '\'' +
                '}';
    }
}
