import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CustomerDelivery implements Runnable {
    private final ECommerceManagment eCommerceManagment;
    private final Random random;
    private int ordersProcessed;

    public CustomerDelivery(ECommerceManagment eCommerceManagment) {
        this.eCommerceManagment = eCommerceManagment;
        random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            Order order = getECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.ORDERS_IN_TRANSIT).getOrder();

            if (order != null) {
                getECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.ORDERS_IN_TRANSIT).deleteOrder(order);

                if (confirmOrder(order)) {
                    getECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.DELIVERED_ORDERS).addOrder(order);
                } else {
                    getECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.FILED_ORDERS).addOrder(order);
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(120);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            try {
                checkOrders();
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private boolean confirmOrder(Order order) {
        boolean pass = false;
        double probability = random.nextInt(100);

        if (probability < 90) {
            pass = true;
        }
        return pass;
    }

    public ECommerceManagment getECommerceManagment() {
        return eCommerceManagment;
    }

    public void checkOrders() throws InterruptedException {
        int total = getECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.FILED_ORDERS).getSizeRegister();
        total += getECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.VERIFIED_ORDERS).getSizeRegister();
        total += getECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.DELIVERED_ORDERS).getSizeRegister();

        synchronized (this) {
            System.out.println("Ordenes totales " + total);
        }

        if (total == 500) {
            throw new InterruptedException();
        }
    }
}
