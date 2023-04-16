package Factory;
public class ComponenteCreato extends Thread{
    int tipoComponente;
    int tempoCostruzione;
    int min = 6000;
    int max = 15000;
    boolean finito = false;

    public ComponenteCreato(int tipoComponente) {
        this.tipoComponente = tipoComponente;
        this.tempoCostruzione = (int) Math.floor(Math.random() *(max - min + 1) + min) ;
        
    }

    @Override
    public void run() {
        try {
            sleep(tempoCostruzione);
            finito = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
