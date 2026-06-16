package funalgs.weighted;

import java.util.ArrayList;

public class LeastCost_2_KShiven<E> {

    private ArrayList<WeightedNode_2_KShiven<E>> nodesInGraph = new ArrayList<>();

    public LeastCost_2_KShiven(E[] values, Double[][] adjacencyMatrix) {
        for (E value: values) {
            nodesInGraph.add(new WeightedNode_2_KShiven<>(value));
        }

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            WeightedNode_2_KShiven<E> row = nodesInGraph.get(i);
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                WeightedNode_2_KShiven<E> column = nodesInGraph.get(j);
                if (adjacencyMatrix[i][j] != Double.POSITIVE_INFINITY) {
                    row.connect(column, adjacencyMatrix[i][j]);
                }
            }
        }
    }

    public WeightedPath_2_KShiven<E> leastCost(E value1, E value2) {
        return leastCost(new WeightedNode_2_KShiven<>(value1), new WeightedNode_2_KShiven<>(value2), new WeightedPath_2_KShiven<>(new WeightedNode_2_KShiven<>(value1)), new WeightedPath_2_KShiven<>(new WeightedNode_2_KShiven<>(value1)));
    }

    private WeightedPath_2_KShiven<E> leastCost(WeightedNode_2_KShiven<E> current, WeightedNode_2_KShiven<E> target, WeightedPath_2_KShiven<E> currentPath, WeightedPath_2_KShiven<E> bestPath) {

        if (currentPath.isCompleted(target)) {
            if (currentPath.getCost() < bestPath.getCost()) {
                return currentPath;
            } else {
                return bestPath;
            }
        }

        if (currentPath.getCost() > bestPath.getCost()) {
            return bestPath;
        }

        for (WeightedNode_2_KShiven<E> connection : current.getConnections()) {
            if (!currentPath.contains(connection) || !current.equals(target)) {
                bestPath = leastCost(connection, target, currentPath, bestPath);
            }
        }

        return bestPath;
    }


}
