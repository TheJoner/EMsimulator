import java.util.concurrent.Semaphore;

public class Magazzino {
   private Semaphore semaphore;
   private int quantitaProdotti;

   public Magazzino(int quantitaProdotti) {
      this.semaphore = new Semaphore(1);
      this.quantitaProdotti = quantitaProdotti;
   }

   public int acquistaProdotto() throws InterruptedException {
      semaphore.acquire();
      int risultatoAcquisto;
      if (quantitaProdotti > 0) {
         quantitaProdotti--;
         risultatoAcquisto = 1;
      } else {
         risultatoAcquisto = -1;
      }
      semaphore.release();
      Thread.sleep(3000);
      return risultatoAcquisto;
   }
   
   public int getQuantitaProdotti() throws InterruptedException {
      semaphore.acquire();
      int quantita = quantitaProdotti;
      semaphore.release();
      return quantita;
   }
}
