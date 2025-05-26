import java.util.Random;

public class LockerGrid {
    private final int ROWS_NUMBER = 10;
    private final int COLUMNS_NUMBER = 20;
    private final Locker[][] lockers;
    private final Random random;

    public LockerGrid() {
        random = new Random();
        lockers = new Locker[ROWS_NUMBER][COLUMNS_NUMBER];

        int lockerCounter = 1;

        for (int i = 0; i < ROWS_NUMBER; i++) {
            for (int j = 0; j < COLUMNS_NUMBER; j++) {
                lockers[i][j] = new Locker();
                lockers[i][j].setLockerID(lockerCounter);
                lockerCounter++;
            }
        }
    }

    public Locker getLocker() {
        int row = random.nextInt(ROWS_NUMBER);
        int column = random.nextInt(COLUMNS_NUMBER);

        return lockers[row][column];
    }

    public Locker getLockerByOrder(int orderNumber) {
        for (int i = 0; i < ROWS_NUMBER; i++) {
            for (int j = 0; j < COLUMNS_NUMBER; j++) {
                Order order = lockers[i][j].getOrder();
                if (order != null && order.getOrderNumber() == orderNumber){
                    return lockers[i][j];
                }
            }
        }

        return null;
    }
}
