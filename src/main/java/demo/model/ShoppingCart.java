package demo.model;

import demo.service.DeliveryCostCalculator;

import java.util.*;
import java.util.stream.Collectors;

public class ShoppingCart {

    private List<CartItem> listOfProduct;
    private CartReport cartReport;

    public ShoppingCart() {
        listOfProduct=new ArrayList<>();
        cartReport=new CartReport();
    }

    public ShoppingCart(List<CartItem> listOfProduct, CartReport cartReport) {
        this.listOfProduct = listOfProduct;
        this.cartReport = cartReport;
    }

    public void addItem(Product product, int item) {
        cartReport.setTotalAmount(product.getPrice()*item);
        Optional<CartItem> cartItem = listOfProduct.stream().filter(i->i.getProduct().getTitle().equals(product.getTitle())).findAny();
        if (cartItem.isPresent()) {
            listOfProduct.remove(cartItem);
            listOfProduct.add(new CartItem(product,cartItem.get().getItem()+item));
        } else {
            listOfProduct.add(new CartItem(product, item));
        }
    }

    public List<CartItem> getListOfProduct() {
        return listOfProduct;
    }

    public void setListOfProduct(List<CartItem> listOfProduct) {
        this.listOfProduct = listOfProduct;
    }

    public void applyDiscount(Campaign... campaigns){

        Arrays.asList(campaigns).stream().forEach(i->{
          List<CartItem> filteredItems= this.listOfProduct.stream().filter(t->t.getProduct().getCategory().equals(i.getCategory())).collect(Collectors.toList());
          if(filteredItems.size()>i.getMinNumberOfItem()){
             List<Double> discountList =i.getDiscountType().equals(DiscountType.Rate)?
                     filteredItems.stream().map(k->k.getProduct().getPrice()*k.getItem()*i.getDiscountRate()/100).collect(Collectors.toList())
                     : filteredItems.stream().map(k->k.getProduct().getPrice()*k.getItem()-i.getDiscountRate()).collect(Collectors.toList());
             discountList.sort(Comparator.comparing(Double::byteValue));
             cartReport.addCampaignDiscountMap(i.getCategory().getTitle(),discountList.get(0));
          }
        });
    }

    public double getTotalAmountAfterDiscount(){
        return cartReport.getTotalAmount()-this.getTotalDiscounts();
    }

    public  void applyCoupon(Coupon coupon){
        if (cartReport.getTotalAmount()>=coupon.getMinPurchaseAmount())
            cartReport.setCouponDiscount(cartReport.getTotalAmount()*coupon.getDiscountRate()/100);
    }
    public double getTotalDiscounts(){
        return this.getCampaignDiscount()+ getCouponDiscount();
    }

    public double getCouponDiscount(){
        return cartReport.getCouponDiscount();
    }

    public double getCampaignDiscount(){
        return cartReport.getCampaignDiscountMap().values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public double getDeliveryCost(){
        return  DeliveryCostCalculator.getDeliveryCostCalculatorInstance().calculate(this);
    }

    public void print(){
      List<CartItem> sortedListByCategory= this.getListOfProduct().stream().sorted(Comparator.comparing(i->i.getProduct().getCategory().getTitle())).collect(Collectors.toList());
        sortedListByCategory.forEach(i->{
            System.out.println(i);
            System.out.println("Total Price="+i.getProduct().getPrice()*i.getItem());
        });
        cartReport.getCampaignDiscountMap().keySet().stream().forEach(i->{
            System.out.println("Campaign for category "+i+"="+cartReport.getCampaignDiscountMap().get(i));
        });
        System.out.println("Total coupon discount="+cartReport.getCouponDiscount());
        System.out.println("Total Discount="+this.getTotalDiscounts());
        System.out.println("Total Amount="+this.getTotalAmountAfterDiscount()+" Delivery Cost="+this.getDeliveryCost());
    }
}
