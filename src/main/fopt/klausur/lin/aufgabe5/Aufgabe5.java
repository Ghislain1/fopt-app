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
//        boolean isSelected = true;
//        cb.setOnAction((ActionEvent e) ->{
//               if(cb.isSelected())
//               {System.out.println("hurra");}
//               else {
//                   System.out.println("shade");
//               }
//        });

        // set object of ChangeListener to checkbox
        // https://docs.oracle.com/javafx/2/binding/jfxpub-binding.htm
        CheckBox checkBox = new CheckBox("I love FOPT");
        checkBox.selectedProperty().addListener((a, b, c) ->
        {
            if (a.getValue())
            {
                System.out.println("hurra");
            }
            else
            {
                System.out.println("schade");
            }

        });

        HBox hbox = new HBox(checkBox);
        Scene scene = new Scene(hbox, 300, 100);


        primaryStage.setScene(scene);

        primaryStage.setTitle("Hello world");
        primaryStage.show();

    }

}
