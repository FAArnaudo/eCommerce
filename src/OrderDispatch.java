import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class OrderDispatch implements Runnable {
    private final ECommerceManagment eCommerceManagment;
    private final Random random;
    private int ordersProcessed;

    public OrderDispatch(ECommerceManagment eCommerceManagment) {
        this.eCommerceManagment = eCommerceManagment;
        random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            Locker locker = null;
            Order order = getECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.ORDERS_IN_PREPARATION).getOrder();

            if (order != null && verifyOrderAndUser(order)) {
                getECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.ORDERS_IN_PREPARATION).deleteOrder(order);
                locker = getECommerceManagment().getLockerGrid().getLockerByOrder(order.getOrderNumber());
                locker.setOrder(null);
                locker.setState(LOCKER_STATES.EMPTY);
                getECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.ORDERS_IN_TRANSIT).addOrder(order);

                incrementOrdersProcessed();

                try {
                    TimeUnit.MILLISECONDS.sleep(60);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else if (order != null) {
                getECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.ORDERS_IN_PREPARATION).deleteOrder(order);
                locker = getECommerceManagment().getLockerGrid().getLockerByOrder(order.getOrderNumber());
                locker.setOrder(null);
                locker.setState(LOCKER_STATES.OUT_OF_SERVICE);
                getECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.FILED_ORDERS).addOrder(order);

                incrementOrdersProcessed();

                try {
                    TimeUnit.MILLISECONDS.sleep(75);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            try {
                checkOrdersProcessed();
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private boolean verifyOrderAndUser(Order order) {
        boolean pass = false;
        double probability = random.nextInt(100);

        if (probability < 85) {
            pass = true;
        }
        return pass;
    }

    public ECommerceManagment getECommerceManagment() {
        return eCommerceManagment;
    }

    public void checkOrdersProcessed() throws InterruptedException {
        if (getOrdersProcessed() == 500) {
            throw new InterruptedException();
        }
    }

    public synchronized void incrementOrdersProcessed() {
        ordersProcessed++;
        System.out.println("Orden despachado " + ordersProcessed);
    }

    public synchronized int getOrdersProcessed() {
        return ordersProcessed;
    }
}
