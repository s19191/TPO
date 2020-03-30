/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad2;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
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
    SwingUtilities.invokeLater(() -> {
      JFrame jf = new JFrame("TPO2");
      final Service[] service = new Service[1];
      final boolean[] czyInformacjeWidoczne = new boolean[1];
      jf.setPreferredSize(new Dimension(900,600));
      JTextArea informacje = new JTextArea();
      informacje.setEditable(false);
      JScrollPane jScrollPane = new JScrollPane(informacje);
      JTextArea jtaKraj = new JTextArea("Nie podano jeszcze kraju!");
      jtaKraj.setEditable(false);
      jtaKraj.setBackground(Color.YELLOW);
      JTextArea jtaMiasto = new JTextArea("Nie podano jeszcze miasta!");
      jtaMiasto.setEditable(false);
      jtaMiasto.setBackground(Color.YELLOW);
      JFXPanel jfxPanel = new JFXPanel();
      JButton podajKraj = new JButton("Kliknij, jeżeli chcesz podać kraj");
      podajKraj.addActionListener(e -> {
        String kraj = JOptionPane.showInputDialog("Podaj kraj");
        if (kraj != null && kraj != "") {
          Service s = new Service(kraj);
          if (s.kod != null) {
            informacje.setText("");
            if (service[0] != null) {
              Platform.runLater(() -> {
                WebView webView = new WebView();
                jfxPanel.setScene(new Scene(webView));
                webView.getEngine().load("https://en.wikipedia.org/wiki");
              });
            }
            service[0] = s;
            czyInformacjeWidoczne[0] = false;
            jtaKraj.setText("Wprowadzono kraj: " + kraj.trim().toUpperCase());
            jtaMiasto.setText("Nie podano jeszcze miasta!");
          } else {
            JOptionPane.showMessageDialog(null, "Podano nieprawidłową wartość, taki kraj nie istnieje!");
          }
        } else {
          JOptionPane.showMessageDialog(null, "Podano nieprawidłową wartość, taki kraj nie istnieje!");
        }
      });
      JButton podajMiasto = new JButton("Kliknij, jeżeli chcesz podać miasto");
      podajMiasto.addActionListener(e -> {
        String miasto = JOptionPane.showInputDialog("Podaj miasto");
        if (service[0] != null && miasto != null && miasto != "") {
          String weatherJson = service[0].getWeather(miasto);
          if (!weatherJson.equals("ex")) {
            czyInformacjeWidoczne[0] = true;
            informacje.append(weatherJson + "\n");
            jtaMiasto.setText("Wprowadzone miasto: " + miasto.trim().toUpperCase());
            Platform.runLater(() -> {
              WebView webView = new WebView();
              jfxPanel.setScene(new Scene(webView));
              String miastoWiki = miasto.substring(0,1) + miasto.substring(1).toLowerCase();
              webView.getEngine().load("https://en.wikipedia.org/wiki/"+miastoWiki);
            });
          } else {
            JOptionPane.showMessageDialog(null, "Podano nieprawidłową wartość, takie miasto nie istnieje!");
          }
        } else {
          JOptionPane.showMessageDialog(null, "Nie podano jeszcze kraju w któym miało by się znajdować miasto");
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
              if (!czyInformacjeWidoczne[0]) {
                Platform.runLater(() -> {
                  WebView webView = new WebView();
                  jfxPanel.setScene(new Scene(webView));
                  webView.getEngine().load("https://en.wikipedia.org/wiki");
                });
              }
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
      jPanel.add(jtaKraj);
      jPanel.add(podajMiasto);
      jPanel.add(jtaMiasto);
      jf.add(jPanel,BorderLayout.NORTH);
      jf.add(jScrollPane,BorderLayout.WEST);
      jf.add(jfxPanel,BorderLayout.CENTER);
      jf.add(podajWalute,BorderLayout.SOUTH);
      jf.pack();
      jf.setLocationRelativeTo(null);
      jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      jf.setVisible(true);
    });
  }
}