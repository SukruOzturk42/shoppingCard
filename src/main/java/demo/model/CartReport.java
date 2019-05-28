package demo.model;

import java.util.HashMap;
import java.util.Map;

public class CartReport {
    private ShoppingCart shoppingCart;
    private  double totalAmount=0.0;
    private  double couponDiscount=0.0;
    private Map<String,Double> campaignDiscountMap;
    private  double deliveryCost=0.0;

    public CartReport() {
    }

    public CartReport(ShoppingCart shoppingCart, double totalAmount, double couponDiscount,double deliveryCost) {
        this.shoppingCart = shoppingCart;
        this.totalAmount = totalAmount;
        this.couponDiscount = couponDiscount;
        this.deliveryCost = deliveryCost;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount += totalAmount;
    }

    public double getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public Map<String, Double> getCampaignDiscountMap() {
        return campaignDiscountMap;
    }

    public void setCampaignDiscountMap(Map<String, Double> campaignDiscountMap) {
        this.campaignDiscountMap = campaignDiscountMap;
    }

    public void addCampaignDiscountMap(String category,double value){
        if(campaignDiscountMap==null)
            campaignDiscountMap=new HashMap<>();
        campaignDiscountMap.put(category,value);
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }
}
