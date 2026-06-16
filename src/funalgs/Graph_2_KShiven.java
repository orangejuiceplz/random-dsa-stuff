package funalgs;

import java.util.ArrayList;

public class Graph_2_KShiven<E> {

    private ArrayList<GraphNode_2_KShiven<E>> nodesInGraph = new ArrayList<>();

    public Graph_2_KShiven(E[] values, int[][] adjacencyMatrix) {
        for (E value: values) {
            nodesInGraph.add(new GraphNode_2_KShiven<>(value));
        }
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            GraphNode_2_KShiven<E> row = nodesInGraph.get(i);
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                GraphNode_2_KShiven<E> column = nodesInGraph.get(j);
                if (adjacencyMatrix[i][j] == 1) {
                    row.addConnection(column);
                }
            }
        }
    }

//    public void printAllConnections() {
//        for (GraphNode_2_KShiven<E> node: nodesInGraph) {
//            node.printConnections();
//        }
//    }

     private void printFullPath(ArrayList<GraphNode_2_KShiven<E>> path, E value) {
         System.out.print(value);
         for (GraphNode_2_KShiven<E> node: path) {
             System.out.print(node.getValue());
         }
         System.out.println(value);
     }
     private void printCycles(GraphNode_2_KShiven<E> current, GraphNode_2_KShiven<E> end, ArrayList<GraphNode_2_KShiven<E>> path) {
        if (current.equals(end)) {
//            for (GraphNode_2_KShiven<E> node2KShiven: path) {
//                System.out.println(node2KShiven);
//            }
            printFullPath(path, current.getValue());
        }
        for (GraphNode_2_KShiven<E> connection: current.getPointers()) {
            if (!path.contains(connection)) {
                ArrayList<GraphNode_2_KShiven<E>> temp = new ArrayList<>(path);
                temp.add(connection);
                printCycles(current, end, temp);
            }
        }

     }

     public void printAllCycles() {
        ArrayList<GraphNode_2_KShiven<E>> path = new ArrayList<>();
        for (GraphNode_2_KShiven<E> node2KShiven: nodesInGraph) {
            printCycles(node2KShiven, nodesInGraph.getLast(), path);
        }
     }

}
