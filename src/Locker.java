public class Locker {
    private int lockerID;
    private LOCKER_STATES state;
    private int counter;
    private Order order;

    public Locker() {
        setState(LOCKER_STATES.EMPTY);
        order = null;
        counter = 0;
    }

    public LOCKER_STATES getState() {
        return state;
    }

    public void setState(LOCKER_STATES state) {
        this.state = state;
    }

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        this.counter++;
    }

    public int getLockerID() {
        return lockerID;
    }

    public void setLockerID(int lockerID) {
        this.lockerID = lockerID;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
