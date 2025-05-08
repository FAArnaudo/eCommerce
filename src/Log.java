public class Log implements Runnable {
    private final ECommerceManagment eCommerceManagment;

    public Log(ECommerceManagment eCommerceManagment) {
        this.eCommerceManagment = eCommerceManagment;
    }

    @Override
    public void run() {

    }

    private void takeRegister() {

    }

    public ECommerceManagment geteCommerceManagment() {
        return eCommerceManagment;
    }
}
