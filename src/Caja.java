import javax.tools.StandardLocation;
import java.util.concurrent.TimeUnit;

public class Caja {
    private int numero;
    private Cliente clienteActual;

    public Caja(int numero) {
        this.numero = numero;

    }

    public void cobrar(Cliente cliente) {
        clienteActual = cliente;
        System.out.println("El cliente " + clienteActual.getNombre() + " ha sido atendido en la caja " + this.numero);
        for(Producto producto : clienteActual.getCarrito()) {
            System.out.println("El cliente " + clienteActual.getNombre() + " compra: " + producto.getNombre());
            try{
                TimeUnit.MILLISECONDS.sleep(1000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.println("Caja " + numero + ": Producto " + producto.getNombre() + " procesado en " + (System.currentTimeMillis() - this.initialTime) + " ms");
        }
        System.out.println("Caja " + numero + ": Cliente " + cliente.getNombre() + " procesado");
    }

    private long initialTime = System.currentTimeMillis();





}
