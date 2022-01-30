package com.umbrella.game.manager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.umbrella.game.client.UserInput;
import com.umbrella.game.player.AnimatePlayer;
import com.umbrella.game.player.DisplayPlayer;
import com.umbrella.game.player.Player;

public class GameManager {
    private static GameManager gameManager;
    private Player player;
    private UserInput userInput;
    private SpriteBatch batch = new SpriteBatch();
    private AnimatePlayer playerAnimation;
    private DisplayPlayer showIdle;
    private DisplayPlayer showMovingLeft;
    private DisplayPlayer showMovingRight;
    private DisplayPlayer showMovingDown;
    private DisplayPlayer showMovingUp;

    private GameManager(){
        player = new Player("player", new Texture("img/player/small-guy/no_weapon/idle/idle-down1.png"), 100, 20);
        userInput = new UserInput();

    }

    public static GameManager getInstance(){
        if(GameManager.gameManager == null){
            GameManager.gameManager = new GameManager();
        }
        return GameManager.gameManager;
    }

    public void prepare(){
        showIdle = new DisplayPlayer(new Texture("img/player/small-guy/no_weapon/idle/idle-cycle-down.png"), 90, 90, 4);
        showIdle.splitTexture();

        showMovingLeft = new DisplayPlayer(new Texture("img/player/small-guy/no_weapon/walk/cycle-left.png"), 90, 90, 4);
        showMovingLeft.splitTexture();

        showMovingRight = new DisplayPlayer(new Texture("img/player/small-guy/no_weapon/walk/cycle-right.png"), 90, 90, 4);
        showMovingRight.splitTexture();

        showMovingDown = new DisplayPlayer(new Texture("img/player/small-guy/no_weapon/walk/cycle-down.png"), 90, 90, 4);
        showMovingDown.splitTexture();

        showMovingUp = new DisplayPlayer(new Texture("img/player/small-guy/no_weapon/walk/cycle-up.png"), 90, 90, 4);
        showMovingUp.splitTexture();
    }

    public void gameLoop(){
        userInput.input();
        displayPlayer();
    }


    public Player getPlayer(){
        return player;
    }

    public void displayPlayer(){
        if(player.getSpeedX() == 0 && player.getSpeedY() == 0) {
            showIdle.animate();
        }
        else if(player.getSpeedX() < 0) showMovingLeft.animate();
        else if(player.getSpeedX() > 0) showMovingRight.animate();
        else if(player.getSpeedY() < 0) showMovingDown.animate();
        else if(player.getSpeedY() > 0) showMovingUp.animate();

    }

    public UserInput getUserInput(){
        return userInput;
    }

    public AnimatePlayer getPlayerAnimation(){
        return playerAnimation;
    }

}
