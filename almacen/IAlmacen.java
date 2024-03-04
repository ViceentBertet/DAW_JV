package almacen;

public interface IAlmacen {
    int buscarProducto(Producto producto);
    int insertarProducto(Producto producto, int stock, double precio);
    void comprobarStock(Producto producto);
    int sacarStock(Producto producto, int pedirStock);
}
