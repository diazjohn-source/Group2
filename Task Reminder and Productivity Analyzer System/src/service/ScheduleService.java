package service;

public class ScheduleService {

    public void suggestSchedule(double productivityScore) {

        System.out.println("\n===== PRODUCTIVITY RECOMMENDATION =====");

        if (productivityScore >= 80) {

            System.out.println("Excellent productivity!");
            System.out.println("Maintain your current schedule.");

        } else if (productivityScore >= 50) {

            System.out.println("Average productivity.");
            System.out.println("Try using time blocking techniques.");

        } else {

            System.out.println("Low productivity detected.");
            System.out.println("Reduce distractions and create a study routine.");
        }
    }
}