import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Random;

public class OrderGenerator {
    private int orderCounter;
    private final Random random;
    private final ArrayList<Order> orders;

    public OrderGenerator(int ORDERS_MAX_NUMBER) {
        random = new Random();
        orders = new ArrayList<>();

        for (int i = 0; i < ORDERS_MAX_NUMBER; i++) {
            Order order = new Order();
            order.setOrderNumber(i + 1);
            System.out.println("Order: " + (i + 1));
            orders.add(order);
        }

        orderCounter = ORDERS_MAX_NUMBER;
    }

    public Order getOrder() {
        synchronized (this) {
            if (orderCounter > 0) {
                int orderNumber = random.nextInt(orderCounter);
                Order order = orders.get(orderNumber);
                order.setTaken(true);
                orders.remove(orderNumber);
                orderCounter--;
                return order;
            }
        }
        return null;
    }

    public synchronized int getOrderCounter() {
        return orderCounter;
    }

    public synchronized void setOrderCounter() {
        this.orderCounter--;
    }
}
