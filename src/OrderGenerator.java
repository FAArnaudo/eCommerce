import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Random;

public class OrderGenerator {
    private final int ORDERS_MAX_NUMBER = 500;
    private int orderCounter;
    private final Random random;
    private final ArrayList<Order> orders;

    public OrderGenerator() {
        random = new Random();
        orders = new ArrayList<>();

        for (int i = 0; i < ORDERS_MAX_NUMBER; i++) {
            Order order = new Order();
            order.setOrderNumber(i);
            orders.add(order);
        }

        orderCounter = ORDERS_MAX_NUMBER;
    }

    public Order getOrder() {
        int orderNumber = random.nextInt(orderCounter);

        Order order = orders.get(orderNumber);

        orders.remove(orderNumber);

        return order;
    }

    public int getOrderCounter() {
        return orderCounter;
    }

    public void setOrderCounter(int orderCounter) {
        this.orderCounter = orderCounter;
    }
}
