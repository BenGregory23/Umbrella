package com.umbrella.game.utils.tasks;

public class MainTask extends Task {

    public MainTask() {
        super(TaskType.DEFAULT);
    }

    @Override
    public void run() {
        if (!isStopped()) {
            // TODO
        }
    }
}
