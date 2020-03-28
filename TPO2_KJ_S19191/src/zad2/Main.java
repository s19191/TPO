/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
  public static void main(String[] args) {
    Main main = new Main();
    try {
      main.showGui();
    } catch(Exception exc) {
      JOptionPane.showMessageDialog(null, "Creation failed, " + exc);
    }
  }

  public void showGui() {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame jf = new JFrame("TPO2");
        final Service[] service = new Service[1];
        jf.setPreferredSize(new Dimension(600,300));
        JTextArea informacje = new JTextArea();
        informacje.setEditable(false);
//        JTextArea kraj = new JTextArea("Nie podano jeszcze kraju");
//        kraj.setEditable(false);
//        kraj.setBackground(Color.YELLOW);
        JScrollPane jScrollPane = new JScrollPane(informacje);
//        jScrollPane.setLayout();
//        jScrollPane.add(kraj);
        JButton podajKraj = new JButton("Kliknij, jeżeli chcesz podać kraj");
        podajKraj.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String kraj = JOptionPane.showInputDialog("Podaj kraj");
            if (kraj != null && kraj != "") {
              Service s = new Service(kraj);
              if (s.kod != null) {
                informacje.setText("");
                service[0] = s;
              } else {
                JOptionPane.showMessageDialog(null, "Podano nieprawidłową wartość, taki kraj nie istnieje!");
              }
            } else {
              JOptionPane.showMessageDialog(null, "Podano nieprawidłową wartość, taki kraj nie istnieje!");
            }
          }
        });
        JButton podajMiasto = new JButton("Kliknij, jeżeli chcesz podać miasto");
        podajMiasto.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String miasto = JOptionPane.showInputDialog("Podaj miasto");
            if (service[0] != null && miasto != null && miasto != "") {
              String weatherJson = service[0].getWeather(miasto);
              if (!weatherJson.equals("ex")) {
                informacje.append(weatherJson + "\n");
              } else {
                JOptionPane.showMessageDialog(null, "Podano nieprawidłową wartość, takie miasto nie istnieje!");
              }
            } else {
              JOptionPane.showMessageDialog(null, "Nie podano jeszcze kraju w któym miało by się znajdować miasto");
            }
          }
        });
        JButton podajWalute = new JButton("Kliknij, jeżeli chcesz, sprawdzić kurs waluty danego kraju wobec innej waluty");
        podajWalute.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String waluta = JOptionPane.showInputDialog("Podaj walute");
            if (service[0] != null && waluta != null && waluta != "") {
              Double rate1 = service[0].getRateFor(waluta);
              if (rate1 != 0.0) {
                informacje.append("Kurs waluty danego kraju wobec waluty podanej jako argument: " + rate1 + "\n");
              } else {
                JOptionPane.showMessageDialog(null, "Źle podany kod waluty");
              }
              Double rate2 = service[0].getNBPRate();
              if (rate2 != 0.0) {
                informacje.append("Kurs złotego wobez waluty danego kraju: " + rate2 + "\n");
              } else {
                JOptionPane.showMessageDialog(null, "Wystąpił błąd");
              }
            } else {
              JOptionPane.showMessageDialog(null, "Nie podano jeszcze kraju na rzecz którego można by było sprawdzić kurs waluty");
            }
          }
        });
        jf.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(0,1));
        jPanel.add(podajKraj);
        jPanel.add(podajMiasto);
        jf.add(jPanel,BorderLayout.NORTH);
        jf.add(jScrollPane,BorderLayout.CENTER);
        jf.add(podajWalute,BorderLayout.SOUTH);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
      }
    });
  }
}