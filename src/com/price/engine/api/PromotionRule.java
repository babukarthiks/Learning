package com.price.engine.api;

/**
 * Class that describes the promotion rule.
 * @author ROHIT DESHMUKH
 */
public class PromotionRule implements Rule {

    double value;
    
    /**
     * constructor for promotion rule value
     * @param value
     */
    public PromotionRule(double value) {
        this.value = value;
    }
    
    /**
     * sets the promotion rule value
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

}
