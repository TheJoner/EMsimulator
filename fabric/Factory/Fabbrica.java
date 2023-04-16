package Factory;

import java.util.ArrayList;

public class Fabbrica {
    static BancoDaLavoro[] banchi = new BancoDaLavoro[3];
    ArrayList<Veicolo> veicli = new ArrayList<>();

    public Fabbrica(int b1, int b2, int b3) {
        banchi[0] = new BancoDaLavoro(b1, 0);
        banchi[1] = new BancoDaLavoro(b2, 1);
        banchi[2] = new BancoDaLavoro(b3, 2);
        
    }

    public boolean creaVeicolo(){
        if(banchi[0].componenti.size() >= 1 && banchi[1].componenti.size() >= 1 && banchi[2].componenti.size() >= 1){
            for (int i = 0; i < banchi.length; i++) {
                banchi[i].componenti.remove(0);
            }
            veicli.add(new Veicolo());
        }
        return true;
    }


    
}
