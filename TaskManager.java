package com.mycompany.easykanbanapp1;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();
    private int totalHours = 0;

    public void addTask(Task task) {
        tasks.add(task);
        totalHours += task.taskDuration;
    }

    public String getTasksWithStatus(String status) {
        StringBuilder report = new StringBuilder();
        for (Task task : tasks) {
            if (task.taskStatus.equalsIgnoreCase(status)) {
                report.append(task.printTaskDetails()).append("\n");
            }
        }
        return report.length() > 0 ? report.toString() : "No tasks with status: " + status;
    }

    public String getLongestTask() {
        return tasks.stream()
                .max((t1, t2) -> Integer.compare(t1.taskDuration, t2.taskDuration))
                .map(Task::printTaskDetails)
                .orElse("No tasks available.");
    }

    public String getAllTasksReport() {
        StringBuilder report = new StringBuilder();
        for (Task task : tasks) {
            report.append(task.printTaskDetails()).append("\n");
        }
        return report.length() > 0 ? report.toString() : "No tasks available.";
    }

    public int getTotalHours() {
        return totalHours;
    }
}
