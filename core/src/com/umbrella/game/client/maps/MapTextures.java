package com.umbrella.game.client.maps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MapTextures {

    private Texture texturesTiles;

    private TextureRegion wall;
    private TextureRegion ground;

    public MapTextures() {

        texturesTiles = new Texture("maps/tiles.png");
        TextureRegion[][] splitTiles = TextureRegion.split(texturesTiles, 32, 32);
        TextureRegion region = new TextureRegion();

        wall = splitTiles[0][0];
        ground = splitTiles[0][1];
    }

    public TextureRegion getWall() {
        return wall;
    }

    public TextureRegion getGround() {
        return ground;
    }
}
