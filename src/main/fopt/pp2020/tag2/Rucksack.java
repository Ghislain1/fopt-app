package fopt.pp2020.tag2;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Rucksack extends Application
{

    public static final double WachschzeugGW = 1.2;

    public static final double ErsatzKleidungGW = 3.7;

    public static final double BuecherGW = 3.3;

    public static final double MedikamenteGW = 0.2;

    public static final double EssensPaket1GW = 1.5;

    public static final double Getraenke1GW = 4.7;

    public static final double Essenspaket1GW = 1.5;

    public static final double Getraenke2GW = 2.9;

    public static final double Essenspaket2GW = 2.4;

    public static final String Waschzeug = "Waschzeug";

    public static final String ErsatzKleidung = "ErsatzKleidung";

    public static final String Buecher = "Buecher";

    public static final String Medikamente = "Medikamente";

    public static final String Getraenke1 = "Getraenke 1";

    public static final String Getraenke2 = "Getraenke  2";

    public static final String Essenspaket1 = "EssensPaket 1";

    public static final String Essenspaket2 = "Essenspaket 2";

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primarStage)
    {
        String[] bezeichnungen =
        { Waschzeug, ErsatzKleidung, Buecher, Medikamente, Getraenke1, Getraenke2, Essenspaket1, Essenspaket2 };

        double[] einzelgewichte =
        { WachschzeugGW, ErsatzKleidungGW, BuecherGW, MedikamenteGW, Getraenke1GW, Getraenke2GW, Essenspaket1GW, Essenspaket2GW };
        double maxWeight = 10;

        // Model
        Model model = new Model(bezeichnungen, einzelgewichte, maxWeight);

        // Presenter
        Presenter rucksackPresenter = new Presenter();

        // View
        View view = new View(rucksackPresenter);

        // Verheiratet Model and View laut MVP-Prinzip
        rucksackPresenter.setModelAndView(model, view);

        // Settings
        ArrayList<Double> arrayListDouble = new ArrayList<>();
        for (double sd : einzelgewichte)
        {
            arrayListDouble.add(Double.valueOf(sd));
        }

        view.init(List.of(bezeichnungen), arrayListDouble, maxWeight);

        // UI
        Pane root = view.getUI();
        Scene scene = new Scene(root, 350, 500);
        primarStage.setScene(scene);
        primarStage.setTitle(" Rucksack");
        primarStage.show();

    }

}
