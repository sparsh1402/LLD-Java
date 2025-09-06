package org.lld.designPrinciples;

import java.util.concurrent.ConcurrentHashMap;

public class OrderRepository {
    private final ConcurrentHashMap<String , Order> orderMap = new ConcurrentHashMap<>();
    public void save(Order order){
        orderMap.put(order.getOrderId(), order);
    }
    public Order findById(String orderId){
        return orderMap.get(orderId);
    }
}
