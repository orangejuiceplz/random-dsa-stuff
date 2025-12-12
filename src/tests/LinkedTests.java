package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import java.util.Random;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import types.generic.LinkedList;
import org.junit.jupiter.api.Test;
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

public class LinkedTests {

    LinkedList<Integer> list;
    Random rand;

    @BeforeEach
    void init() {
        list = new LinkedList<>();
        rand = new Random();
        for (int i = 0; i < 10; i++) {
            list.append(rand.nextInt(10));
        }
    }

    @Test
    void testAddFirst() {
        int toAdd = rand.nextInt(10);
        list.addFirst(toAdd);
        assertEquals((int) list.getNodeValueAtIndex(0), toAdd);
    }
    @Test
    void testAddLast() {
        int toAdd = rand.nextInt(10);
        list.addLast(toAdd);
        assertEquals((int) list.getNodeValueAtIndex(list.size() - 1), toAdd);
    }

    @Test
    void testAdd() {
        int toAdd = rand.nextInt(10);
        int index = rand.nextInt(list.size() - 1);
        list.add(index, toAdd);
        assertEquals((int) list.getNodeValueAtIndex(index), toAdd);
    }
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void testSearch(boolean eleInList) {
        if (eleInList) {
            int toSearchFor = list.getNodeValueAtIndex(rand.nextInt(list.size() - 1));
            int index = list.search(toSearchFor);
            assertEquals((int) list.getNodeValueAtIndex(index), toSearchFor);

        }



    }



}
