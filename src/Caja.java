import java.util.concurrent.TimeUnit;

class Caja implements Runnable {
    private int numero;
    private Cliente cliente;

    public Caja(int numero) {
        this.numero = numero;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        if (cliente == null) {
            System.out.println("Caja " + numero + " no tiene cliente asignado.");
            return;
        }
        System.out.println("El cliente " + cliente.getNombre() + " ha sido atendido en la caja " + this.numero);
        long initialTime = System.currentTimeMillis();
        for (Producto producto : cliente.getCarrito()) {
            System.out.println("El cliente " + cliente.getNombre() + " compra: " + producto.getNombre());
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Caja " + numero + ": Producto " + producto.getNombre() + " procesado en "
                    + (System.currentTimeMillis() - initialTime) + " ms");
        }
        System.out.println("Caja " + numero + ": Cliente " + cliente.getNombre() + " procesado");
    }
}
