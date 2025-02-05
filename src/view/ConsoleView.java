package view;

import java.util.List;
import model.Task;

/**
 * Handles user interaction and displays tasks in the console.
 */
public class ConsoleView {

    public void displayMenu() {
        System.out.println("\n--- Task Manager ---");
        System.out.println("1. Add Task");
        System.out.println("2. List Tasks");
        System.out.println("3. Complete Task");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void displayTasks(List<Task> tasks) {
        System.out.println("\nTask List:");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).toString());
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
