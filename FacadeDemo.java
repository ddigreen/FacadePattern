// Client
public class FacadeDemo {
    public static void main(String[] args) {
        ShopFacade shop = new ShopFacade();
        Order order = new Order("1001", "BOOK-123", 2, "user@example.com", "221B Baker Street, London");

        boolean ok = shop.placeOrder(order);
        if (!ok) {
            System.out.println("Order failed.");
            return;
        }

        // simulate a cancel to show the other facade flow
        shop.cancelOrder(order);
    }
}
