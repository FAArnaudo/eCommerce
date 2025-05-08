public class OrderDispatch implements Runnable {
    private final ECommerceManagment eCommerceManagment;

    public OrderDispatch(ECommerceManagment eCommerceManagment) {
        this.eCommerceManagment = eCommerceManagment;
    }

    @Override
    public void run() {

    }

    private boolean verifyOrderAndUser(Order order) {
        return false;
    }

    public ECommerceManagment geteCommerceManagment() {
        return eCommerceManagment;
    }
}
