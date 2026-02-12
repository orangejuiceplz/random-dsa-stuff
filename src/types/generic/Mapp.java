package types.generic;

public class Mapp {

    public static void main(String[] args) {
        Map_2_KShiven<String, Integer> map = new Map_2_KShiven<>();
        map.add("a", 1);
        map.add("b", 2);
        System.out.println(map);
        System.out.println(map.set("a", 9));



    }

}
