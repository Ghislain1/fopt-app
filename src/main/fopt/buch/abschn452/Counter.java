package fopt.buch.abschn452;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// 4.5.2 Laenge Dauer der Ereignisbehandlung in JavaFx

public class Counter extends Application
{

    // 1. Wie nennt man die Thread in JavaFx?
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

    private void erhoehenAsync()
    {

        for (int i = 0; i < 10; i++)
        {
            this.counter++;
            Platform.runLater(() -> this.updateView());
            try
            {
                Thread.sleep(1000);// Sekundentakt warten
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void erhoehen()
    {
        Thread t = new Thread(() -> this.erhoehenAsync());
        t.setDaemon(true);
        t.start();

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
    // 1. JavaFx Application Thread

}
