// Subsystem: Payment
public class PaymentService {
    public boolean charge(String orderId, double amount) {
        System.out.println("[Payment] Charging $" + amount + " for order " + orderId);
        return true;
    }
    public void refund(String orderId, double amount) {
        System.out.println("[Payment] Refunding $" + amount + " for order " + orderId);
    }
}
