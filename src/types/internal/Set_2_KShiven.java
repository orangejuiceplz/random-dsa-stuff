package types.internal;

import java.util.ArrayList;

public class Set_2_KShiven<E> {

    ArrayList<E> set;

    public Set_2_KShiven() {
        set = new ArrayList<>();
    }

    public boolean add(E element) {
        if (!set.contains(element)) set.add(element);
        return false;
    }

    public boolean remove (E element) {
        return set.remove(element);
    }

    public void clear() {
        set.clear();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public boolean contains(E element) {
        return set.contains(element);
    }

    public String toString() {
         // return "{" + set.toString().replace("[", "").replace("]", "") + "}";
        return "{" + set.toString().substring(1, set.toString().length() - 1) + "}";
    }


}
