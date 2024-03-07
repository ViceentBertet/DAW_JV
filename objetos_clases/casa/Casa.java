package objetos_clases.casa;

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
    public Casa(String calle, int nombre, String poblacion, double superficie, boolean garaje, int antiguedad) throws SuperficieException, EdadException {
        if (superficie > SUPERFICIE_MINIMA) {
            this.superficie = superficie;
        } else {
            throw new SuperficieException("ERROR: La superficie debe ser minimo de 43.5 m2");
        }
        if (antiguedad > 0) {
            this.antiguedad = antiguedad;
        } else {
            throw new EdadException("ERROR: La antiguedad no puede ser inferior a 1");
        }
        this.calle = calle;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.garaje = garaje;

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
    public void setSuperficie(double superficie) throws SuperficieException{
        if (superficie > SUPERFICIE_MINIMA) {
            this.superficie = superficie;
        } else {
            throw new SuperficieException("ERROR: La superficie debe ser minimo de 43.5 m2");
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
    public void setAntiguedad(int antiguedad) throws EdadException{
        if (antiguedad > 0){
            this.antiguedad = antiguedad;
        } else {
            throw new EdadException("ERROR: La antiguedad no puede ser inferior a 1");
        }
    }
    public String getAdressaCompleta() {
        String datos;
        if (Qutil.esVocal(this.poblacion)) {
            datos = "\nC/ " + this.calle + " nº " + this.nombre + " d'" + this.poblacion;
        } else {
            datos = "\nC/ " + this.calle + " nº " + this.nombre + " de " + this.poblacion;
        }
        return datos;
    }
    public String getInfo() {
        String datos1 = this.getAdressaCompleta();
        String datos2;
        if (this.garaje) {
            datos2 = datos1 + ", si tiene garaje, tiene "  + this.superficie + " metros cuadrados y con una antiguedad de" + this.antiguedad + " años.";
        } else {
            datos2 = datos1 + ", no tiene garaje, tiene "  + this.superficie + " metros cuadrados y con una antiguedad de" + this.antiguedad + " años.";
        }
        return datos2;
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
