package com.umbrella.game.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameObject {

    private String name;
    private Texture texture;
    protected double x;
    protected double y;
    protected double rotation;

    public GameObject(String name, Texture img){
        this.name = name;
        this.texture = img;
    }

    public GameObject(String name, String path, double x, double y){
        this.name = name;
        this.texture = new Texture(path);

        this.x = x;
        this.y = y;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, (int) x, (int) y,
                texture.getWidth(),
                texture.getHeight());
    }

    public void render(SpriteBatch batch, int width, int height) {
        batch.draw(texture, (int) x, (int) y,
                width,
                height);
    }

    public void dispose() {
        if (texture != null) {
            texture.dispose();
        }
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

    public double getRotation() {
        return rotation;
    }

    public String toString(){
        return name;
    }
}
