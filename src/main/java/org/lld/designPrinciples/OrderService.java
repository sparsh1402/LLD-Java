package org.lld.designPrinciples;

import java.util.logging.Logger;

public class OrderService {
    private static final Logger logger = Logger.getLogger(OrderService.class.getName());
    private final OrderRepository repository;
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }
    public void placeOrder(Order order) {
        try{
            if(order.getQuantity() <= 0){
                throw new IllegalArgumentException("Quantity must be greater than zero");
            }
            repository.save(order);
            logger.info("Order placed successfully: " + order);
        }catch (Exception e){
            logger.severe("Failed to place order: " + e.getMessage());
        }
    }
    public void getOrder(String orderId) {
        Order order = repository.findById(orderId);
        if (order != null) {
            logger.info("Order found: " + order);
        }else{
            logger.warning("Order not found with ID: " + orderId);
        }
    }
}
