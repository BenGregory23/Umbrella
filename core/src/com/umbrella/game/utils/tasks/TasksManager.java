package com.umbrella.game.utils.tasks;

import java.util.HashSet;
import java.util.Set;

public class TasksManager {

    // Set containing all tasks
    private Set<Task> tasks;

    /**
     * Constructor taking multiple tasks as parameter and loading them.
     * @param tasks
     */
    public TasksManager(Task... tasks) {
        this.tasks = new HashSet<>();
        for (Task task : tasks) {
            this.tasks.add(task);
            task.start();
        }
        System.out.println(String.format("TasksManager loaded %d tasks.",
                tasks.length));
    }

    public void clear() {
        for (Task task : tasks) {
            task.end();
            task = null;
        }
        System.gc();
    }

}
