package com.umbrella.game.client.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MapRenderer {

    private TiledMap tiledMap;
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer renderer;
    private MapTextures mapTextures;

    public MapRenderer(GameMap map) {

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        this.mapTextures = new MapTextures();

        camera = new OrthographicCamera();
        Viewport viewport = new FitViewport(map.getMaxWidth(), map.getMaxHeight(), camera);
        viewport.apply(true);
        camera.update();

        {
            tiledMap = new TiledMap();
            MapLayers layers = tiledMap.getLayers();

            TiledMapTileLayer layer = new TiledMapTileLayer(map.getMaxWidth(), map.getMaxHeight(), 32, 32);

            for (int x = 0; x < map.getMaxWidth(); x++) {
                for (int y = 0; y < map.getMaxHeight(); y++) {

                    Cell cell = new Cell();

                    switch (map.getMap()[y][x]) {

                        default:
                            cell.setTile(null);
                            break;
                        case 1:
                            cell.setTile(new StaticTiledMapTile(mapTextures.getGround()));
                            break;
                        case 2:
                            cell.setTile(new StaticTiledMapTile(mapTextures.getWall()));
                            break;

                    }

                    layer.setCell(x, y, cell);
                }
            }

            layers.add(layer);

        }

        float unitScale = 1f / Math.max(32, 32);
        renderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale);

    }

    public void render() {
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }

    public void dispose() {
        renderer.dispose();
    }

}
