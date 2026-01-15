/*
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import java.util.Random;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import taskmanager.TaskManager_2_KShiven;
import org.junit.jupiter.api.Test;


public class TaskmanTest {

    TaskManager_2_KShiven taskman;
    Random rand;
    String description;

    @BeforeEach
    void init() {
        taskman = new TaskManager_2_KShiven();
        rand = new Random();
        description = "Just a generic String";
    }

    @Test
    void testAddingToEmptyList() {
        int id = 100;
        String date = genDate();
        taskman.addTask(id, description, date);

        assertEquals(1, taskman.getSize());

        var firstTask = taskman.getFirstTask();
        assertEquals(description, firstTask.getDescription());
        assertEquals(id, firstTask.getID());
        assertEquals(date, firstTask.getDeadline());
    }

    @Test
    void testAddingToOneElementList() {
        int id1 = 100;
        String date1 = genDate();
        taskman.addTask(id1, description + id1, date1);

        int id2 = 200;
        String date2 = genDate();
        taskman.addTask(id2, description + id2, date2);

        assertEquals(2, taskman.getSize());

    }

    public String genDate() {
        boolean slashes = rand.nextBoolean();
        int i_year = rand.nextInt(0, 9999);
        int i_month = rand.nextInt(1, 13);
        int i_day = 0;
        if (i_month == 2) {
            i_day = rand.nextInt(1, 28);
        }
        if (i_month != 2) {
            if (i_month % 2 == 0) {
                i_day = rand.nextInt(1,31);
            } else {
                i_day = rand.nextInt(1,32);
            }
        }
        String year = parseYear(i_year);
        String month = parseTwoDigits(i_month);
        String day = parseTwoDigits(i_day);
        if (slashes) {
            return year + "/" + month + "/" + day;
        } else {
            return year + "-" + month + "-" + day;
        }
    }

    private String parseYear(int i_year) {
        String year = "" + i_year;
        if (i_year < 10) {
            year = "000" + i_year;
        } else if (i_year < 100) {
            year = "00" + i_year;
        } else if (i_year < 1000) {
            year = "0" + i_year;
        }
        return year;
    }

    private String parseTwoDigits(int value) {
        String twoDigits = "" + value;
        if (value < 10) {
            twoDigits = "0" + value;
        }
        return twoDigits;
    }

}
*/
