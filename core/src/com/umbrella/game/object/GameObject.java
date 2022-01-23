package com.umbrella.game.object;

import com.badlogic.gdx.graphics.Texture;

public class GameObject {
    private String name;
    private Texture texture;
    private double x;
    private double y;

    public GameObject(String name, Texture img){
        this.name = name;
        this.texture = img;
    }

    public String getName(){
        return name;
    }

    public Texture getTexture(){
        return texture;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x){
       this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public String toString(){
        return name;
    }
}
