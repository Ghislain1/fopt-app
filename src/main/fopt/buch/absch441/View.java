package fopt.buch.absch441;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View
{
    private Presenter presenter;

    private Label ueberLabel;

    private Label wortLabel;

    private TextField textField;

    private Button ueberpruefungButton;

    private Button weiterButton;

    public View(Presenter presenter)
    {
        if (presenter == null)
        {
            throw new IllegalArgumentException("presenter must be not null");
        }
        this.presenter = presenter;
    }

    public void init(Stage stage)
    {

        VBox vbox = new VBox();// Elemente werden untereinander angeordnet.

        // Zeile 1
        this.ueberLabel = new Label("Übersetzen Sie :");
        vbox.getChildren().add(this.ueberLabel);

        // Zeile 2:Words
        wortLabel = new Label();
        wortLabel.setText("TDODO");
        GridPane gridPane = new GridPane();
        gridPane.add(wortLabel, 0, 0);
        this.textField = new TextField();
        this.textField.setText("TDODOD");
        gridPane.add(wortLabel, 0, 1);
        vbox.getChildren().add(gridPane);

        // Zeile3: Buttons
        HBox hbox = new HBox();
        this.ueberpruefungButton = new Button();
        this.ueberpruefungButton.setText("Überpruefen");
        this.ueberpruefungButton.setOnAction(s -> this.presenter.check());
        this.weiterButton = new Button();
        this.weiterButton.setText("Weiter");
        this.ueberpruefungButton.setOnAction(s -> this.presenter.next());
        hbox.getChildren().add(this.ueberpruefungButton);
        hbox.getChildren().add(this.weiterButton);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Vokabular-Training");

    }

}
