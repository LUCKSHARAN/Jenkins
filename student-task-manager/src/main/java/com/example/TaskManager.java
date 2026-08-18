package com.example;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<String> tasks = new ArrayList<>();
    private final List<Boolean> completed = new ArrayList<>();

    public void addTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be empty");
        }
        tasks.add(task);
        completed.add(false);
    }

    public List<String> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void completeTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("Invalid task index");
        }
        completed.set(index, true);
    }

    public int getPendingTaskCount() {
        int count = 0;
        for (boolean status : completed) {
            if (!status) count++;
        }
        return count;
    }

    public int getCompletedTaskCount() {
        int count = 0;
        for (boolean status : completed) {
            if (status) count++;
        }
        return count;
    }

    public void removeTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("Invalid task index");
        }
        tasks.remove(index);
        completed.remove(index);
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask("Learn Git");
        manager.addTask("Learn Jenkins");
        manager.addTask("Learn Docker");
        manager.completeTask(0);

        System.out.println("===== STUDENT TASK MANAGER =====");
        for (int i = 0; i < manager.getTasks().size(); i++) {
            String status = (i == 0) ? "COMPLETED" : "PENDING";
            System.out.println((i + 1) + ". " + manager.getTasks().get(i) + " - " + status);
        }

        System.out.println("\nCompleted Tasks: " + manager.getCompletedTaskCount());
        System.out.println("Pending Tasks: " + manager.getPendingTaskCount());
    }
}
