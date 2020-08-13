package fopt.klausur.lin.aufgabe5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Aufgabe5 extends Application
{

    public static void main(String[] args)
    {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage)
    {
        // JavaFx Elements
        Label label = new Label("Hallo world");
        CheckBox cb = new CheckBox("Ich mag FOPT!!!!");
        cb.setText("First");

        // set event to checkbox
        boolean isSelected = true;
        cb.setOnAction((ActionEvent e) ->{
               if(cb.isSelected())
               {System.out.println("hurra");}
               else {
                   System.out.println("shade");
               }
        });



        HBox hbox = new HBox(cb);
        Scene scene = new Scene(hbox, 300, 100);


        primaryStage.setScene(scene);

        primaryStage.setTitle("Hello world");
        primaryStage.show();

    }

}
