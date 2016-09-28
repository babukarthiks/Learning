package com.price.engine.api;

/**
 * 
 * Class that describes supply ,demand rule.
 * @author ROHIT DESHMUKH
 */
public class SupplyDemandRule implements Rule {

    double value;
    Variation supply;
    Variation demand;
    
    /**
     * Constructor for supply and demand rule
     * @param supply parameter for product
     * @param demand parameter for product
     * @param value percentage value to be applied for this rule
     */
    public SupplyDemandRule(Variation supply, Variation demand, double value) {
        this.value = value;
        this.supply = supply;
        this.demand = demand;
    }
    
    /**
     * returns the {@link Variation} attribute of supply
     * @return supply
     */
    public Variation getSupply() {
        return supply;
    }
    
    /**
     * sets {@link Variation} attribute of supply
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
     * sets {@link Variation} attribute of demand
     * @param demand
     */
    public void setDemand(Variation demand) {
        this.demand = demand;
    }
    
    /**
     * sets the price alternating percentage value
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }
    
    /**
     * returns the price alternating percentage value
     * {@inheritDoc}
     */
    @Override
    public double getValue() {
        return value;
    }
    
    /**
     * returns true or false
     * @param rule object
     * @return boolean
     */
    public boolean equals(SupplyDemandRule rule) {
        return this.supply == rule.supply && this.demand == rule.demand;
    }
}
