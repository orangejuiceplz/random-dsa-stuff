package types.internal;

public class testSets {


    public static void main(String[] args) {
        Set_2_KShiven<Integer> set = new Set_2_KShiven<>();
        set.add(5);
        set.add(6);
        set.add(7);
        set.remove(7);
        System.out.println(set.isEmpty());
        System.out.println(set.toString());
        set.clear();
        System.out.println(set.toString());
    }

}
