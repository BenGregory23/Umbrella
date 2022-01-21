package com.umbrella.game.utils.threads;

import com.sun.istack.internal.NotNull;

public abstract class Task implements Runnable {

    private TaskType type;
    private boolean stop;

    public Task(TaskType type) {
        this.type = type;
        this.stop = false;
    }

    protected abstract void init();

    @Override
    public void run() {
        while (!stop) {
            init();
        }
    }

    public boolean isStopped() {
        return stop;
    }

    /**
     * ALL THREAD ENDED CANNOT BE RESTARTED.
     */
    public void end() {
        this.stop = true;
    }
}
