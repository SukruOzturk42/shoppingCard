
import demo.model.*;
import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
public class ShoppingCartTest {
    private  ShoppingCart cart;

    @BeforeEach
    public void init() {
        //sample a creating category;
        Category food=new Category("food");
        Category tech=new Category("tech");
        //products
        Product apple=new Product("Apple",100.0,food);
        Product banana=new Product("Banana",110.0,food);
        Product juice=new Product("Juice",115.0,food);
        Product almond=new Product("Almonds",150.0,food);
        Product computer=new Product("PC",100.0,tech);

        cart=new ShoppingCart();
        cart.addItem(apple,3);
        cart.addItem(banana,3);
        cart.addItem(juice,4);
        cart.addItem(almond,1);
        cart.addItem(computer,1);

        //Discount
        Campaign campaign1=new Campaign(food,20,2, DiscountType.Rate);
        //Discount
        Campaign campaign2=new Campaign(food,20,2,DiscountType.Amount);

        //a coupon to card.
        Coupon coupon=new Coupon(100,10,DiscountType.Rate);
        cart.applyDiscount(campaign1,campaign2);
        cart.applyCoupon(coupon);
    }

    @Test
    void testTotalDiscount() {
        double expected=264.0;
        assertEquals(expected, cart.getCouponDiscount());
    }

    @Test
    void testDelivertCost() {
        double expected=8.190;
        assertEquals(expected, cart.getDeliveryCost());
    }

    @Test
    void testCampaignCost() {
        double expected=134.0;
        assertEquals(expected, cart.getCampaignDiscount());
    }



}
