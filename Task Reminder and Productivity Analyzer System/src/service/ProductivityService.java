package service;

import java.util.ArrayList;
import model.Task;

public class ProductivityService {

    public double calculateScore(ArrayList<Task> tasks) {

        if (tasks.isEmpty()) {
            return 0;
        }

        int completed = 0;

        for (Task task : tasks) {

            if (task.isCompleted()) {
                completed++;
            }
        }

        return ((double) completed / tasks.size()) * 100;
    }
}