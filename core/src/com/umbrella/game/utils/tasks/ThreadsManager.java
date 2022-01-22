package com.umbrella.game.utils.tasks;

import java.util.HashSet;
import java.util.Set;

public class ThreadsManager {

    // Set containing all tasks
    private Set<GameThread> threads;

    /**
     * Creating an instance of the set that will contain the threads
     * and adding the threads to the set, so they can be manipulated later.
     * @param threads Array of the threads to add.
     */
    public ThreadsManager(GameThread... threads) {
        this.threads = new HashSet<>();
        for (GameThread thread : threads) {
            this.threads.add(thread);
            thread.start();
        }
    }

    public void clear() {
        for (GameThread thread : threads) {
            thread.kill();
        }
        threads.clear();
        System.gc(); // Calling the GC to free up the ram.
    }

}
