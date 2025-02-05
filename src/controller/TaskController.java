package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Task;
import view.ConsoleView;

/**
 * Manages user input, updates the model, and refreshes the view.
 */
public class TaskController {
    private List<Task> tasks;
    private ConsoleView view;
    private Scanner scanner;

    public TaskController() {
        tasks = new ArrayList<>();
        view = new ConsoleView();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            view.displayMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    addTask();
                    break;
                case "2":
                    view.displayTasks(tasks);
                    break;
                case "3":
                    completeTask();
                    break;
                case "4":
                    exit = true;
                    view.displayMessage("Exiting...");
                    break;
                default:
                    view.displayMessage("Invalid option. Please try again.");
            }
        }
    }

    private void addTask() {
        view.displayMessage("Enter task description:");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        view.displayMessage("Task added successfully.");
    }

    private void completeTask() {
        view.displayTasks(tasks);
        view.displayMessage("Enter the task number to complete:");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < tasks.size()) {
                tasks.get(index).completeTask();
                view.displayMessage("Task marked as completed.");
            } else {
                view.displayMessage("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            view.displayMessage("Invalid input. Please enter a number.");
        }
    }
}
