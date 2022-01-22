package com.umbrella.game.utils.tasks;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class GameThread implements Runnable {

    private Thread worker;
    protected final AtomicBoolean running = new AtomicBoolean(false);
    protected final AtomicBoolean stopped = new AtomicBoolean(false);
    protected int interval;

    public GameThread(int sleepInterval) {
        interval = sleepInterval;
    }

    public void start() {
        worker = new Thread(this);
        worker.start();
    }

    public boolean isRunning() {
        return running.get();
    }

    public boolean isStopped() {
        return stopped.get();
    }

    public void kill() {
        running.set(false);
        worker.interrupt();
    }

}
