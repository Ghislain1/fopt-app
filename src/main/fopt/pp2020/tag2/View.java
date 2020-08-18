package fopt.pp2020.tag2;

import java.util.LinkedList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class View
{
    // UI Elements
    VBox container = new VBox();

    private Presenter presenter;

    private Label gesamtGewichtLabel;

    private LinkedList<CheckBox> checkBoxLinkedList;

    public View(Presenter resenter)
    {
        if (resenter == null)
        {
            throw new IllegalArgumentException(" Presenter ist null");
        }
        this.presenter = resenter;
        this.checkBoxLinkedList = new LinkedList<>();
    }

    // : Initialisierung der View mit den Bezeichnungen und Gewichten aller
    // Gegenstaende sowie dem maximal zulaessigen Gesamtgewicht.
    public void init(List<String> names, List<Double> weights, double maxWeight)
    {

        VBox labelsContainer = new VBox();
        VBox checkBoxesContainer = new VBox();

        this.gesamtGewichtLabel = new Label("Gesamtgewicht " + 0 + " kg");
        Label maxGewichtLabel = new Label("maximales gewicht " + maxWeight + " kg");

        // Anordnung
        container.getChildren().add(labelsContainer);
        container.getChildren().add(checkBoxesContainer);
        container.setSpacing(10);
        container.setPadding(new Insets(0, 0, 0, 10));

        labelsContainer.getChildren().add(this.gesamtGewichtLabel);
        labelsContainer.getChildren().add(maxGewichtLabel);

        int index = 0;
        for (String name : names)
        {
            String textCB = name + " (" + weights.get(index) + " k)";
            CheckBox cB = new CheckBox(textCB);
            cB.setId(name);
            cB.selectedProperty().addListener((a, b, c) ->
            {
                this.presenter.check(cB.getId(), a.getValue());
            });
            checkBoxesContainer.getChildren().add(cB);
            checkBoxLinkedList.add(cB);
            index++;

        }
        checkBoxesContainer.setPadding(new Insets(0, 0, 0, 15));

    }

    // : Aktualisiert die Anzeige für das aktuelle Gesamtgewicht des Rucksacks.
    public void updateTotalWeight(double total)
    {
        this.gesamtGewichtLabel.setText("Gesamtgewicht " + total + " kg");
    }

    // Aktualisiert die Waehlbarkeit (Enabled / Disabled) der
    // CheckBoxes. Alle Gegenstaende, deren Bezeichnungen als Parameter
    // enabledItems uebergeben werden, sollen
    public void updateEnabledItems(List<String> enabledItems)
    {
        for (CheckBox cb : checkBoxLinkedList)
        {
            if (!cb.isSelected() && enabledItems.contains(cb.getId()))
            {
                cb.setDisable(true);
            }
        }
    }

    public Pane getUI()
    {
        return container;
    }

}
