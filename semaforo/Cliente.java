public class Cliente implements Runnable {
    private Magazzino magazzino;
 
    public Cliente(Magazzino magazzino) {
       this.magazzino = magazzino;
    }
 
    @Override
    public void run() {
       try {
          int acquistiEffettuati = 0;
          while (acquistiEffettuati < 3) {
             int risultatoAcquisto = magazzino.acquistaProdotto();
             if (risultatoAcquisto == 1) {
                System.out.println(Thread.currentThread().getName() + " ha acquistato un prodotto.");
                acquistiEffettuati++;
             } else {
                System.out.println(Thread.currentThread().getName() + " non può acquistare, prodotti esauriti.");
             }
             Thread.sleep(1000);
          }
       } catch (InterruptedException e) {
          e.printStackTrace();
       }
    }
 }
 