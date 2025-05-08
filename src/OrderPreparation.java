public class OrderPreparation implements Runnable {
    private final OrderGenerator orderGenerator;
    private final ECommerceManagment eCommerceManagment;
    public OrderPreparation(OrderGenerator orderGenerator, ECommerceManagment eCommerceManagment) {
        this.orderGenerator = orderGenerator;
        this.eCommerceManagment = eCommerceManagment;
    }

    @Override
    public void run() {

    }

    private boolean checkLocker(Locker locker){
        return false;
    }

    public OrderGenerator getOrderGenerator() {
        return orderGenerator;
    }

    public ECommerceManagment geteCommerceManagment() {
        return eCommerceManagment;
    }
}
