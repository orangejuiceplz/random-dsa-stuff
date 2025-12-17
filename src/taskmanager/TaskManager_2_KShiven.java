package taskmanager;

import java.util.NoSuchElementException;

public class TaskManager_2_KShiven<T> {

    private Task_2_KShiven firstTask;
    private int size;

    public void addTask(int id, String description, String deadline) {
        Task_2_KShiven task = new Task_2_KShiven(id, description, deadline);
        if (firstTask == null) {
            firstTask = task;
            size++;
            return;
        }
        Task_2_KShiven current = firstTask;
        if (isBefore(current.getDeadline(), task.getDeadline())) {
            firstTask.setNextTask(firstTask);
            firstTask = current;
            size++;
            return;
        }
    }

    public void removeTask(int id) {
        if (id < 0 || id > size - 1) throw new NoSuchElementException("No such ID in the manager");
    }


    /**
     * trys to display all tasks
     */
    public void display() {
        Task_2_KShiven current = firstTask;
        while (current != null) {
            System.out.print(current.toString() + " -> ");
            current = current.getNextTask();
        }
    }


    /**
     *
     * @param sDeadLine1
     * first deadline
     * @param sDeadLine2
     * second deadline
     * @return
     * returns if the first deadline is before the second deadline
     */
    private boolean isBefore(String sDeadLine1, String sDeadLine2) {
        int deadLine1 = extractDate(sDeadLine1);
        int deadLine2 = extractDate(sDeadLine2);
        return deadLine1 <= deadLine2;
    }

    private int extractDate(String deadLine) {
        int date = 0;
        for (int i = 0; i < deadLine.length(); i++) {
            if (deadLine.charAt(i) != '-') {
                date += deadLine.charAt(i);
            }
        }
        return date;
    }
    // 11312005
    // 11312004





}
