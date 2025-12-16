package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import java.util.Random;

import org.junit.jupiter.api.Disabled;
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
 *  removeFirst(): Done, Checked
 *  removeLast(): Done, Checked
 *  remove(): Done, Checked
 *  (int) remove(): Done, Checked
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

        } else {
            int toSearchFor = 999999;
            int index = list.search(toSearchFor);
            assertEquals(index, -1);
        }
    }

    @Test
    void testRemoveFirst() {
        int toBeRemoved = list.getNodeValueAtIndex(0);
        int removed = list.removeFirst();
        assertEquals(removed, toBeRemoved);
    }
    @Test
    void testRemoveLast() {
        int toBeRemoved = list.getNodeValueAtIndex(list.size() - 1);
        int removed = list.removeLast();
        assertEquals(removed, toBeRemoved);
    }
    @Test
    void testRemoveValueAtIndex() {
        int indexToRemove = rand.nextInt(list.size());
        int value = list.getNodeValueAtIndex(indexToRemove);
        assertEquals(value, list.remove(indexToRemove));
    }
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void testRemoveValue(boolean eleInList) {

//        assertEquals(list.remove(value), index);
        if (eleInList) {
            int value = list.getNodeValueAtIndex(rand.nextInt(list.size()));
            int index = list.search(value);
            assertEquals(value, list.remove(index));
        } else {
            int value = 9999999;
            int index = list.search(value);
            assertEquals(index, -1);
        }
    }



}
