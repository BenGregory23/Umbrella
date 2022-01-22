package com.umbrella.game.client.maps;

public class MapRenderer {

    private GameMap map;

    public MapRenderer(GameMap map) {
        this.map = map;
    }

    public void render() {
        map.getTiles().forEach(tile -> {
            if (tile != null) {
                tile.render();
            }
        });
    }

    public void dispose() {
        map.getTiles().forEach(tile -> {
            if (tile != null) {
                tile.dispose();
            }
        });
    }

}
