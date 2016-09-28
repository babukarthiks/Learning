package com.price.engine.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Driver class for computing the price recommendation.
 * @author Rohit Deshmukh
 */
public class PricingEngine {

    static Map<String, Rule> productRule = new HashMap();

    static List<Rule> rule = new ArrayList<Rule>();
    private static String FILENAME;
    private static String OUTPUT_FILENAME;
    private static HashMap<String, Product> productsMap = new HashMap<String, Product>();
    private static PrintWriter writer;

    public static void main(String args[]) {

        // Assign input output filenames
        FILENAME = args[0];
        OUTPUT_FILENAME = args[1];

        productRule.put("HH", new SupplyDemandRule(Variation.HIGH, Variation.HIGH, 0.0));
        productRule.put("HL", new SupplyDemandRule(Variation.HIGH, Variation.LOW, -0.05));
        productRule.put("LH", new SupplyDemandRule(Variation.LOW, Variation.HIGH, 0.05));
        productRule.put("LL", new SupplyDemandRule(Variation.LOW, Variation.LOW, 0.10));
        productRule.put("PROMOTIONRULE", new PromotionRule(0.5));
        productRule.put("DATAERRORRULE", new DataErrorRule(0.5));

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String sCurrentLine;
            int count = 0;
            int numOfProducts = 0;
            int numOfCompetitorProducts = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                // Assign the number of products
                if (1 > count) {
                    numOfProducts = Integer.parseInt(sCurrentLine) - 1;
                    count++;
                    continue;
                }
                // Create the products and store to productsList
                if (0 <= numOfProducts) {
                    String[] tokens = sCurrentLine.split("\\s+");
                    productsMap.put(tokens[0],
                            new Product(tokens[0], tokens[1].equals("H") ? Variation.HIGH : Variation.LOW,
                                    tokens[2].equals("H") ? Variation.HIGH : Variation.LOW));
                    numOfProducts--;
                    continue;
                } else if (1 == count) {
                    // Create the competitor products and add them to the competitorList
                    numOfCompetitorProducts = Integer.parseInt(sCurrentLine);
                    count++;
                    continue;
                }
                if (0 != numOfCompetitorProducts) {
                    String[] tokens = sCurrentLine.split("\\s+");
                    if (null != productsMap.get(tokens[0])) {
                        Competitor competitor = new Competitor(tokens[1]);
                        productsMap.get(tokens[0]).addCompetitorPrice(competitor, Double.parseDouble(tokens[2]));
                        competitor.addProduct(productsMap.get(tokens[0]));
                    }
                    numOfCompetitorProducts--;
                }
            }

            writer = new PrintWriter(new File(OUTPUT_FILENAME));
            // print the price estimate for each product
            for (String productKey : productsMap.keySet()) {
                writer.println(productKey + " " + getPrice(productsMap.get(productKey)));
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }

    }

    /**
     * Computes the price recommendation
     * @param product object to be assessed for recommendation 
     * @return price 
     */
    private static double getPrice(Product product) {

        for (double price : product.getAllPrices()) {
            if (!checkIfMaxPriceisMorethanAverage(price, product.getAveragePrice())
                    && !checkIfMinPriceisLessthanAverage(price, product.getAveragePrice())) {
                if (product.getSupply() == Variation.HIGH && product.getDemand() == Variation.HIGH) {
                    return price + price * productRule.get("HH").getValue();
                }
                if (product.getSupply() == Variation.LOW && product.getDemand() == Variation.HIGH) {
                    return price + price * productRule.get("LH").getValue();
                }
                if (product.getSupply() == Variation.HIGH && product.getDemand() == Variation.LOW) {
                    return price + price * productRule.get("HL").getValue();
                }
                if (product.getSupply() == Variation.LOW && product.getDemand() == Variation.LOW) {
                    return price + price * productRule.get("LL").getValue();
                }
            }
        }
        return 0.0;
    }

    /**
     * Checks whether Minimum price is less than average
     * @param price of the product
     * @param avgprice of the product
     * @return boolean
     */
     private static boolean checkIfMinPriceisLessthanAverage(double price, double avgprice) {
     
        return price < (avgprice * productRule.get("PROMOTIONRULE").getValue());
    }
     
     /**
      * Checks whether Maximum price is less than average
      * @param price of the product
      * @param avgprice of the product
      * @return boolean
      */
    private static boolean checkIfMaxPriceisMorethanAverage(double price, double avgprice) {
        return price > (avgprice + (avgprice * productRule.get("DATAERRORRULE").getValue()));
    }

}
