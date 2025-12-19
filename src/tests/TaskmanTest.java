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

    @BeforeEach
    void init() {
        taskman = new TaskManager_2_KShiven();
        rand = new Random();
    }

    @Test
    void testAddingToEmptyList() {
        int id = rand.nextInt(100);
        taskman.addTask(id, "Task" + id, genDate());
    }

    private String genDate() {
        int year = rand.nextInt(0, 9999);
        int month = rand.nextInt(13);
        int day = rand.nextInt(32);
        return year + "/" + month + "/" + day;
    }

}
