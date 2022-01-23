package com.umbrella.game.manager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.umbrella.game.client.UserInput;
import com.umbrella.game.object.GameObject;
import com.umbrella.game.object.Player;

public class GameManager {
    private static GameManager gameManager;
    private Player player;
    private UserInput userInput;

    private GameManager(){
        player = new Player("player", new Texture("img/player.png"), 100, 20);
        userInput = new UserInput();

    }

    public static GameManager getInstance(){
        if(GameManager.gameManager == null){
            GameManager.gameManager = new GameManager();
        }
        return GameManager.gameManager;
    }

    public Player getPlayer(){
        return player;
    }

    public UserInput getUserInput(){
        return userInput;
    }

}
