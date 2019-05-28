package demo.model;

public class Campaign {
    private Category category;
    private int discountRate;
    private int minNumberOfItem;
    private DiscountType discountType;

    public Campaign() {
    }

    public Campaign(Category category, int discountRate, int minNumberOfItem, DiscountType discountType) {
        this.category = category;
        this.discountRate = discountRate;
        this.minNumberOfItem = minNumberOfItem;
        this.discountType = discountType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getMinNumberOfItem() {
        return minNumberOfItem;
    }

    public void setMinNumberOfItem(int minNumberOfItem) {
        this.minNumberOfItem = minNumberOfItem;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
