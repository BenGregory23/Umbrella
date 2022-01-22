package com.umbrella.game.client.maps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.umbrella.game.object.GameObject;

public class Tile extends GameObject {

    private SpriteBatch batch;

    private boolean collidable;

    private boolean explodable;

    private boolean destroyable;

    public Tile(String name, String path, int x, int y, boolean collidable,
                boolean explodable, boolean destroyable) {
        super(name, path, x, y);

        this.batch = new SpriteBatch();
        this.collidable = collidable;
        this.explodable = explodable;
        this.destroyable = destroyable;
    }

    public boolean isCollidable() {
        return collidable;
    }

    public void setCollidable(boolean collidable) {
        this.collidable = collidable;
    }

    public boolean isExplodable() {
        return explodable;
    }

    public void setExplodable(boolean explodable) {
        this.explodable = explodable;
    }

    public boolean isDestroyable() {
        return destroyable;
    }

    public void setDestroyable(boolean destroyable) {
        this.destroyable = destroyable;
    }
}
