package funalgs.weighted;

import java.util.ArrayList;

public class WeightedPath_2_KShiven<E> {

    private ArrayList<WeightedNode_2_KShiven<E>> nodes;
    private Double totalCost;

    public WeightedPath_2_KShiven() {
        this.nodes = null;
        this.totalCost = Double.POSITIVE_INFINITY; // infinity
    }

    public WeightedPath_2_KShiven(WeightedNode_2_KShiven<E> node) {
        nodes = new ArrayList<>();
        this.nodes.add(node);
        this.totalCost = 0.0;
    }

    public WeightedPath_2_KShiven(WeightedPath_2_KShiven<E> path, WeightedNode_2_KShiven<E> node) {
        Double oldPathWeight = path.getCost();
        Double nodeCost= path.getLast().getCost(node);
        // i totally realized i used the wrong type :/
        this.totalCost = oldPathWeight + nodeCost;
    }

    public WeightedNode_2_KShiven<E> getLast() {
        return nodes.getLast();
    }

    public Double getCost() {
        return totalCost;
    }

    public boolean isCompleted(WeightedNode_2_KShiven<E> target) {
        return !nodes.isEmpty() && nodes.contains(target);
    }

    public boolean contains(WeightedNode_2_KShiven<E> target) {
        return !nodes.isEmpty() && nodes.getLast() == target;
    }
    public String toString() {
        String string = "";
        for (WeightedNode_2_KShiven<E> node: nodes) {
            string += node.getValue();
        }
        string += " with a cost of ";
        string += this.totalCost;
        return string;
    }




}
