
import java.util.*;
class Task {
    private String title;
    private boolean isCompleted;

    public Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }


    public void markCompleted() {
        isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return (isCompleted ? "[✔] " : "[ ] ") + title;
    }
}

class TaskManager {

    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String title) {
        Task task = new Task(title);
        tasks.add(task);
        System.out.println("Task added!");
    }

    public void viewTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Your Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

    }

    public void deleteTask(int index) {
        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid task number.");
        } else {
            tasks.remove(index - 1);
            System.out.println("Task deleted!");
        }
    }


    public void markTaskCompleted(int index) {
        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid task number.");
        } else {
            tasks.get(index - 1).markCompleted();
            System.out.println("Task marked as completed!");
        }
    }


}
public class ToDoList {
public static void  main(String args[]){

    Scanner sc = new Scanner(System.in);
    TaskManager manager = new TaskManager();
    int choice;

    do {
        System.out.println("\n===== TO DO LIST =====");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");

        choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {

            case 1:
                System.out.print("Enter task title: ");
                String title = sc.nextLine();
                manager.addTask(title);
                break;


            case 2:
                manager.viewTasks();
                break;

            case 3:
                System.out.print("Enter task number to mark completed: ");
                int completeNum = sc.nextInt();
                manager.markTaskCompleted(completeNum);
                break;

            case 4:
                System.out.print("Enter task number to delete: ");
                int deleteNum = sc.nextInt();
                manager.deleteTask(deleteNum);
                break;

            case 5:
                System.out.println("Goodbye!");
                break;

        }

    }while (choice!=5);


    }
}
