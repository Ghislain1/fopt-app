package fopt.pp2020.lin.tag2;

import javafx.scene.control.CheckBox;

import java.util.Comparator;

public class Item extends CheckBox implements Comparator {



    private double weight;
    private boolean isInBackpack;



    public Item(String text, double weight) {
        super(text);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isInBackpack() {
        return isInBackpack;
    }

    public void setInBackpack(boolean inBackpack) {
        isInBackpack = inBackpack;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Item item01 = (Item) o1;
        Item item02 = (Item) o2;
        return (int) Math.round(item01.getWeight() - item02.getWeight());
    }
}
