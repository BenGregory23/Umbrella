package com.umbrella.game.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameObject {

    private SpriteBatch batch;
    private String name;
    private Texture texture;
    protected float x;
    protected float y;
    protected double rotation;

    public GameObject(String name, Texture img){
        this.name = name;
        this.texture = img;

        this.batch = new SpriteBatch();
    }

    public GameObject(String name, String path, float x, float y){
        this.name = name;
        this.texture = new Texture(path);
        this.batch = new SpriteBatch();

        this.x = x;
        this.y = y;
    }

    public void render() {
        batch.begin();
        batch.draw(texture, (int) x, (int) y,
                texture.getWidth(),
                texture.getWidth());
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        texture.dispose();
    }

    public String getName(){
        return name;
    }

    public Texture getTexture(){
        return texture;
    }

    public void setTexture(Texture texture){
        this.texture = texture;
    }

    public float getX(){
        return x;
    }

    public void setX(float x){
        this.x = x;
    }

    public float getY(){
        return y;
    }

    public void setY(float y){
        this.y = y;
    }

    public double getRotation() {
        return rotation;
    }

    public String toString(){
        return name;
    }
}
