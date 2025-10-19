// Subsystem: Shipping
public class ShippingService {
    public String createShipment(String orderId, String address) {
        String shipmentId = "SHP-" + orderId;
        System.out.println("[Shipping] Creating shipment " + shipmentId + " to " + address);
        return shipmentId;
    }
    public void cancelShipment(String shipmentId) {
        System.out.println("[Shipping] Cancelling shipment " + shipmentId);
    }
}
