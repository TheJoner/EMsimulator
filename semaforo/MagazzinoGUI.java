import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MagazzinoGUI extends JFrame {
   private Magazzino magazzino;
   private JTextField textFieldQuantitaProdotti;
   private JTextField textFieldAcquistiEffettuati;
   private JPanel panelSemaphore;

   public MagazzinoGUI() {
      // Inizializza il magazzino con 10 prodotti
      magazzino = new Magazzino(10);

      // Crea la GUI
      setTitle("Magazzino");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Pannello con la quantità di prodotti
      JPanel panelQuantitaProdotti = new JPanel();
      panelQuantitaProdotti.setLayout(new FlowLayout(FlowLayout.LEFT));
      JLabel labelQuantitaProdotti = new JLabel("Quantità prodotti:");
      textFieldQuantitaProdotti = new JTextField(10);
      textFieldQuantitaProdotti.setEditable(false);
      try {
         textFieldQuantitaProdotti.setText(String.valueOf(magazzino.getQuantitaProdotti()));
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      panelQuantitaProdotti.add(labelQuantitaProdotti);
      panelQuantitaProdotti.add(textFieldQuantitaProdotti);

      // Pannello con gli acquisti effettuati
      JPanel panelAcquistiEffettuati = new JPanel();
      panelAcquistiEffettuati.setLayout(new FlowLayout(FlowLayout.LEFT));
      JLabel labelAcquistiEffettuati = new JLabel("Acquisti effettuati:");
      textFieldAcquistiEffettuati = new JTextField(10);
      textFieldAcquistiEffettuati.setEditable(false);
      textFieldAcquistiEffettuati.setText("0");
      panelAcquistiEffettuati.add(labelAcquistiEffettuati);
      panelAcquistiEffettuati.add(textFieldAcquistiEffettuati);

      // Pannello con il pulsante per effettuare un acquisto
      JPanel panelAcquista = new JPanel();
      panelAcquista.setLayout(new FlowLayout(FlowLayout.CENTER));
      JButton buttonAcquista = new JButton("Acquista");
      buttonAcquista.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               int risultatoAcquisto = magazzino.acquistaProdotto();
               if (risultatoAcquisto == 1) {
                  int acquistiEffettuati = Integer.parseInt(textFieldAcquistiEffettuati.getText());
                  acquistiEffettuati++;
                  textFieldAcquistiEffettuati.setText(String.valueOf(acquistiEffettuati));
                  int quantitaProdotti = magazzino.getQuantitaProdotti();
                  textFieldQuantitaProdotti.setText(String.valueOf(quantitaProdotti));
                  panelSemaphore.setBackground(Color.RED);
                  Timer timer = new Timer(3000, new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        panelSemaphore.setBackground(Color.GREEN);
                     }
                  });
                  timer.setRepeats(false);
                  timer.start();
                  JOptionPane.showMessageDialog(null, "Acquisto effettuato con successo.");
               }else if (risultatoAcquisto == 0) {
                  JOptionPane.showMessageDialog(null, "Non è possibile effettuare l'acquisto, prodotti esauriti.");
               } else if (risultatoAcquisto == -1) {
                  JOptionPane.showMessageDialog(null, "Errore nell'acquisto del prodotto.");
               }
               
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
         }
      });
      panelAcquista.add(buttonAcquista);

      // Pannello con il semaforo
      panelSemaphore = new JPanel();
      panelSemaphore.setBackground(Color.GREEN);
      panelSemaphore.setPreferredSize(new Dimension(100, 100));
      panelSemaphore.setBorder(BorderFactory.createLineBorder(Color.BLACK));

      // Pannello principale
      JPanel panelMain = new JPanel();
      panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
      panelMain.add(panelQuantitaProdotti);
      panelMain.add(panelAcquistiEffettuati);
      panelMain.add(panelAcquista);
      panelMain.add(panelSemaphore);

      // Aggiunge il pannello principale alla finestra
      getContentPane().add(panelMain);

      // Imposta le dimensioni della finestra e la rende visibile
      pack();
      setVisible(true);
      }

      public static void main(String[] args) {
      new MagazzinoGUI();
      }
      }

      class Magazzino {
      private int quantitaProdotti;

      public Magazzino(int quantitaProdotti) {
      this.quantitaProdotti = quantitaProdotti;
      }

      public int getQuantitaProdotti() throws InterruptedException {
      // Simula l'accesso al magazzino
      Thread.sleep(2000);
      return quantitaProdotti;
      }

      public int acquistaProdotto() throws InterruptedException {
      // Simula l'acquisto di un prodotto dal magazzino
      Thread.sleep(3000);
      if (quantitaProdotti > 0) {
      quantitaProdotti--;
      return 1;
      } else {
      return 0;
      }
   }
}