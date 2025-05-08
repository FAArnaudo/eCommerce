public class ECommerceManagment {
    private final LockerGrid lockerGrid;
    private final RegistersContainer registersContainer;

    public ECommerceManagment(LockerGrid lockerGrid, RegistersContainer registersContainer) {
        this.lockerGrid = lockerGrid;
        this.registersContainer = registersContainer;
    }

    public LockerGrid getLockerGrid() {
        return lockerGrid;
    }

    public RegistersContainer getRegistersContainer() {
        return registersContainer;
    }
}
