import java.util.Random;

class Cliente {
    private String nombre;
    private Producto[] carrito;

    public Cliente(String nombre, int numProductos) {
        this.nombre = nombre;
        this.carrito = new Producto[numProductos];
        Random random = new Random();
        for (int i = 0; i < numProductos; i++) {
            String[] productos = {"Leche", "Pan", "Huevos", "Arepas", "Zanahorias", "Kimchi", "Asedías", "Rabanos", "Pepinos", "Aceitunas", "Tomates", "Colacao", "Alubias", "Vinagre", "Sal"};
            this.carrito[i] = new Producto(productos[random.nextInt(productos.length)]);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Producto[] getCarrito() {
        return carrito;
    }
}