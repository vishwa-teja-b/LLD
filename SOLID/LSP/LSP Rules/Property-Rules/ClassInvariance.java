// package SOLID.LSP.LSP Rules.Property-Rules;
import java.lang.Math;

class FoodOrder{
    protected int cartTotal;
    private String foodItem;

    public FoodOrder(int cartTotal, String foodItem){
        this.cartTotal = cartTotal;
        this.foodItem = foodItem;    
    }
    2
    // class invariant (rule) - cartTotal >= 0
    public int getFinalTotal(){
        System.out.println("ORDER WITHOUT DISCOUNT (PARENT) .......");
        System.out.println();
        int finalAmount = cartTotal;
        System.out.println("FINAL AMOUNT : "+ finalAmount);
        return Math.max(0, cartTotal);
    }
}

class SwiggyOneOrder extends FoodOrder{
    protected int flatDiscount;

    public SwiggyOneOrder(int cartTotal, int flatDiscount,String foodItem){
        super(cartTotal,foodItem); this.flatDiscount = flatDiscount;
    }

    @Override
    public int getFinalTotal(){
        System.out.println("ORDER WITH FLAT DISCOUNT (CHILD)");
        // return cartTotal - flatDiscount;  // LSP VIOLATION
        int finalAmount = cartTotal - flatDiscount;
        System.out.println("FINAL AMOUNT : "+ finalAmount);
        return Math.max(0,cartTotal-flatDiscount);  // LSP COMPLIANT
    }
}

// class ZomatoGoldOrder extends FoodOrder{
    // similar to SwiggyOneOrder
// }


// AGGREGATION -- PAYMENT CLIENT HAS-A FOODORDER (OBJECT CONNECTION)

class PaymentClient{
    private FoodOrder fo;

    PaymentClient(FoodOrder fo){
        this.fo = fo;
    }

    void doPayment(){
        int finalAmount = fo.getFinalTotal();

        if(finalAmount >= 0) System.out.println("PAYMENT CLIENT PAYING AMOUNT..........");
        else throw new RuntimeException("AMOUNT MUST BE GREATER THAN OR EQUAL TO 0.");
    }
}

/**
 *  PAYMENT CLIENT ------------> FOODORDER  (invariant)
 *                                   |
 *                                   |
 *                               SWIGGYONEORDER  (LSP violation and compliance)
 * 
 */

public class ClassInvariance {
    public static void main(String[] args) {
        FoodOrder order1 = new FoodOrder(199,"Biryani");
        FoodOrder order2 = new SwiggyOneOrder(99,150, "PIZZA");

        PaymentClient client = new PaymentClient(order2);

        client.doPayment();
    }
}
