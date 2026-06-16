package funalgs.weighted;

import org.w3c.dom.Node;

import javax.sound.midi.MidiUnavailableException;
import java.util.ArrayList;

public class WeightedNode_2_KShiven<E> {

    private ArrayList<WeightedNode_2_KShiven<E>> pointers = new ArrayList<>();
    private ArrayList<Double> costs = new ArrayList<>();
    private E value;

    public WeightedNode_2_KShiven(E value) {
        this.value = value;
    }

    public ArrayList<WeightedNode_2_KShiven<E>> getConnections() {
        return this.pointers;
    }

    public E getValue() {
        return this.value;
    }

    public void connect(WeightedNode_2_KShiven<E> node, Double cost) {
        for (int i = 0; i < pointers.size(); i++) {
            if (cost < costs.get(i)) {
                pointers.add(i, node);
                costs.add(i, cost);
                return;
            }
        }
    }

    public double getCost(WeightedNode_2_KShiven<E> node) {
//        Double currentCost = 0.0;
////        for (WeightedNode_2_KShiven<E> node2KShiven : pointers) {
////
////        }
//
//        WeightedNode_2_KShiven<E> current = pointers.getFirst();
//        int i = 0;
//        while (current != node) {
//            currentCost += costs.get(i);
//            i++;
//            current = pointers.get(i);
//        }
//        return currentCost;
//    }
        int idx = pointers.indexOf(node);
        if (idx != -1) {
            return costs.get(idx);
        }
        return Double.POSITIVE_INFINITY;


}
}
