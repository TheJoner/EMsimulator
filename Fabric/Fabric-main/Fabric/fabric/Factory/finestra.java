package Factory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics.*;
class banco1 extends JComponent {
    
    public void paint(Graphics g) {
      g.setColor(Color.GRAY);
      g.fillRect (300,200,300,200);    
      g.fillRect (800 ,200,300,200);  
      g.fillRect (1300,200,300,200); 
      g.setColor(Color.red);
      g.fillOval(270, 200, 20, 20);
      g.fillOval(770, 200, 20, 20);
      g.fillOval(1270, 200, 20, 20);

    }
  }

public class finestra {

    public static void main(String[] args) {

        final JFrame frame = new JFrame("factory simulator");
        Font font = new Font("Arial", Font.BOLD, 42);
        JToolBar toolbar = new JToolBar("informazioni");

        JButton btnComp = new JButton("TOTALE COMPONENTI: 0 ");
        btnComp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "HAI "+"0"+" COMPONENTI");
            }
        });
        btnComp.setFont(font);
        JButton btnLav = new JButton("TOTALE LAVORATORI: 0 ");
        btnLav.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,  "HAI "+"0"+" LAVORATORI");
            }
        });
        btnLav.setFont(font);
        JButton btnV = new JButton("TOTALE VEICOLI: 0 ");
        btnV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "HAI "+"0"+" VEICOLI");
            }
        });
        btnV.setFont(font);
        JButton btnBoss = new JButton("FELICITA' CAPO: 0 ");
        btnBoss.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "IL CAPO HA "+"0"+"PUNTI FELICITA'");
            }
        });
        btnBoss.setFont(font);
       

        toolbar.add(btnComp);
        toolbar.add(btnLav);
        toolbar.add(btnV);
        toolbar.add(btnBoss);
        JButton aggiungiuno= new JButton("aggiungi sergi");
        aggiungiuno.setSize(10, 10);
        frame.add(aggiungiuno);
        //aggiungiuno.setPreferredSize(new Dimension(300, 20));
        //aggiungiuno.setBounds(300, 450, 300, 20);
       
        frame.setLayout(new BorderLayout());
        
        frame.getContentPane().add(toolbar, BorderLayout.PAGE_START);
        frame.getContentPane().add(new banco1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.getContentPane();
        frame.add(aggiungiuno);
        frame.setVisible(true);

    }
}

