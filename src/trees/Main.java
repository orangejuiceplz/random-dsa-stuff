package trees;

public class Main {

    public static void main(String[] args) {
        BST_2_KShiven<Integer> test = new BST_2_KShiven<>();

        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(7);
        test.add(1);

        System.out.println(test.add(1)); // assert FALSE
        System.out.println(test.search(3)); // assert TRUE
        System.out.println(test.preorder(test.getRoot()));
        System.out.println(test.inOrder(test.getRoot()));
        System.out.println(test.postOrder(test.getRoot()));
        System.out.println(test.height(test.getRoot()));
        System.out.println(test.depth(7));



    }
}
