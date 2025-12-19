package taskmanager;

public class testTask {
    public static void main(String[] args) {
        TaskManager_2_KShiven taskManager = new TaskManager_2_KShiven();
        taskManager.addTask(2, "Task 2", "12-01-2005");
        taskManager.addTask(1, "Task 97", "11-31-2005");
        taskManager.addTask(3, "Task 3", "12-31-2005");
        taskManager.addTask(5, "Task 5", "12-17-2005");
        taskManager.displayAllTasks();
        System.out.println("-----------------------");
        taskManager.removeTask(1);
        taskManager.displayAllTasks();
        System.out.println("-----------------------");
        taskManager.displayNextTask();
        System.out.println("-----------------------");
        taskManager.searchTasksByDeadline("11-31-2004");
    }
}
