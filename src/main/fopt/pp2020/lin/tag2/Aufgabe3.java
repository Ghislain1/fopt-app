package fopt.pp2020.lin.tag2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aufgabe3 extends Application {
    public static void main(String[] args)
    {
        launch(args);
    }

    private Item cb1;
    private Item cb2;
    private Item cb3;
    private Pane graphicsPane;

    public Aufgabe3() {
        graphicsPane = new Pane();
        cb1 = new Item("Waschzeug", 1.2);
        cb2 = new Item("Ersatzkleidung", 3.7);
        cb3 = new Item("Bücher", 3.3);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // JavaFx Elements
        Label label = new Label("Hallo world");


        // set object of ChangeListener to checkbox
        // https://docs.oracle.com/javafx/2/binding/jfxpub-binding.htm
        cb1.selectedProperty().addListener((a, b, c) ->
        {
            if (a.getValue())
            {
                System.out.println("add " + cb1.getText() + " with " + cb1.getWeight() + " kg");
            }
        });

        cb2.selectedProperty().addListener((a, b, c) ->
        {
            if (a.getValue())
            {
                System.out.println("add " + cb2.getText() +  " with " + cb2.getWeight() + " kg");
            }
        });

        cb3.selectedProperty().addListener((a, b, c) ->
        {
            if (a.getValue())
            {
                System.out.println("add " + cb3.getText() + " with " + cb3.getWeight() + " kg");
            }
        });

        VBox vBox = new VBox(cb1, cb2,cb3);
        graphicsPane.getChildren().add(vBox);
        Scene scene = new Scene(graphicsPane, 300, 100);


        primaryStage.setScene(scene);

        primaryStage.setTitle("Hello world");
        primaryStage.show();

    }
}
