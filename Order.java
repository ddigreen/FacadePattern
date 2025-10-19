// Simple data class for an order
public class Order {
    private final String orderId;
    private final String sku;
    private final int quantity;
    private final String customerEmail;
    private final String address;
    private boolean reserved;
    private boolean paid;
    private String shipmentId;

    public Order(String orderId, String sku, int quantity, String customerEmail, String address) {
        this.orderId = orderId;
        this.sku = sku;
        this.quantity = quantity;
        this.customerEmail = customerEmail;
        this.address = address;
    }

    public String getOrderId() { return orderId; }
    public String getSku() { return sku; }
    public int getQuantity() { return quantity; }
    public String getCustomerEmail() { return customerEmail; }
    public String getAddress() { return address; }
    public boolean isReserved() { return reserved; }
    public void setReserved(boolean reserved) { this.reserved = reserved; }
    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }
    public String getShipmentId() { return shipmentId; }
    public void setShipmentId(String shipmentId) { this.shipmentId = shipmentId; }
}
