public class RegistersContainer {

    private OrdersRegister inPreparation;
    private OrdersRegister inTransit;
    private OrdersRegister filed;
    private OrdersRegister delivered;
    public RegistersContainer() {
        inPreparation = new OrdersRegister();
        inTransit = new OrdersRegister();
        filed = new OrdersRegister();
        delivered = new OrdersRegister();
    }

    public OrdersRegister getOrderRegister(ORDER_STATE state){
        switch (state){
            case ORDER_IN_PREPARATION:
                return inPreparation;
            case ORDER_IN_TRANSIT:
                return inTransit;
            case FILED_ORDER:
                return filed;
            case ORDER_DELIVERED:
                return delivered;
        }
        return null;
    }
}
