package com.example.ratatouille23.Utils;

import java.util.List;

public class ResponseProduct {

    private String count;
    private String skip;
    private String page;
    private String page_count;
    private String page_size;
    private List<Prodotto> products;


    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPage_count() {
        return page_count;
    }

    public void setPage_count(String page_count) {
        this.page_count = page_count;
    }

    public String getPage_size() {
        return page_size;
    }

    public void setPage_size(String page_size) {
        this.page_size = page_size;
    }

    public List<Prodotto> getProducts() {
        return products;
    }

    public void setProducts(List<Prodotto> products) {
        this.products = products;
    }
}
