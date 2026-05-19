package model;

public abstract class Task implements Displayable {

    private int taskId;
    private String title;
    private int dueDays;
    private boolean completed;
    private PriorityLevel priority;

    public Task(int taskId, String title, int dueDays, PriorityLevel priority) {
        this.taskId = taskId;
        this.title = title;
        this.dueDays = dueDays;
        this.priority = priority;
        this.completed = false;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public int getDueDays() {
        return dueDays;
    }

    public boolean isCompleted() {
        return completed;
    }

    public PriorityLevel getPriority() {
        return priority;
    }

    public void completeTask() {
        completed = true;
    }

    public boolean isOverdue() {
        return dueDays < 0 && !completed;
    }

    public abstract String getTaskType();
}