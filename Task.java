package com.mycompany.easykanbanapp1;

public class Task {
    String taskName, taskDescription, developerDetails, taskID, taskStatus;
    int taskDuration;

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, int index) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = "T" + index;
        this.taskStatus = "To Do"; // Default status
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String printTaskDetails() {
        return "Task ID: " + taskID + "\nTask Name: " + taskName + "\nTask Description: " + taskDescription +
                "\nDeveloper: " + developerDetails + "\nDuration: " + taskDuration + " hours\nStatus: " + taskStatus;
    }
}
