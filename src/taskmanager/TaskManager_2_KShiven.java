package taskmanager;

import java.util.NoSuchElementException;

public class TaskManager_2_KShiven {

    private Task_2_KShiven firstTask;
    private int size; // this is mainly used for the testing class to pick a rand element


    /**
     * adds the task sorted already via the deadline
     * @param id
     * id to add
     * @param description
     * description you want for the task
     * @param deadline
     * deadline in a String format. Deadline should be written in YYYY/MM/DD or YYYY-MM-DD with zeroes appended to fit the format if needed
     */
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

    /**
     * tries to remove the task by the id specified
     * @param id
     * id to remove
     * @throws NoSuchElementException
     * if it is unable to find the ID, throw a NoSuchElementException error if you want to throw it
     */
    public void removeTask(int id) {
        boolean shouldThrow = true; //change this if you want to throw or just print.
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
        if (!shouldThrow) {
            System.out.println("No task with ID " + id + " could be found, so nothing was removed");
        } else {
            throw new NoSuchElementException("Task with ID " + id + " not found");
        }
    }


    /**
     * searches all tests before (includes the specified deadline) the deadline
     * @param deadline
     * deadline to search by (includes the date)
     * @throws NoSuchElementException
     * if the list empty or if they couldn't find anything before the date
     */
    public void searchTasksByDeadline(String deadline) {
        if (firstTask == null) throw new NoSuchElementException("List is empty, so a deadline for anything can't exist");
        System.out.println("Tasks due by " + deadline + " are");
        Task_2_KShiven current = firstTask;
        boolean haveWeFoundAnythingYetIRealizedThisIsAReallyLongVariableName = false;
        boolean shouldWeThrow = false;

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
            if (!shouldWeThrow) {
                System.out.println("No tasks by the deadline found");
            } else {
                throw new NoSuchElementException("Tasks by this deadline are not found");
            }
        }
    }


    /**
     * display all tasks
     */
    public void displayAllTasks() {
        Task_2_KShiven current = firstTask;
        while (current != null) {
            System.out.print(current + "\n");
            current = current.getNextTask();
        }
    }

    /**
     * displays the first task
     * @throws NoSuchElementException
     * if list is empty
     */
    public void displayNextTask() {
        if (firstTask == null) throw new NoSuchElementException("List is empty, ID can't exist");
        System.out.println(firstTask);
    }


    /**
     * @param sDeadLine1
     * first deadline (YYYY/MM/DD)
     * @param sDeadLine2
     * second deadline (YYYY/MM/DD)
     * @return
     * returns if the first deadline is before the second deadline
     */
    private boolean isBefore(String sDeadLine1, String sDeadLine2) {
        int deadLine1 = extractDate(sDeadLine1);
        int deadLine2 = extractDate(sDeadLine2);
        return deadLine1 <= deadLine2;
    }

    /**
     * @param deadLine
     * deadline in format YYYY/MM/DD or YYYY-MM-DD
     * @return
     * the extracted date as an int for easier removal. removes any slashes or dashes that was made by the user
     */
    private int extractDate(String deadLine) {
        if (deadLine.contains("/")) {
            deadLine = deadLine.replace("/", "");
        } else {
            deadLine = deadLine.replace("-", "");
        }
        return Integer.parseInt(deadLine);
    }

    // ----------------------------------------- used exclusively for the testing suite -----------------------

    public int getSize() {
        return this.size;
    }

    public Task_2_KShiven getFirstTask() {
        return this.firstTask;
    }
}
