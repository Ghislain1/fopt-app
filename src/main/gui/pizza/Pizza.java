package gui.pizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Pizza extends Application
{
    private static Configuration conf;

    private final VBox root = new VBox();

    private final HBox hbox = new HBox();

    private final Button btn = new Button("Bestellen");

    private final TextArea bestelltext = new TextArea();

    private List<String> zutaten = new ArrayList<>();

    private int preis;

    private String piz;

    public static void main(String[] args)
    {
        Map<String, String> testMap = new HashMap<>();
        for (int i = 0; i < args.length; i++)
        {
            testMap.put((args[i].split("="))[0].substring(2), (args[i].split("="))[1]);
        }

        conf = ParameterConverter.createConfiguration(testMap);
        // conf = new Configuration((args[2].split("="))[1].split(","),
        // ParameterConverter((args[3].split("="))[1].split(",")),
        // (args[0].split("="))[1].split(","),
        // ParameterConverter((args[1].split("="))[1].split(",")),
        // Integer.parseInt(args[4].split("=")[1]));

        launch(args);
    }

    public static int[] ParameterConverter(String[] array)
    {
        int[] sTable = new int[array.length];

        for (int i = 0; i < array.length; i++)
        {
            sTable[i] = Integer.parseInt(array[i].replace(" ", ""));
        }

        return sTable;
    }

    private void initWindow(Stage PrimaryStage)
    {

        btn.setId("Bestellen!");
        btn.setText("Bestellen!");
        bestelltext.setId("bestelltext");
        bestelltext.setEditable(false);
        bestelltext.setDisable(true);

        root.getChildren().add(btn);

        root.getChildren().add(bestelltext);
        Scene scene = new Scene(root);
        PrimaryStage.setScene(scene);
        PrimaryStage.setTitle("pizza");
        PrimaryStage.show();

    }

    @Override
    public void start(Stage PrimaryStage)
    {
        ToggleGroup tg = new ToggleGroup();
        if (conf == null)
        {
            initWindow(PrimaryStage);
            return;
        }
        btn.setOnAction(e -> Command());
        showSizes(tg);
        showToppings();
        initWindow(PrimaryStage);

    }

    private void showToppings()
    {
        if (conf.getToppingPrices().length > 0 || conf.getToppingNames().length > 0)
        {
            for (int i = 0; i < conf.getToppingNames().length; i++)
            {
                final CheckBox cb = new CheckBox(conf.getToppingNames()[i]);
                cb.setText(conf.getToppingNames()[i]);
                cb.setId(conf.getToppingNames()[i]);
                if (i < conf.getNumberOfDefaultToppings())
                {
                    cb.setDisable(true);
                    cb.setSelected(true);

                    this.zutaten.add(conf.getToppingNames()[i]);

                }

                final int j = i;
                cb.setOnAction(e ->
                {
                    if (cb.isSelected())
                    {
                        this.zutaten.add(conf.getToppingNames()[j]);
                        this.preis += conf.getToppingPrices()[j];
                    }
                    else
                    {
                        zutaten.remove(conf.getToppingNames()[j]);
                        this.preis -= conf.getToppingPrices()[j];
                    }
                });
                root.getChildren().add(cb);
            }
        }
    }

    private void showSizes(ToggleGroup tg)
    {
        if (conf.getSizeNames().length > 0 || conf.getSizePrices().length > 0)
        {
            for (int i = 0; i < conf.getSizeNames().length; i++)
            {
                final int j = i;
                final RadioButton rb = new RadioButton(conf.getSizeNames()[i]);

                rb.setText(conf.getSizeNames()[i]);
                rb.setId(conf.getSizeNames()[i]);
                rb.setSelected(i == 0);

                rb.setToggleGroup(tg);
                rb.setOnAction(e ->
                {
                    if (rb.isSelected())
                    {
                        this.preis += conf.getToppingPrices()[j];
                        this.piz = conf.getSizeNames()[j];
                    }
                });
                hbox.getChildren().add(rb);
            }
            this.piz = conf.getSizeNames()[0];
            this.preis = conf.getSizePrices()[0];

        }

    }

    public String arrayToString(List<String> array)
    {
        if (array.size() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.size(); ++i)
        {
            sb.append(", ").append(array.get(i));
        }
        return sb.substring(1);
    }

    private void Command()
    {
        ObservableList<Node> ctls = this.root.getChildren();
        for (int i = 0; i < ctls.size(); i++)
        {
            // if (ctls[i])
        }

        String txt = "Sie gaben ein Pizza bestellt.\n Zutaten: " + arrayToString(zutaten) + ".\n Die Groesse ist " + this.piz + " .\n Der Preis betraegt : " + this.preis + "€.\n Vielen Dank.";
        bestelltext.setText(txt);
    }

}
