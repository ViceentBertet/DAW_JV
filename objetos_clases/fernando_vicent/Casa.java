package objetos_clases.fernando_vicent;

import java.util.Locale;

public class Casa {

    private String calle;
    private int nombre;
    private String poblacion;
    private double superficie;
    private static final double SUPERFICIE_MINIMA = 43.5;
    private boolean garaje;
    private int antiguedad;
    public static int contador;
    public Casa() {
        super();
        incrementandoContadorCasas();
    }
    public Casa (String calle, int nombre, String poblacion) {
        this();
        this.calle = calle;
        this.nombre = nombre;
        this.poblacion = poblacion;
    }
    public Casa(String calle, int nombre, String poblacion, double superficie, boolean garaje, int antiguedad) {
        this(calle, nombre, poblacion);
        this.superficie = superficie;
        this.garaje = garaje;
        this.antiguedad = antiguedad;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public int getNombre() {
        return nombre;
    }
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    public String getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
    public double getSuperficie() {
        return superficie;
    }
    public void setSuperficie(double superficie) {
        if (superficie > SUPERFICIE_MINIMA) {
            this.superficie = superficie;
        } else {
            System.out.println("Se ha establecido la superfie minima de 43,5 m cuadrados");
            this.superficie = SUPERFICIE_MINIMA;
        }
    }
    public boolean getGaraje() {
        return garaje;
    }
    public void setGaraje(boolean garaje) {
        this.garaje = garaje;
    }
    public int getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    public void getAdressaCompleta() {
        if (Qutil.esVocal(this.poblacion)) {
            System.out.printf("\nC/ %s nº %d d'%s", this.calle, this.nombre, this.poblacion);
        } else {
            System.out.printf("\nC/ %s nº %d de %s", this.calle, this.nombre, this.poblacion);
        }
    }
    public void getInfo() {
        this.getAdressaCompleta();
        if (this.garaje) {
            System.out.printf(", si tiene garaje, tiene %.2f metros cuadrados y con una antiguedad de %d años.", this.superficie, this.antiguedad);
        } else {
            System.out.printf(", no tiene garaje, tiene %.2f metros cuadrados y con una antiguedad de %d años.", this.superficie, this.antiguedad);
        }
    }
    public String toString(){
        String datos;
        if (this.garaje) {
            datos = "C/ " + this.calle + ", nº " + this.nombre + " " + this.poblacion + " superficie=" + this.superficie + " té garatge, edat=" + this.antiguedad;
        } else {
            datos = "C/ " + this.calle + ", nº " + this.nombre + " " + this.poblacion + " superficie=" + this.superficie + " no té garatge, edat=" + this.antiguedad;
        }

        return datos;
    }
    public static int getContador() {
        return contador;
    }
    public static void incrementandoContadorCasas() {
        contador++;
    }

}
