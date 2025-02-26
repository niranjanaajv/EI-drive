import java.util.Scanner;

public class AstronautScheduleApp {
    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        ConcreteObserver observer = new ConcreteObserver("Astronaut");
        scheduleManager.addObserver(observer);

        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Astronaut Daily Schedule Organizer");
        System.out.println("Commands: add, remove, view, exit");

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter start time (HH:mm): ");
                    String startTime = scanner.nextLine();
                    System.out.print("Enter end time (HH:mm): ");
                    String endTime = scanner.nextLine();
                    System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
                    String priority = scanner.nextLine();

                    Task task = TaskFactory.createTask(description, startTime, endTime, priority);
                    scheduleManager.addTask(task);
                    break;

                case "remove":
                    System.out.print("Enter description of the task to remove: ");
                    String taskDescription = scanner.nextLine();
                    scheduleManager.removeTask(taskDescription);
                    break;

                case "view":
                    scheduleManager.viewTasks();
                    break;

                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}
