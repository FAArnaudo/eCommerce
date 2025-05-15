import java.util.concurrent.TimeUnit;

public class OrderPreparation implements Runnable {
    private final OrderGenerator orderGenerator;
    private final ECommerceManagment eCommerceManagment;
    private int ordersProcessed;

    public OrderPreparation(OrderGenerator orderGenerator, ECommerceManagment eCommerceManagment) {
        this.orderGenerator = orderGenerator;
        this.eCommerceManagment = eCommerceManagment;
    }

    @Override
    public void run() {
        while (true) {
            Locker locker = getECommerceManagment().getLockerGrid().getLocker();
            Order order = null;

            if (checkLocker(locker)) {
                locker.incrementCounter();
                order = getOrderGenerator().getOrder();
                order.setTaken(false);
                getECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.ORDERS_IN_PREPARATION).addOrder(order);

                incrementOrdersProcessed();

                /*synchronized (this){
                    System.out.println("Orden en preparacion: " + getOrdersProcessed());
                }*/

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

    private boolean checkLocker(Locker locker) {
        boolean isLockerOk = false;

        synchronized (locker) {
            if (!locker.isTaken()) {
                locker.setTaken(true);
                isLockerOk = true;
            }
        }

        return isLockerOk;
    }

    public OrderGenerator getOrderGenerator() {
        return orderGenerator;
    }

    public ECommerceManagment getECommerceManagment() {
        return eCommerceManagment;
    }

    public void checkOrdersProcessed() throws InterruptedException {
        if (getOrdersProcessed() == 200) {
            throw new InterruptedException();
        }
    }

    public synchronized void incrementOrdersProcessed() {
        ordersProcessed++;
    }

    public synchronized int getOrdersProcessed() {
        return ordersProcessed;
    }

}
