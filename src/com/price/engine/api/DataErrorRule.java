package com.price.engine.api;

/**
 * Class describing data error rule.
 * @author ROHIT DESHMUKH
 */
public class DataErrorRule implements Rule {

    double value;

    /**
     * constructor for data error rule.
     * @param value of the rule
     */
    public DataErrorRule(double value) {
        this.value = value;
    }

    /**
     * sets the error percentage value
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}
