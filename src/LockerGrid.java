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

        Locker locker = lockers[row][column];

        if (!locker.isTaken()) {
            locker.setTaken(true);
        } else {
            locker = null;
        }

        return locker;
    }
}
