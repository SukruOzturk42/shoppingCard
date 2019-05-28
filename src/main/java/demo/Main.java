package demo;

import demo.model.*;

public class Main {

    public static void main(String[] args) {
        //sample a creating category;
	 Category food=new Category("food");
	 Category tech=new Category("tech");
	 //products
        Product apple=new Product("Apple",100.0,food);
        Product banana=new Product("Banana",110.0,food);
        Product juice=new Product("Juice",115.0,food);
        Product almond=new Product("Almonds",150.0,food);
        Product computer=new Product("PC",100.0,tech);

        ShoppingCart cart=new ShoppingCart();
        cart.addItem(apple,3);
        cart.addItem(banana,3);
        cart.addItem(juice,4);
        cart.addItem(almond,1);
        cart.addItem(computer,1);

        //Discount
        Campaign campaign1=new Campaign(food,20,2,DiscountType.Rate);
        //Discount
        Campaign campaign2=new Campaign(food,20,2,DiscountType.Amount);

        //a coupon to card.
        Coupon coupon=new Coupon(100,10,DiscountType.Rate);
        cart.applyDiscount(campaign1,campaign2);
        cart.applyCoupon(coupon);

        cart.print();


    }
}
