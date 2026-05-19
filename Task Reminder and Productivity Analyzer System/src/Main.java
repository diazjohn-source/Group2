import java.util.ArrayList;
import java.util.Scanner;

import exception.InvalidTaskException;
import model.*;
import service.*;

public class Main {

    public static void validateDueDays(int days)
            throws InvalidTaskException {

        if (days < -30 || days > 365) {
            throw new InvalidTaskException("Invalid due days input.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Task> tasks = new ArrayList<>();

        ProductivityService productivityService =
                new ProductivityService();

        ScheduleService scheduleService =
                new ScheduleService();

        int choice;

        do {
            System.out.println("\n===== TASK REMINDER SYSTEM =====");
            System.out.println("1. Add Study Task");
            System.out.println("2. Add Work Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Complete Task");
            System.out.println("5. Check Productivity");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Task ID: ");
                        int sid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Title: ");
                        String stitle = sc.nextLine();

                        System.out.print("Due in Days: ");
                        int sdays = sc.nextInt();
                        sc.nextLine();

                        validateDueDays(sdays);

                        System.out.print("Subject: ");
                        String subject = sc.nextLine();

                        System.out.println("Priority Level:");
                        System.out.println("1. LOW");
                        System.out.println("2. MEDIUM");
                        System.out.println("3. HIGH");

                        int priorityChoice = sc.nextInt();
                        sc.nextLine();

                        PriorityLevel priority;
                        switch (priorityChoice) {
                            case 1:
                                priority = PriorityLevel.LOW;
                                break;

                            case 2:
                                priority = PriorityLevel.MEDIUM;
                                break;

                            case 3:
                                priority = PriorityLevel.HIGH;
                                break;

                            default:
                                priority = PriorityLevel.LOW;
                        }

                        StudyTask studyTask = new StudyTask(sid, stitle, sdays, priority, subject);
                        tasks.add(studyTask);

                        System.out.println("Study task added!");
                        break;

                    case 2:

                        System.out.print("Task ID: ");
                        int wid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Title: ");
                        String wtitle = sc.nextLine();

                        System.out.print("Due in Days: ");
                        int wdays = sc.nextInt();
                        sc.nextLine();

                        validateDueDays(wdays);

                        System.out.print("Department: ");
                        String department = sc.nextLine();

                        System.out.println("Priority Level:");
                        System.out.println("1. LOW");
                        System.out.println("2. MEDIUM");
                        System.out.println("3. HIGH");

                        int workPriorityChoice = sc.nextInt();
                        sc.nextLine();

                        PriorityLevel workPriority;

                        switch (workPriorityChoice) {

                            case 1:
                                workPriority = PriorityLevel.LOW;
                                break;

                            case 2:
                                workPriority = PriorityLevel.MEDIUM;
                                break;

                            case 3:
                                workPriority = PriorityLevel.HIGH;
                                break;

                            default:
                                workPriority = PriorityLevel.LOW;
                        }

                        WorkTask workTask = new WorkTask(wid, wtitle, wdays, workPriority, department);

                        tasks.add(workTask);

                        System.out.println("Work task added!");
                        break;

                    case 3:
                        if (tasks.isEmpty()) {
                            System.out.println("No tasks found.");
                        }
                        for (Task task : tasks) {
                            task.displayInfo();

                            if (task.isOverdue()) {
                                System.out.println("STATUS: OVERDUE");

                                if (task.getPriority()
                                        == PriorityLevel.HIGH) {

                                    System.out.println("URGENT: HIGH PRIORITY TASK OVERDUE!");
                                }
                            }

                            System.out.println();
                        }

                        break;

                    case 4:

                        System.out.print("Enter Task ID: ");

                        int completeId = sc.nextInt();

                        boolean found = false;

                        for (Task task : tasks) {

                            if (task.getTaskId()
                                    == completeId) {

                                task.completeTask();

                                System.out.println(
                                        "Task marked completed."
                                );

                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("Task not found.");
                        }

                        break;

                    case 5:

                        double score = productivityService
                                .calculateScore(tasks);

                        System.out.println(
                                "Productivity Score: "
                                        + score + "%"
                        );

                        scheduleService
                                .suggestSchedule(score);

                        break;

                    case 6:

                        System.out.println("Program exited.");
                        break;

                    default:

                        System.out.println("Invalid choice.");
                }

            } catch (InvalidTaskException e) {

                System.out.println(
                        "ERROR: " + e.getMessage()
                );

            } catch (Exception e) {

                System.out.println("Invalid input.");
                sc.nextLine();
            }

        } while (choice != 6);

        sc.close();
    }
}