package com.umbrella.game.object;

import com.badlogic.gdx.graphics.Texture;

public class Player extends GameObject{
    private double life;

    public Player(String name, Texture img) {
        super(name, img);
        life = 100;
    }

    public double getLife(){
        return life;
    }

    public void setLife(double life){
        this.life = life;
    }
}
