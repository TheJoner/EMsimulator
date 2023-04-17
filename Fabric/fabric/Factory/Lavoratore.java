package Factory;
public class Lavoratore extends Thread{
    int tempoDiLavoro;
    int bancoDiAppartenenza;
    public static Integer numeroLavoratore;
    //tempo
    int min = 2000;
    int max = 10000;
    boolean stipendio = false;

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
            stipendio = true;
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
