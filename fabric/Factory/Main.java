package Factory;
public class Main {
    public static void main(String[] args) {
        for (int index = 0; index < 10; index++) {
            Lavoratore a = new Lavoratore(2);
            System.out.println(a.getNumeroLavoratore());
            System.out.println(a.getTempoDiLavoro());
        }
        Fabbrica f = new Fabbrica(1, 2, 2);
        //Lavoratore a = new Lavoratore(2);
        
    }
}
