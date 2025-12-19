package taskmanager;

import java.util.NoSuchElementException;

public class TaskManager_2_KShiven {

    private Task_2_KShiven firstTask;
    private int size; // this is mainly used for the testing class to pick a rand element

    public void addTask(int id, String description, String deadline) {
        Task_2_KShiven task = new Task_2_KShiven(id, description, deadline);

        if (firstTask == null) {
            firstTask = task;
            size++;
            return;
        }
        if (isBefore(task.getDeadline(), firstTask.getDeadline())) {
                task.setNextTask(firstTask);
                firstTask = task;
                size++;
                return;
        }

        Task_2_KShiven current = firstTask;
        while (current.getNextTask() != null && isBefore(current.getNextTask().getDeadline(), task.getDeadline())) {
            current = current.getNextTask();
        }
        task.setNextTask(current.getNextTask());
        current.setNextTask(task);
        size++;
    }

    public void removeTask(int id) {
        if (firstTask == null) throw new NoSuchElementException("List is empty, ID can't exist");
        if (firstTask.getID() == id) {
            firstTask = firstTask.getNextTask();
            size--;
            return;
        }
        Task_2_KShiven current = firstTask;
        while (current.getNextTask() != null) {
            if (current.getNextTask().getID() == id) {
                current.setNextTask(current.getNextTask().getNextTask());
                size--;
                return;
            }
            current = current.getNextTask();
        }
        throw new NoSuchElementException("Task with ID " + id + " not found");
    }

    public void searchTasksByDeadline(String deadline) {
        if (firstTask == null) throw new NoSuchElementException("List is empty, so a deadline for anything can't exist");
        System.out.println("Tasks due by " + deadline + " are");
        Task_2_KShiven current = firstTask;
        boolean haveWeFoundAnythingYetIRealizedThisIsAReallyLongVariableName = false;

        while (current != null) {
            if (isBefore(current.getDeadline(), deadline)) {
                System.out.println(current);
                haveWeFoundAnythingYetIRealizedThisIsAReallyLongVariableName = true;
            } else {
                break;
            }
            current = current.getNextTask();
        }
        if (!haveWeFoundAnythingYetIRealizedThisIsAReallyLongVariableName) {
            throw new NoSuchElementException("Tasks by this deadline are not found");
        }
    }


    /**
     * trys to display all tasks
     */
    public void displayAllTasks() {
        Task_2_KShiven current = firstTask;
        while (current != null) {
            System.out.print(current + "\n");
            current = current.getNextTask();
        }
    }
    public void displayNextTask() {
        if (firstTask == null) throw new NoSuchElementException("List is empty, ID can't exist");
        System.out.println(firstTask);
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
        if (deadLine.contains("/")) {
            deadLine = deadLine.replace("/", "");
        } else {
            deadLine = deadLine.replace("-", "");
        }
        return Integer.parseInt(deadLine);
    }

    public int getSize() {
        return this.size;
    }

    public Task_2_KShiven getFirstTask() {
        return this.firstTask;
    }
}
