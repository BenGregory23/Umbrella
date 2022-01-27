package com.umbrella.game.manager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.umbrella.game.client.UserInput;
import com.umbrella.game.object.AnimateObject;
import com.umbrella.game.player.Player;

public class GameManager {
    private static GameManager gameManager;
    private Player player;
    private UserInput userInput;
    private SpriteBatch batch = new SpriteBatch();
    private AnimateObject playerAnimation;

    private GameManager(){
        player = new Player("player", new Texture("img/player/dwarf/down.png"), 100, 20);
        userInput = new UserInput();
        playerAnimation = new AnimateObject(new Texture("img/player/dwarf/walkCycle-30x60.png"), new Texture("img/player/dwarf/walkCycle-30x60.png"), 60, 60, 4, player);
        playerAnimation.splitTexture();
    }

    public static GameManager getInstance(){
        if(GameManager.gameManager == null){
            GameManager.gameManager = new GameManager();
        }
        return GameManager.gameManager;
    }


    public void gameLoop(){
        userInput.input();
        if(player.getSpeedX() == 0 && player.getSpeedY() == 0)  player.render();
        System.out.println("PLAYER " + player.getX() + "  " + player.getY());


    }

    public Player getPlayer(){
        return player;
    }

    public UserInput getUserInput(){
        return userInput;
    }

    public AnimateObject getPlayerAnimation(){
        return playerAnimation;
    }

}
