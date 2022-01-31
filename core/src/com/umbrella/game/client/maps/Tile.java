package com.umbrella.game.client.maps;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.umbrella.game.object.GameObject;

public class Tile {

    private boolean collidable;

    private boolean explodable;

    private boolean destroyable;

    public Tile(String name, TextureRegion region, int x, int y, boolean collidable,
                boolean explodable, boolean destroyable) {
        //super(name, region, x, y);

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
