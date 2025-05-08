public class CustomerDelivery implements Runnable {
    private final ECommerceManagment eCommerceManagment;

    public CustomerDelivery(ECommerceManagment eCommerceManagment) {
        this.eCommerceManagment = eCommerceManagment;
    }

    @Override
    public void run() {

    }

    private boolean confirmOrder(Order order) {
        return false;
    }

    public ECommerceManagment geteCommerceManagment() {
        return eCommerceManagment;
    }
}
