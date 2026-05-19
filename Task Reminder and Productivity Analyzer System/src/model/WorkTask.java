package model;

public class WorkTask extends Task {

    private String department;

    public WorkTask(int taskId, String title,
                    int dueDays,
                    PriorityLevel priority,
                    String department) {

        super(taskId, title, dueDays, priority);
        this.department = department;
    }

    @Override
    public String getTaskType() {
        return "Work Task";
    }

    @Override
    public void displayInfo() {

        System.out.println("===== WORK TASK =====");
        System.out.println("ID: " + getTaskId());
        System.out.println("Title: " + getTitle());
        System.out.println("Department: " + department);
        System.out.println("Due In: " + getDueDays() + " days");
        System.out.println("Priority: " + getPriority());
        System.out.println("Completed: " + isCompleted());
    }
}