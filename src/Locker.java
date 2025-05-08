public class Locker {
    private int lockerID;
    private LOCKER_STATES state;
    private int counter;
    private boolean isTaken;

    public Locker() {
        setState(LOCKER_STATES.EMPTY);
        setCounter(0);
        setTaken(false);
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

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public int getLockerID() {
        return lockerID;
    }

    public void setLockerID(int lockerID) {
        this.lockerID = lockerID;
    }
}
