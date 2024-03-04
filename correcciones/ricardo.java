package correcciones;
import almacen.*;
import objetos_clases.gestion_biblioteca.Libro;

public class ricardo {
    public static final int LIMITE_ALMACEN = 1000;
    public String almacenarProductos(ProductoAlmacenado producto) {
        int cantidadActual +=producto.getCantidad();

        int exceso = cantidadActual - LIMITE_ALMACEN;
        int cantidadAAnadir = producto.getCantidad() - exceso;

        if (cantidadActual > LIMITE_ALMACEN && cantidadAAnadir > 0) { //limite_almacen = 1000
            producto.setCantidad(cantidadAAnadir);
            almacen.add(producto);
            cantidadActual = getLIMITE_ALMACEN();
            return "No se ha podido añadir todo, pero se añaden  " + cantidadAAnadir + " productos.";
        } else if (cantidadAAnadir = 0) {
            cantidadActual -= producto.getCantidad();
            return "La cantidad total del almacén ha llegado a 1000 unidades. No se puede agregar más productos.";
        } else {
            almacen.add(producto);
            return "\nOperación realizada con éxito";
        }

    }
}
