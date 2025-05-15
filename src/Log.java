import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Log implements Runnable {
    private final ECommerceManagment eCommerceManagment;

    public Log(ECommerceManagment eCommerceManagment) {
        this.eCommerceManagment = eCommerceManagment;
    }

    @Override
    public void run() {
        int orderCounter = 0;
        int totalOrders = 500;

        while (orderCounter < totalOrders) {
            int filedOrders = geteECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.FILED_ORDERS).getSizeRegister();
            int verifiedOrders = geteECommerceManagment().getRegistersContainer().getOrderRegister(ORDER_STATE.VERIFIED_ORDERS).getSizeRegister();

            orderCounter = filedOrders + verifiedOrders;

            takeRegister(filedOrders, verifiedOrders);

            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void takeRegister(int filedOrders, int verifiedOrders) {
        String nombreArchivo = "log.txt"; // archivo en la raíz del proyecto
        File archivo = new File(nombreArchivo);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write("[" + timestamp + "] \n");
            writer.write("Pedidos Fallidos: " + filedOrders + "\n");
            writer.write("Pedidos Verificados: " + verifiedOrders + "\n");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el log: " + e.getMessage());
        }
    }

    public ECommerceManagment geteECommerceManagment() {
        return eCommerceManagment;
    }
}
