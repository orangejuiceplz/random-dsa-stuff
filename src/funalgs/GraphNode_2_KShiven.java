package funalgs;

import java.util.ArrayList;

public class GraphNode_2_KShiven <E>{
    private ArrayList<GraphNode_2_KShiven<E>> pointers = new ArrayList<>() ;
    private E value;

    public GraphNode_2_KShiven(E value) {
        this.value = value;
    }

    public ArrayList<GraphNode_2_KShiven<E>> getPointers() {
        return this.pointers;
    }

    public E getValue() {
        return this.value;
    }

    public void addConnection(GraphNode_2_KShiven<E> node) {
        pointers.add(node);
    }

//    public void printConnections() {
//        System.out.print(value + " -> ");
//        for (GraphNode_2_KShiven<E> node2KShiven: pointers) {
//            System.out.println(node2KShiven.getValue());
//        }
//    }

}
