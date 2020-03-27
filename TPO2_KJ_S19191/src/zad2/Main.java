/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad2;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
  public static void main(String[] args) {
    Service s = new Service("Poland");
    String weatherJson = s.getWeather("Warsaw");
    Double rate1 = s.getRateFor("USD");
    Double rate2 = s.getNBPRate();
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("TPO2");
    TextField textField = new TextField();
    StackPane stackPane = new StackPane();
    Scene scene = new Scene(new StackPane(),500,300);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
