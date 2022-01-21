package com.umbrella.game.utils.tasks;

import com.badlogic.gdx.Gdx;
import com.umbrella.game.client.UserInput;

public class InputThread extends GameThread {


    public InputThread() {
        super(0);
    }

    @Override
    public void run() {
        running.set(true);
        stopped.set(false);

        while (running.get()) {
            UserInput userInput = new UserInput();
            Gdx.input.setInputProcessor(userInput);
        }
        stopped.set(true);
    }


}
