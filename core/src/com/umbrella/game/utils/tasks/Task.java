package com.umbrella.game.utils.tasks;

public class Task extends Thread {

    private TaskType type;
    private boolean stop;

    public Task(TaskType type) {
        this.type = type;
        this.stop = false;
    }

    /**
     * ALL THREAD ENDED CANNOT BE RESTARTED.
     */
    public void end() {
        this.stop = true;
    }

    public boolean isStopped() {
        return stop;
    }
}
