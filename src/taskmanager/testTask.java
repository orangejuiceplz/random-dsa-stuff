package taskmanager;

public class testTask {
    public static void main(String[] args) {
        TaskManager_2_KShiven taskManager = new TaskManager_2_KShiven();
        taskManager.addTask(2, "Task 2", "12-01-2005");
        taskManager.addTask(97, "Task 97", "11-31-2005");
        taskManager.display();
    }
}
