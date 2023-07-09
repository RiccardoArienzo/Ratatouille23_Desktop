package com.example.ratatouille23.Utils;

public class Prodotto {

    String product_name;
    String allergens;
    String generic_name;

    public Prodotto(String product_name, String allergens, String generic_name) {
        this.product_name = product_name;
        this.allergens = allergens;
        this.generic_name = generic_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public String getGeneric_name() {
        return generic_name;
    }

    public void setGeneric_name(String generic_name) {
        this.generic_name = generic_name;
    }

    @Override
    public String toString() {
        return product_name;
    }
}
