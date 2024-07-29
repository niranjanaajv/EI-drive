import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<Observer> observers;
    private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName());

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public boolean addTask(Task task) {
        for (Task existingTask : tasks) {
            if (task.conflictsWith(existingTask)) {
                String message = "Error: Task conflicts with existing task \"" + existingTask.getDescription() + "\".";
                logger.severe(message);
                notifyObservers(message);
                return false;
            }
        }
        tasks.add(task);
        Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
        logger.info("Task added successfully: " + task.getDescription());
        notifyObservers("Task added successfully: " + task.getDescription());
        return true;
    }

    public boolean removeTask(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                tasks.remove(task);
                logger.info("Task removed successfully: " + description);
                notifyObservers("Task removed successfully: " + description);
                return true;
            }
        }
        String message = "Error: Task not found.";
        logger.severe(message);
        notifyObservers(message);
        return false;
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}
