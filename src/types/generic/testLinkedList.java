package types.generic;

import java.util.Random;
public class testLinkedList {

    /*
     *  TODO:
     *  Node: Done, Checked
     *  addFirst(): Done, Checked
     *  addLast(): Done, Checked
     *  add(): Done, Checked
     *  search(): Done, Checked
     *  replace(): Done, Checked
     *  size(): Done, Checked
     *  removeFirst(): Done, Testing
     *  removeLast(): Done, Testing
     *  remove(): Done, Testing
     *  (int) remove(): Done, testing
     */

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Random rand = new Random();
        list.display();
//        System.out.println("------------------ // this should remove 9, and print 9");
//        System.out.println(list.removeFirst());
//        list.display();
//        System.out.println("------------------ // this should remove 6,and print 6");
//        System.out.println(list.removeLast());
//        list.display();
//        System.out.println("------------------ // this should remove 7, and print 7");
//        System.out.println(list.remove(1));
//
//        list.append(10);
//        list.append(11);
//        list.append(12);
//        list.append(13);
//        System.out.println("NEW LIST: ");
//        list.display();
//
//        System.out.println("------------------ // this should remove 12 and print the index 3");
//        System.out.println(list.remove(12));

        System.out.println(list.remove(0));











    }

}
