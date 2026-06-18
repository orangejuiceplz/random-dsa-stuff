package review;

import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class FP2_2_KShiven {

    /**
     *
     * Idea:
     * Heapfiy the array of costs
     * You now have top costs.
     *
     * Then, remove that from the array and reheapify
     *
     *
     */

    public static ArrayList<String> maximize(Map<String, Double> weights, double capacity) {

        ArrayList<Double> costs = new ArrayList<>();
        for (String keys : weights.keySet()) {
            costs.add(weights.get(keys));
        }
        double[] arr = new double[costs.size()];
        for (int i = 0; i < costs.size(); i++) {
            arr[i] = costs.get(i);
        }

    }

    private void heapify() {

    }

    private double sum(double[] costs) {
        double cost = 0;
        for (double v : costs) {
            cost += v;
        }
        return cost;
    }

}
