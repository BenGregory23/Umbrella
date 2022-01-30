package com.umbrella.game.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.umbrella.game.manager.GameManager;
import com.umbrella.game.player.DisplayPlayer;

import java.io.DataInput;

public class UserInput implements InputProcessor {

    public void input(){

        if(Gdx.input.isKeyPressed(Input.Keys.Z)){

            GameManager.getInstance().getPlayer().setSpeedY(5);

        }
        else if(Gdx.input.isKeyPressed(Input.Keys.S)){


            GameManager.getInstance().getPlayer().setSpeedY(-5);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.Q)){



            GameManager.getInstance().getPlayer().setSpeedX(-5);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.D)){
            GameManager.getInstance().getPlayer().setSpeedX(5);
        }

        GameManager.getInstance().getPlayer().setX(GameManager.getInstance().getPlayer().getX() + GameManager.getInstance().getPlayer().getSpeedX());
        GameManager.getInstance().getPlayer().setY(GameManager.getInstance().getPlayer().getY() + GameManager.getInstance().getPlayer().getSpeedY());
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }



    @Override
    public boolean keyUp(int keycode) {

        GameManager.getInstance().getPlayer().setSpeedX(0);
        GameManager.getInstance().getPlayer().setSpeedY(0);

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

}
