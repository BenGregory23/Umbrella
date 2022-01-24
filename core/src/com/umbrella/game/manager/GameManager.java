package com.umbrella.game.manager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.umbrella.game.client.UserInput;
import com.umbrella.game.object.GameObject;
import com.umbrella.game.object.Player;

public class GameManager {
    private static GameManager gameManager;
    private Player player;
    private UserInput userInput;
    private SpriteBatch batch = new SpriteBatch();

    private GameManager(){
        player = new Player("player", new Texture("img/player/dwarf/down.png"), 100, 20);
        userInput = new UserInput();

    }

    public static GameManager getInstance(){
        if(GameManager.gameManager == null){
            GameManager.gameManager = new GameManager();
        }
        return GameManager.gameManager;
    }


    public void gameLoop(){
        userInput.input();
        player.render();
    }

    public Player getPlayer(){
        return player;
    }

    public UserInput getUserInput(){
        return userInput;
    }

}
