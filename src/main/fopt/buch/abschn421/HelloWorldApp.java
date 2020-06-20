package fopt.buch.abschn421;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// 1. Wie kann man JavaFx-Bibliothek referenzieren?
// 2. Kann man die VM Konfigurieren?

public class HelloWorldApp extends Application
{

    public static void main(String[] args)
    {
        launch(args);

    }

    /**
     * Structure: stage -> scene ->
     * 
     **/
    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Abschnitt 4.2.1");
        VBox vbox = new VBox(); // Elemente werden untereinander angeordnet.
        Label f = new Label();
        f.setText("Hallo");

        Label f2 = new Label();
        f2.setText("Welt");

        vbox.getChildren().add(f);
        vbox.getChildren().add(f2);
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();

    }

}

// 1. Project properties->Java Build path -> Add User Library --> Add external
// Jars.

// 2. Run As-> --module-path "<libPath>" --add-modules
// javafx.controls,javafx.fxm

// 2.1 Javafx13.02/lib/ Auflisten die jars files
