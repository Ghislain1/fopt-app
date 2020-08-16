package fopt.klausur.lin.aufgabe5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class MySimpleChangeListener  implements ChangeListener<Number> {
    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        System.out.println(">> changed from " + oldValue + " to " + newValue);
    }
}
