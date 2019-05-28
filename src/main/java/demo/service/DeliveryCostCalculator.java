package demo.service;

import demo.model.ShoppingCart;

import static demo.service.Utils.distinctByKey;

public class DeliveryCostCalculator {

    private double costPerDelivery;
    private double costPerProduct;
    private double fixedCost;
    private static DeliveryCostCalculator deliveryCostCalculatorInstance=null;

    public DeliveryCostCalculator() {
        this.costPerDelivery= CartConstants.COST_PER_DELIVERY;
        this.costPerProduct=CartConstants.COST_PER_PRODUCT;
        this.fixedCost=CartConstants.FIXED_COST;
    }

    public static DeliveryCostCalculator getDeliveryCostCalculatorInstance(){
        if (deliveryCostCalculatorInstance==null){
            deliveryCostCalculatorInstance=new DeliveryCostCalculator();
        }
       return deliveryCostCalculatorInstance;
    }

    public double calculate(ShoppingCart shoppingCart){
      long countOfCategory= shoppingCart.getListOfProduct().stream().filter(distinctByKey(p->p.getProduct().getCategory().getTitle())).count();
      int countOfPerProduct= shoppingCart.getListOfProduct().size();
      return this.costPerDelivery*countOfCategory+this.costPerProduct*countOfPerProduct+this.fixedCost;
    }
}
