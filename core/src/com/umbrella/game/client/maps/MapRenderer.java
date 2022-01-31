package com.umbrella.game.client.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MapRenderer {

    private GameMap map;
    private TiledMap tiledMap;
    private TiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Texture textures;


    public MapRenderer(GameMap map) {
        this.map = map;

        float aspectRatio = (float) Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        viewport = new FillViewport(map.getMaxWidth() * aspectRatio, map.getMaxHeight(), camera);
        viewport.apply();
        camera.position.set(map.getMaxWidth()/2, map.getMaxHeight() / 2, 0);

        textures = new Texture("maps/tilemap.png");
        TextureRegion[][] splitTiles = TextureRegion.split(textures, 16, 16);

        {
            tiledMap = new TiledMap();
            TiledMapTileLayer layer = new TiledMapTileLayer(map.getMaxWidth(), map.getMaxHeight(), 16, 16);



            for (int x = 0; x < map.getMaxWidth(); x++) {
                for (int y = 0; y < map.getMaxHeight(); y++) {

                    Cell cell = new Cell();

                    if (x == 0 && y == 0){
                        cell.setTile(new StaticTiledMapTile(splitTiles[0][2]));
                    } else if (x == 1 && y == 0){
                        cell.setTile(new StaticTiledMapTile(splitTiles[0][2]));
                    }

                    cell.setTile(new StaticTiledMapTile(splitTiles[2][2]));

                    layer.setCell(x, y, cell);
                }
            }

            tiledMap.getLayers().add(layer);
        }

        renderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    public void render() {
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }

}
