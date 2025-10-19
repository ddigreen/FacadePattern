// Subsystem: Inventory
public class InventoryService {
    public boolean isInStock(String sku, int qty) {
        System.out.println("[Inventory] Checking stock for " + sku + " qty " + qty);
        return true; // pretend always available
    }
    public boolean reserve(String sku, int qty) {
        System.out.println("[Inventory] Reserving " + qty + " of " + sku);
        return true;
    }
    public void release(String sku, int qty) {
        System.out.println("[Inventory] Releasing reservation for " + qty + " of " + sku);
    }
}
