package com.umbrella.game.utils.tasks;

public class AudioThread extends GameThread {

    public AudioThread(int sleepInterval) {
        super(sleepInterval);
    }

    @Override
    public void run() {
        running.set(true);
        stopped.set(false);

        while (running.get()) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println(String.format("THREAD %s WAS INTERRUPTED. ATTEMPTING A THREAD RESTART", getClass().getName()));
                this.start();
            }
        }
        stopped.set(true);
    }
}
