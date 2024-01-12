package objetos_clases.personajes_atributos;

public class Estadistica {
    private int pv;
    private int ph;
    private int atqFis;
    private int atqElem;
    private int defFis;
    private int defElem;
    private int prec;
    private int vel;
    private int critic;
    private int evasion;

    public Estadistica(int pv, int ph, int atqFis, int atqElem, int defFis, int defElem, int prec, int vel, int critic, int evasion) {
        this.pv = pv;
        this.ph = ph;
        this.atqFis = atqFis;
        this.atqElem = atqElem;
        this.defFis = defFis;
        this.defElem = defElem;
        this.prec = prec;
        this.vel = vel;
        this.critic = critic;
        this.evasion = evasion;
    }

    public int getPv() {
        return pv;
    }
    public int getPh() {
        return ph;
    }
    public int getAtqFis() {
        return atqFis;
    }
    public int getAtqElem() {
        return atqElem;
    }
    public int getDefFis() {
        return defFis;
    }
    public int getDefElem() {
        return defElem;
    }
    public int getPrec() {
        return prec;
    }
    public int getVel() {
        return vel;
    }
    public int getCritic() {
        return critic;
    }
    public int getEvasion() {
        return evasion;
    }

}
