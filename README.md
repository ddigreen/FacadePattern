# Facade Pattern — Online Shop Example

This project demonstrates the **Facade** design pattern in Java with a simple online shopping flow.

## Structure

- `ShopFacade` — the **Facade** that exposes a simplified API: `placeOrder(Order)` and `cancelOrder(Order)`.
- Subsystems:
  - `InventoryService` — stock verification & reservation
  - `PricingService` — price calculation
  - `PaymentService` — charge & refund
  - `ShippingService` — shipment creation & cancellation
  - `NotificationService` — email notifications
- `Order` — value object for order details
- `FacadeDemo` — client entry point

## How to run

```bash
javac *.java
java FacadeDemo
```

## PlantUML

```plantuml
@startuml
class ShopFacade {
  +placeOrder(order: Order): boolean
  +cancelOrder(order: Order): void
}

class InventoryService
class PricingService
class PaymentService
class ShippingService
class NotificationService

class Order {
  -orderId: String
  -sku: String
  -quantity: int
  -customerEmail: String
  -address: String
  -reserved: boolean
  -paid: boolean
  -shipmentId: String
}

ShopFacade --> InventoryService
ShopFacade --> PricingService
ShopFacade --> PaymentService
ShopFacade --> ShippingService
ShopFacade --> NotificationService
ShopFacade --> Order

@enduml
```
