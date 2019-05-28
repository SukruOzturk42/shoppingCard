package demo.model;

public class Coupon {
    private double minPurchaseAmount;
    private  int discountRate;
    private DiscountType discountType;

    public Coupon() {
    }

    public Coupon(double minPurchaseAmount, int discountRate, DiscountType discountType) {
        this.minPurchaseAmount = minPurchaseAmount;
        this.discountRate = discountRate;
        this.discountType = discountType;
    }

    public double getMinPurchaseAmount() {
        return minPurchaseAmount;
    }

    public void setMinPurchaseAmount(double minPurchaseAmount) {
        this.minPurchaseAmount = minPurchaseAmount;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
