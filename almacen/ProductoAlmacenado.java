package almacen;

public class ProductoAlmacenado {
    private final Producto producto;
    private int stock;
    private double precio;
    public ProductoAlmacenado(Producto producto, int stock, double precio) {
        this.producto = producto;
        this.stock = stock;
        this.precio = precio;
    }
    public Producto getProducto() {
        return producto;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ProductoAlmacenado{" +
                "producto=" + producto.getNombre() +
                ", stock=" + stock +
                ", precio=" + precio +
                '}';
    }
}
