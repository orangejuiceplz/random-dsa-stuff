package taskmanager;

public class Task_2_KShiven{

    private int id;
    private String description;
    private String deadline; // FORMAT: YYYY/MM/DD, make sure to append zeroes if the year is <1000, month is <10, and day is < 10
    private Task_2_KShiven nextTask;

    public Task_2_KShiven(int id, String description, String deadline) {
        this.id = id;
        this.description = description;
        this.deadline = deadline;
        this.nextTask = null;
    }

    public int getID() {
        return this.id;
    }
    public void setID(int id) {
        this.id = id;
    }
    public String getDescription() {
        return this.description;
    }

    /**
     * @return
     * deadline in the format you specified, if you use slashes, it will do YYYY/MM/DD
     * if you use dashes, it will do YYYY-MM-DD
     */
    public String getDeadline() {
        return this.deadline;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Task_2_KShiven getNextTask() {
        return this.nextTask;
    }

    public void setNextTask(Task_2_KShiven nextTask) {
        this.nextTask = nextTask;
    }

    public String toString() {
        return "ID: " + this.id + "\n Description: " + this.description + "\n Deadline: " + this.deadline;
    }
}
