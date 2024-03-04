package almacen;
import java.util.ArrayList;
public class Almacen implements IAlmacen{
    private ArrayList<ProductoAlmacenado> productos = new ArrayList<>();
    private static int stockAlmacen = 0;
    public Almacen() {
        super();
    }
    public int getStockAlmacen() {
        return stockAlmacen;
    }
    @Override
    public int buscarProducto(Producto producto){
        for(int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getProducto().equals(producto)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public int insertarProducto(Producto producto, int stock, double precio) {
        ProductoAlmacenado p = new ProductoAlmacenado(producto, stock, precio);
        if (stock > 0 && precio > 0 && !(stockAlmacen + p.getStock() > 1000)) {
            productos.add(p);
            stockAlmacen += p.getStock();
            return 0;
        }
        return 1;
    }
    @Override
    public void comprobarStock(Producto producto) {
        int encontrado = buscarProducto(producto);

        if (encontrado == -1) {
            System.out.println("El producto no tiene stock");
        } else {
            System.out.println(productos.get(encontrado).toString());
        }
    }
    @Override
    public int sacarStock(Producto producto, int pedirStock) {
        int indexProducto = buscarProducto(producto);
        if (indexProducto == -1) {
            return -1;
        }

        int viejoStock = productos.get(indexProducto).getStock();
        int nuevoStock = viejoStock - pedirStock;

        if (nuevoStock < 0) {
            nuevoStock = 0;
            System.out.println("Solo se han podido coger " + viejoStock + " existencias");
        }
        productos.get(indexProducto).setStock(nuevoStock);
        stockAlmacen = stockAlmacen - (viejoStock - nuevoStock);
        return viejoStock - nuevoStock;
    }

}

