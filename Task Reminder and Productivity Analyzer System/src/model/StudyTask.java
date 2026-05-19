package model;

public class StudyTask extends Task {

    private String subject;

    public StudyTask(int taskId, String title,
                     int dueDays,
                     PriorityLevel priority,
                     String subject) {

        super(taskId, title, dueDays, priority);
        this.subject = subject;
    }

    @Override
    public String getTaskType() {
        return "Study Task";
    }

    @Override
    public void displayInfo() {

        System.out.println("===== STUDY TASK =====");
        System.out.println("ID: " + getTaskId());
        System.out.println("Title: " + getTitle());
        System.out.println("Subject: " + subject);
        System.out.println("Due In: " + getDueDays() + " days");
        System.out.println("Priority: " + getPriority());
        System.out.println("Completed: " + isCompleted());
    }
}