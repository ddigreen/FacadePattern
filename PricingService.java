// Subsystem: Pricing
public class PricingService {
    public double total(String sku, int qty) {
        double unit = 19.99; // pretend catalog price
        return unit * qty;
    }
}
