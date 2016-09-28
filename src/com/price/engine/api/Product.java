package com.price.engine.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * This class takes all the competitors products prices
 * and calculates the minimum price , average prices. 
 * @author Rohit Deshmukh
 */
public class Product {
    /**
     * name of the product
     */
    String name;
    
    /**
     * list of {@link Competitor} producing the product and price from each competitor
     */
    private Map<Competitor, Double> compitetorNamePrice = new HashMap<Competitor, Double>();

    private Double minPrice = null;

    /**
     * supply variant
     */
    Variation supply;

    /**
     * demand variant
     */
    Variation demand;

    private double averagePrice;

    private String countOccurences;

    /**
     * sets the name of the product , current level of supply and demand
     * @param name of the product
     * @param supply parameter of the product
     * @param demand parameter of the product
     */
    public Product(String name, Variation supply, Variation demand) {
        this.name = name;
        this.supply = supply;
        this.demand = demand;
    }

    /**
     * Adds the prices of competitor products.
     * @param competitor name of the competitor 
     * @param price of the product
     */
    public void addCompetitorPrice(Competitor competitor, double price) {
        compitetorNamePrice.put(competitor, price);
        computeAveragePrice();
        appendOccurence(price);
        computeMinPrice(price);
    }
    
    /**
     * counts the occurrence of price
     * @param price of the product
     */
    private void appendOccurence(final double price) {
        countOccurences = countOccurences + "-" + price;
    }

    /**
     * computes the average price of the product
     */
    private void computeAveragePrice() {
        averagePrice = 0;
        for (Double value : compitetorNamePrice.values()) {
            averagePrice += value;
        }
        averagePrice /= compitetorNamePrice.values().size();
    }

    /**
     * computes the minimum price of product
     * @param price of the product
     */
    private void computeMinPrice(final double price) {

        if (minPrice == null) {
            minPrice = price;
        }

        if (price < minPrice) {
            minPrice = price;
        }

        if (findOccurences(price) > findOccurences(minPrice)) {
            minPrice = price;
        }
    }
    
    /**
     * finds the number of occurrences of the price
     * @param price of the product
     * @return the number of occurrences
     */
    public int findOccurences(double price) {
        int i = 0;
        Pattern p = Pattern.compile("" + price);
        Matcher m = p.matcher(countOccurences);

        while (m.find()) {
            i++;
        }
        return i;
    }

    /**
     * returns all the competitors product sorted price values
     * @return List of sorted values
     */
    public List<Double> getAllPrices() {
        List<Double> value = new ArrayList();
        value.addAll(compitetorNamePrice.values());
        Collections.sort(value, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o1.doubleValue()*100 - o2.doubleValue()*100);
            }
        });
        Collections.sort(value, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) ((findOccurences(o2) - findOccurences(o1)));
                }
        });
        return value;
    }

    /**
     * returns minimum price of the product
     * @return minPrice
     */
    public double getMinPrice() {
        return minPrice;
    }

    /**
     * returns the average price of the product
     * @return averagePrice
     */
    public double getAveragePrice() {
        return averagePrice;
    }

    /**
     * returns the {@link Variation} attribute of supply
     * @return supply
     */
    public Variation getSupply() {
        return supply;
    }

    /**
     * sets the {@link Variation} attribute of supply
     * @param supply
     */
    public void setSupply(Variation supply) {
        this.supply = supply;
    }

    /**
     * returns the {@link Variation} attribute of demand
     * @return demand
     */
    public Variation getDemand() {
        return demand;
    }

    /**
     * sets the {@link Variation} attribute of demand
     * @param demand
     */
    public void setDemand(Variation demand) {
        this.demand = demand;
    }
}
