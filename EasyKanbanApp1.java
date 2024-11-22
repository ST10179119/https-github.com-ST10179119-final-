package com.mycompany.easykanbanapp1;

import javax.swing.*;

public class EasyKanbanApp1 {

    private static Methods methods = new Methods();
    private static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Registration and Login
        if (registerUser() && loginUser()) {
            showMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Exiting application...");
        }
    }

    // User Registration
    private static boolean registerUser() {
        do {
            methods.firstName = JOptionPane.showInputDialog("Enter First Name:");
            methods.surname = JOptionPane.showInputDialog("Enter Surname:");
            methods.userName = JOptionPane.showInputDialog("Enter Username (minimum 5 characters):");
            methods.password = JOptionPane.showInputDialog("Enter Password (minimum 8 characters):");

            if (methods.checkUsername() && methods.checkPasswordComplexity()) {
                JOptionPane.showMessageDialog(null, methods.registerUser());
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            }
        } while (true);
    }

    // User Login
    private static boolean loginUser() {
        do {
            methods.enteredUserName = JOptionPane.showInputDialog("Enter Username:");
            methods.enteredPassword = JOptionPane.showInputDialog("Enter Password:");

            if (methods.loginUser()) {
                JOptionPane.showMessageDialog(null, methods.returnLoginStatus());
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid login. Please try again.");
            }
        } while (true);
    }

    // Main Menu
    private static void showMenu() {
        while (true) {
            String menu = "1. Add Tasks\n2. Show Report\n3. Quit";
            String choice = JOptionPane.showInputDialog(menu);

            if (choice == null) return;

            switch (choice) {
                case "1":
                    addTasks();
                    break;
                case "2":
                    showReport();
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Exiting application...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }

    // Add Tasks
    private static void addTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to add?"));

        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
            String developerDetails = JOptionPane.showInputDialog("Enter Developer Details:");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));

            Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, i);

            if (task.checkTaskDescription()) {
                taskManager.addTask(task);
                JOptionPane.showMessageDialog(null, task.printTaskDetails());
            } else {
                JOptionPane.showMessageDialog(null, "Task description is too long. Please try again.");
            }
        }

        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + taskManager.getTotalHours());
    }

    // Show Report
    private static void showReport() {
        String reportMenu = "1. Show tasks with 'Done' status\n2. Show the longest task\n3. Show all tasks\n";
        String choice = JOptionPane.showInputDialog(reportMenu);

        switch (choice) {
            case "1":
                JOptionPane.showMessageDialog(null, taskManager.getTasksWithStatus("Done"));
                break;
            case "2":
                JOptionPane.showMessageDialog(null, taskManager.getLongestTask());
                break;
            case "3":
                JOptionPane.showMessageDialog(null, taskManager.getAllTasksReport());
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid option. Returning to main menu.");
        }
    }
}

