public class Main {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();

        int firstProcess = 3;
        int secondProcess = 0;
        int thirdProcess = 0;
        int fourthProcess = 0;
        int logThread = 0;

        int total = firstProcess + secondProcess + thirdProcess + fourthProcess + logThread;

        final int ORDERS_MAX_NUMBER = 500;

        OrderGenerator orderGenerator = new OrderGenerator(ORDERS_MAX_NUMBER);
        ECommerceManagment eCommerceManagment = new ECommerceManagment(new LockerGrid(), new RegistersContainer());

        OrderPreparation orderPreparation = new OrderPreparation(orderGenerator, eCommerceManagment);
        OrderDispatch orderDispatch = new OrderDispatch(eCommerceManagment);
        CustomerDelivery customerDelivery = new CustomerDelivery(eCommerceManagment);
        FinalVerification finalVerification = new FinalVerification(eCommerceManagment);
        Log log = new Log(eCommerceManagment);

        Thread[] threads = new Thread[total];

        int i = 0;
        int j = firstProcess;

        // Creamos los hilos necesarios con su objeto correspondiente
        for (; i < j; i++) {
            threads[i] = new Thread(orderPreparation);
        }

        j = i + secondProcess;
        for (; i < j; i++) {
            threads[i] = new Thread(orderDispatch);
        }

        j += thirdProcess;
        for (; i < j; i++) {
            threads[i] = new Thread(customerDelivery);
        }

        j += fourthProcess;
        for (; i < j; i++) {
            threads[i] = new Thread(finalVerification);
        }

        j += logThread;
        for (; i < j; i++) {
            threads[i] = new Thread(log);
        }

        // Lanzamiento de los hilos creados
        for (i = 0; i < total; i++) {
            threads[i].start();
        }

        for (i = 0; i < total; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Duración: " + duracion + " ms");
    }
}