import java.util.ArrayList;
import java.util.Random;

public class OrdersRegister {
    private ArrayList<Order> orders;
    private Random random;
    public OrdersRegister() {
    }

    /**
     *
     * */
    public void addOrder(Order order){
        orders.add(order);
    }

    public Order getOrder(){
        Order order = null;
        int orderNumber = random.nextInt(getSizeRegister());

        order = orders.get(orderNumber);

        return order;
    }

    public  boolean deleteOrder(Order order){
        return orders.remove(order);
    }

    public int getSizeRegister(){
        return orders.size();
    }
}
