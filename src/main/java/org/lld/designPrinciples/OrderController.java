package org.lld.designPrinciples;

public class OrderController {
    public static void main(String[] args) {
        OrderRepository repository = new OrderRepository();
        OrderService service = new OrderService(repository);
        Product laptop = new Product("P1","Laptop", 1000);
        Product phone = new Product("P2","Phone", 500);
        service.placeOrder(new Order("O1" , laptop , 2));
        service.placeOrder(new Order("O2" , phone , 3));
        service.getOrder("O1");
        service.getOrder("O2");
        service.getOrder("O3");


    }
}
