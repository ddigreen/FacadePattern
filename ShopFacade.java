// Facade: exposes a simplified API for placing and cancelling orders
public class ShopFacade {
    private final InventoryService inventory = new InventoryService();
    private final PricingService pricing = new PricingService();
    private final PaymentService payment = new PaymentService();
    private final ShippingService shipping = new ShippingService();
    private final NotificationService notify = new NotificationService();

    public boolean placeOrder(Order order) {
        System.out.println("== Placing order " + order.getOrderId() + " ==");
        if (!inventory.isInStock(order.getSku(), order.getQuantity())) {
            notify.sendEmail(order.getCustomerEmail(), "Out of stock",
                    "Sorry, item is not available right now.");
            return false;
        }
        if (!inventory.reserve(order.getSku(), order.getQuantity())) {
            notify.sendEmail(order.getCustomerEmail(), "Reservation failed",
                    "We could not reserve your item.");
            return false;
        }
        order.setReserved(true);

        double amount = pricing.total(order.getSku(), order.getQuantity());
        if (!payment.charge(order.getOrderId(), amount)) {
            inventory.release(order.getSku(), order.getQuantity());
            notify.sendEmail(order.getCustomerEmail(), "Payment failed",
                    "Your payment could not be processed.");
            return false;
        }
        order.setPaid(true);

        String shipmentId = shipping.createShipment(order.getOrderId(), order.getAddress());
        order.setShipmentId(shipmentId);

        notify.sendEmail(order.getCustomerEmail(), "Order confirmed",
                "Your order " + order.getOrderId() + " has been placed. Shipment: " + shipmentId);
        System.out.println("== Order placed successfully ==");
        return true;
    }

    public void cancelOrder(Order order) {
        System.out.println("== Cancelling order " + order.getOrderId() + " ==");
        if (order.getShipmentId() != null) {
            shipping.cancelShipment(order.getShipmentId());
        }
        if (order.isPaid()) {
            double amount = pricing.total(order.getSku(), order.getQuantity());
            payment.refund(order.getOrderId(), amount);
        }
        if (order.isReserved()) {
            inventory.release(order.getSku(), order.getQuantity());
        }
        notify.sendEmail(order.getCustomerEmail(), "Order cancelled",
                "Your order " + order.getOrderId() + " has been cancelled.");
    }
}
