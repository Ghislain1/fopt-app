package fopt.pp2020.lin.tag2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    List<Item> items;
    List<String> names;
    Double maximalWeight;

    public Model(List<Item> items, Double maximalWeight) {
        this.items = items;
        this.maximalWeight = maximalWeight;
        for (Item item: this.items
             ) {
            Double weight = 0.0;
            weight += item.getWeight();
            if(weight > this.maximalWeight){
                throw new IllegalArgumentException(" heavier than the maximal allowed weight");
            }
        }
    }

    public void setSelected (Item item, boolean selected){
        item.setSelected(selected);
    }

    public Double getSumOfUsedWeights(){
        return this.items.stream().filter(e -> e.isSelected()).map(e -> e.getWeight()).reduce(0.0, Double::sum);
    }

    public List<String> getAllItemNames(){
        return this.items.stream().map(Item::getText).collect(Collectors.toList());
    }

    public List<Double> getAllItemWeights(){
        return this.items.stream().map(Item::getWeight).collect(Collectors.toList());
    }

    public double getMaxWeight(){
        return this.items.stream().max(Comparator.comparing(Item::getWeight)).get().getWeight();
    }

    public List<String> getEnabledItems(){
        return this.items.stream().filter(e -> e.isSelected()).map(Item::getText).collect(Collectors.toList());
    }

}
