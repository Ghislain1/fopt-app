package fopt.buch.absch441;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class View
{
    private Presenter presenter;

    private Label ueberLabel;

    private Label statusLabel;

    private Label wortLabel;

    private TextField textField;

    private Button ueberpruefungButton;

    private Button weiterButton;

    public void setPresenter(Presenter presenter)
    {
        if (presenter == null)
        {
            throw new IllegalArgumentException("presenter must be not null");
        }
        this.presenter = presenter;
    }

    public View()
    {

    }

    public void setText(String textToTranslate)
    {
        this.wortLabel.setText(textToTranslate);
    }

    public void init(Stage stage)
    {

        // TODO: Hier soll alle elements aus GUI (visulle Element erstellen bzw.
        // instanzieren)

        // All Labels in GUI
        this.ueberLabel = new Label("Uebersetzen Sie :");
        this.wortLabel = new Label(this.presenter.getText());

        this.statusLabel = new Label("-");

        // Textfields in GUI
        this.textField = new TextField();

        // All Buttons in GUI
        this.weiterButton = new Button("Weiter");
        this.ueberpruefungButton = new Button("Ueberpruefen");

        this.ueberpruefungButton.setOnAction(s ->
        {
            this.presenter.check();

        });

        this.weiterButton.setOnAction(s -> this.presenter.next());

        // Arrange into grid
        GridPane gridPane = new GridPane();
        // Setting size for the pane
        gridPane.setMinSize(400, 200);
        // Setting the padding
        gridPane.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        // Setting Grid alignment
        gridPane.setAlignment(Pos.TOP_LEFT);
        // Setting the vertical and horizontal gaps between the columns
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(this.ueberLabel, 0, 0);
        gridPane.add(this.wortLabel, 0, 1);
        gridPane.add(this.textField, 1, 1);
        gridPane.add(this.ueberpruefungButton, 0, 2);
        gridPane.add(this.weiterButton, 1, 2);
        gridPane.add(this.statusLabel, 1, 3);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("Vokabular-Training");
        stage.show();

    }

    public String getKeyword()
    {

        return this.wortLabel.getText();
    }

    public String getUserInputText()
    {
        return this.textField.getText();
    }

    public void setStatusInfo(String msg)
    {
        this.statusLabel.setText(msg);

    }

}
