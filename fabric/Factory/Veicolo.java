package Factory;
public class Veicolo {
    protected static int numeroVeicoli;
    public Veicolo() {
        numeroVeicoli++;
    }
    public static int getNumeroVeicoli() {
        return numeroVeicoli;
    }
    
}
