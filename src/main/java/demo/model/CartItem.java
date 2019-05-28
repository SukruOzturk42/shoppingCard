package demo.model;

public class CartItem {
    private Product product;
    private  int item;

    public CartItem(Product product, int item) {
        this.product = product;
        this.item = item;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", item=" + item +
                '}';
    }
}
