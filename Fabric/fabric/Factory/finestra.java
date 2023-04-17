package Factory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        
        JPanel r= new JPanel(null, false);
        r.setBounds(300,300,500,100);
        r.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(toolbar, BorderLayout.PAGE_START);
        frame.getContentPane().add(r);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(r);
        frame.setSize(1920, 1080);
        frame.setVisible(true);

    }
}

