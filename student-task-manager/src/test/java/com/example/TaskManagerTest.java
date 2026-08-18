package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void shouldAddTask() {
        TaskManager manager = new TaskManager();
        manager.addTask("Learn Jenkins");
        assertEquals(1, manager.getTasks().size());
        assertEquals("Learn Jenkins", manager.getTasks().get(0));
    }

    @Test
    void shouldCompleteTask() {
        TaskManager manager = new TaskManager();
        manager.addTask("Learn Docker");
        manager.completeTask(0);
        assertEquals(1, manager.getCompletedTaskCount());
        assertEquals(0, manager.getPendingTaskCount());
    }

    @Test
    void shouldCountPendingTasks() {
        TaskManager manager = new TaskManager();
        manager.addTask("Learn Git");
        manager.addTask("Learn Jenkins");
        manager.addTask("Learn Docker");
        assertEquals(3, manager.getPendingTaskCount());
    }

    @Test
    void shouldRemoveTask() {
        TaskManager manager = new TaskManager();
        manager.addTask("Learn Java");
        manager.addTask("Learn Jenkins");
        manager.removeTask(0);
        assertEquals(1, manager.getTasks().size());
        assertEquals("Learn Jenkins", manager.getTasks().get(0));
    }

    @Test
    void shouldRejectEmptyTask() {
        TaskManager manager = new TaskManager();
        assertThrows(IllegalArgumentException.class, () -> manager.addTask(""));
    }

    @Test
    void shouldRejectInvalidIndex() {
        TaskManager manager = new TaskManager();
        manager.addTask("Learn Jenkins");
        assertThrows(IndexOutOfBoundsException.class, () -> manager.completeTask(5));
    }
}
