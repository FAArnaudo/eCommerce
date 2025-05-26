import java.util.ArrayList;
import java.util.Random;

public class OrdersRegister {
    private final ArrayList<Order> orders;
    private final Random random;

    public OrdersRegister() {
        random = new Random();
        orders = new ArrayList<>();
    }

    /**
     *
     */
    public void addOrder(Order order) {
        synchronized (this){
            order.setTaken(false);
            orders.add(order);
        }
    }

    public Order getOrder() {
        Order order;
        int orderNumber;

        synchronized (this){
            if(getSizeRegister() != 0){
                orderNumber = random.nextInt(getSizeRegister());
                order = orders.get(orderNumber);
                if(!order.isTaken()){
                    order.setTaken(true);
                    return order;
                }
            }
        }

        return null;
    }

    public synchronized boolean deleteOrder(Order order) {
        return orders.remove(order);
    }

    public synchronized int getSizeRegister() {
        return orders.size();
    }
}
