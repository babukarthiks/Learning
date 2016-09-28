package com.price.engine.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that describes the competitor.
 * @author Rohit Deshmukh
 */
public class Competitor {
    public String name;
    private List<Product> products = new ArrayList<Product>();
   
    /**
     * Sets the competitor name
     * @param name
     */
    public Competitor(String name) {
        this.name = name;
    }
    
    /**
     * returns the name of the competitor
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * adds all the products of the competitor in a list
     * @param products
     */
    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }
    
    /**
     * adds the product of the competitor in a list
     * @param products
     */
    public void addProduct(Product products) {
        this.products.add(products);
    }
}