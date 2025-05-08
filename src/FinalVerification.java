public class FinalVerification implements Runnable {
    private final ECommerceManagment eCommerceManagment;

    public FinalVerification(ECommerceManagment eCommerceManagment) {
        this.eCommerceManagment = eCommerceManagment;
    }


    @Override
    public void run() {

    }

    private boolean verifyOrder(Order order) {
        return false;
    }

    public ECommerceManagment geteCommerceManagment() {
        return eCommerceManagment;
    }
}
