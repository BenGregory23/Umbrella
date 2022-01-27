package com.umbrella.game.player;

import com.badlogic.gdx.graphics.Texture;
import com.umbrella.game.object.GameObject;

public class Player extends GameObject {
    private double life;
    private double damage;
    private float speedX;
    private float speedY;

    public Player(String name, Texture img, double life, double damage) {
        super(name, img);
        this.life = life;
        this.damage = damage;
    }

    public double getLife(){
        return life;
    }

    public void setLife(double life){
        this.life = life;
    }

    public double getDamage(){return damage;}

    public void setDamage(double damage){
        this.damage = damage;
    }

    public float getSpeedX(){
        return speedX;
    }

    public void setSpeedX(float speedX){
        this.speedX = speedX;
    }

    public float getSpeedY(){
        return speedY;
    }

    public void setSpeedY(float speedY){
        this.speedY = speedY;
    }

    public void setDirectionTexture(String direction){
        setTexture(new Texture(String.format("img/player/dwarf/%s.png",direction)));
    }




}
