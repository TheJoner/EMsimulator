package Factory;
public class Lavoratore extends Thread{
    int tempoDiLavoro;
    int bancoDiAppartenenza;
    protected static int numeroLavoratore;
    //tempo
    int min = 2000;
    int max = 10000;

    public int getTempoDiLavoro() {
        return tempoDiLavoro;
    }
    public int getBancoDiAppartenenza() {
        return bancoDiAppartenenza;
    }
    public static int getNumeroLavoratore() {
        return numeroLavoratore;
    }
    
    public Lavoratore (int bancoDiAppartenenza){
        //random per il tempo di lavoro
        this.tempoDiLavoro = (int) Math.floor(Math.random() *(max - min + 1) + min) ;
        this.bancoDiAppartenenza = bancoDiAppartenenza;
        numeroLavoratore++;
    }

    @Override
    public void run() {
        //dove far fare cose
        try {
            sleep(tempoDiLavoro);
            finischiLavoro();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.run();
    }
    
    public void finischiLavoro(){
        ComponenteCreato cock = new ComponenteCreato(bancoDiAppartenenza);
        Fabbrica.banchi[bancoDiAppartenenza].componenti.add(cock);
    }

}
