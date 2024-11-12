class Cliente {
    private String nombre;
    private Producto[] carrito;

    public Cliente(String nombre, Producto[] carrito) {
        this.nombre = nombre;
        this.carrito = carrito;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto[] getCarrito() {
        return carrito;
    }
}