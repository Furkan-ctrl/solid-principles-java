// OCP Practice Exercise — starter code. Refactor this so adding a new
// customer tier never requires editing DiscountCalculator again.
// See README.md in this folder for the full task and requirements.

interface DiscountPolicy{
    double apply(double amount);
}

class RegularCustomerDiscount implements DiscountPolicy{

    @Override
    public double apply(double amount) {
        return 0.0;
    }
}

class PremiumCustomerDiscount implements DiscountPolicy{

    @Override
    public double apply(double amount) {
        return amount * 0.10;
    }
}

class VipCustomerDiscount implements DiscountPolicy{

    @Override
    public double apply(double amount) {
        return amount * 0.20;
    }
}

class StudentCustomerDiscount implements DiscountPolicy {
    @Override
    public double apply(double amount) {
        return amount * 0.15;
    }
}

class PricingService{
    public double calculateFinalPrice(double orderTotal, DiscountPolicy policy) {
        double discount = policy.apply(orderTotal);
        return orderTotal - discount;
    }
}

public class Starter {
    public static void main(String[] args) {

        PricingService pricingService = new PricingService();
        double orderAmount = 100.00;

        RegularCustomerDiscount regular = new RegularCustomerDiscount();  // Can we write all of them as DiscountPolicy objects?
        PremiumCustomerDiscount premium = new PremiumCustomerDiscount();
        VipCustomerDiscount vip = new VipCustomerDiscount();
        StudentCustomerDiscount student = new StudentCustomerDiscount();

        System.out.printf("Regular customer total: $%.2f%n", pricingService.calculateFinalPrice(orderAmount, regular));
        System.out.printf("Premium customer total: $%.2f%n", pricingService.calculateFinalPrice(orderAmount, premium));
        System.out.printf("VIP customer total:     $%.2f%n", pricingService.calculateFinalPrice(orderAmount, vip));
        System.out.printf("Student customer total: $%.2f%n", pricingService.calculateFinalPrice(orderAmount, student));

        // Marketing just asked for a "student" tier at 15% off.
        // Can you add it without touching DiscountCalculator?
    }
}
