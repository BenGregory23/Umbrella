package com.umbrella.game.client.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameMap {

    private TiledMap tiledMap;
    private TiledMapRenderer renderer;
    private OrthographicCamera camera;
    private MapTextures mapTextures;

    public GameMap(int[][] map) {

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        this.mapTextures = new MapTextures();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, (width / height) * 320, 320);
        camera.update();

        {

            tiledMap = new TiledMap();
            MapLayers layers = tiledMap.getLayers();
            for (int i = 0; i < 1; i++) {

                int tileWidth = (int)(width / 32);
                int tileHeight = (int)(height / 32);

                TiledMapTileLayer layer = new TiledMapTileLayer(tileWidth, tileHeight, 32, 32);

                for (int x = 0; x < tileWidth; x++) {
                    for (int y = 0; y < tileHeight; y++) {
                        Cell cell = new Cell();

                        if (y == 5) {
                            cell.setTile(new StaticTiledMapTile(mapTextures.getWall()));
                        } else {
                            cell.setTile(new StaticTiledMapTile(mapTextures.getGround()));
                        }

                        layer.setCell(x, y, cell);
                    }
                }

                layers.add(layer);
            }

        }

        renderer = new OrthogonalTiledMapRenderer(tiledMap);

    }

    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }

}
