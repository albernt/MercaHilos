import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Cliente[] clientes = new Cliente[5];

        // Crear 5 clientes
        for (int i = 0; i < 5; i++) {
            clientes[i] = new Cliente("Cliente " + (i + 1), random.nextInt(5) + 1);
        }

        // Procesar cada cliente asignándolo a una caja
        for (Cliente cliente : clientes) {
            if (random.nextBoolean()) {
                new Thread(new CajaRunnable(1, cliente)).start();
            } else {
                new Thread(new CajaRunnable(2, cliente)).start();
            }
        }
    }
}

// Runnable para cajas
class CajaRunnable implements Runnable {
    private int numeroCaja;
    private Cliente cliente;

    public CajaRunnable(int numeroCaja, Cliente cliente) {
        this.numeroCaja = numeroCaja;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        System.out.println("El cliente " + cliente.getNombre() + " ha sido atendido en la caja " + numeroCaja);
        for (Producto producto : cliente.getCarrito()) {
            System.out.println("El cliente " + cliente.getNombre() + " compra: " + producto.getNombre());
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Caja " + numeroCaja + ": " + cliente.getNombre() + " procesado");
    }
}
