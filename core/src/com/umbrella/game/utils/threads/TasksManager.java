package com.umbrella.game.utils.threads;

import java.util.ArrayList;
import java.util.HashSet;

public class TasksManager {

    // Set containing all tasks
    private HashSet<Task> tasks;

    /**
     * Constructor taking multiple tasks as parameter and loading them.
     * @param tasks
     */
    public TasksManager(Task... tasks) {
        for (Task task : tasks) {
            this.tasks.add(task);
            task.run();
        }
        System.out.println(String.format("TasksManager loaded %d tasks.",
                tasks.length));
    }

    public void end() {
        for (Task task : tasks) {
            task.end();
            task = null;
        }
    }

}
