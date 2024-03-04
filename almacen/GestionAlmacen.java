package almacen;
import java.util.Scanner;

public class GestionAlmacen {
    public static Scanner sc = new Scanner(System.in);
    public static Almacen almacen = new Almacen();
    public static void main(String[] args) {
        Producto p = new Producto("fresas","23/12/2025",10);
        int insertar = almacen.insertarProducto(p, 100, 12);

        if (insertar == 1) {
            System.out.println("ERROR");
        } else {
            almacen.comprobarStock(p);
            System.out.println(almacen.getStockAlmacen());
            almacen.sacarStock(p,10);
            almacen.comprobarStock(p);
            System.out.println(almacen.getStockAlmacen());
            almacen.sacarStock(p,92);
            almacen.comprobarStock(p);
            System.out.println(almacen.getStockAlmacen());
        }

    }
}
