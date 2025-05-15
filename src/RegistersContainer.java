public class RegistersContainer {

    private final OrdersRegister inPreparation;
    private final OrdersRegister inTransit;
    private final OrdersRegister filed;
    private final OrdersRegister delivered;
    private final OrdersRegister verified;
    public RegistersContainer() {
        inPreparation = new OrdersRegister();
        inTransit = new OrdersRegister();
        filed = new OrdersRegister();
        delivered = new OrdersRegister();
        verified = new OrdersRegister();
    }

    public OrdersRegister getOrderRegister(ORDER_STATE state){
        switch (state){
            case ORDERS_IN_PREPARATION:
                return inPreparation;
            case ORDERS_IN_TRANSIT:
                return inTransit;
            case FILED_ORDERS:
                return filed;
            case DELIVERED_ORDERS:
                return delivered;
            case VERIFIED_ORDERS:
                return verified;
        }
        return null;
    }
}
