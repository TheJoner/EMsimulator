package Factory;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class BancoDaLavoro extends Semaphore{
    int tipologiaBanco;
    //
    ArrayList<ComponenteCreato> componenti = new ArrayList<>();
    ArrayList<Lavoratore> lavoratori = new ArrayList<>();
    ArrayList<Lavoratore> coda = new ArrayList<>();
    ArrayList<Integer> cbt = new ArrayList<>();

    public BancoDaLavoro(int quantitaLavoratori, int tipologiaBanco) {
        super(quantitaLavoratori);
        this.tipologiaBanco = tipologiaBanco;
    }
    
    public void agigungiLavoratore(){

        if(lavoratori.size() < 2){
        Lavoratore l = new Lavoratore(tipologiaBanco);
        lavoratori.add(l);
        l.run();
        cbt.add(lavoratori.indexOf(l), l.numeroLavoratore);
        
        }else {
            System.out.println("UwU hai messo twoppi schiavi");
            Lavoratore l = new Lavoratore(tipologiaBanco);
            coda.add(l);
        }
    }

    public void stopImmigrati(){

    }
}
