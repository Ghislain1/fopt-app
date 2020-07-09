package fopt.buch.abschn413;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Counter extends Application
{
    // 4.1.3 Ereignisbehandlung
    // Listing 4.3 Counter Beispiel
    // 1. Welcher Paramter hat die Methode setOnAction der Klasse Button?

    private int counter;

    private Label counterLabel;

    @Override
    public void start(Stage primaryStage)
    {
        // JavaFx Elements definition
        counterLabel = new Label("" + this.counter);
        Button erhoehenButton = new Button("Erhoehen");
        Button zuruecksetzenButton = new Button("Zuruecksetzen");

        // Arrange
        VBox vbox = new VBox();
        vbox.getChildren().add(counterLabel);
        vbox.getChildren().add(erhoehenButton);
        vbox.getChildren().add(zuruecksetzenButton);

        // scene
        Scene scene = new Scene(vbox, 200, 70);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Handler definition
        erhoehenButton.setOnAction(e -> this.erhoehen());
        zuruecksetzenButton.setOnAction(e -> this.zuruecksetzen());

    }

    private void updateView()
    {
        this.counterLabel.setText(" " + this.counter);
    }

    private void erhoehen()
    {
        this.counter++;
        this.updateView();
    }

    private void zuruecksetzen()
    {
        this.counter = 0;
        this.updateView();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    // 1. Die Methode setAction() hat einen Parameter von Typ EventHandler<T
    // extends Event>
}
