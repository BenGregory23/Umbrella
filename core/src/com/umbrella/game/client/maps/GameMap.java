package com.umbrella.game.client.maps;

import com.umbrella.game.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class GameMap {

    private Tile[][] tileMap;

    final private int maxWidth;
    final private int maxHeight;

    public GameMap(int maxWidth, int maxHeight) {

        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;

        tileMap = new Tile[maxHeight][maxWidth];
    }

    public void generateRandom() {

        int topWall = 2;
        int bottomWall = (maxHeight - 3);

        int leftWall = 2;
        int rightWall = maxWidth - 3;

        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < maxHeight; y++) {

                if (y == topWall || y == bottomWall) {

                    tileMap[y][x] = new Tile("wall", "maps/wall.png",
                            32*x, 32*y,
                            true, false, false);

                } else if (x == leftWall || x == rightWall ) {

                    tileMap[y][x] = new Tile("wall", "maps/wall.png",
                            32*x, 32*y,
                            true, false, false);

                }  else {
                    tileMap[y][x] = new Tile("ground", "maps/ground.png",
                            32*x, 32*y,
                            false, false, false);
                }

                if (x > rightWall || x < leftWall || y < topWall || y > bottomWall) {
                    tileMap[y][x] = null;
                }

            }
        }

        populateMap();
    }

    private void populateMap() {
        int amount = Utils.randomNumberInRange(1, 20);

        for (int i = 0; i < amount; i++) {
            int x = Utils.randomNumberInRange(4, 36);
            int y = Utils.randomNumberInRange(4, 19);

            tileMap[y][x] = null;
        }

    }

    /**
     * The map size needs to be the same than the maximum height and width.
     * These values can be obtained using the getMaxWidth and getMaxHeight.
     * @param map - Data of the map to generate.
     */
    public void setMap(Tile[][] map) {
        this.tileMap = map;
    }

    public List<Tile> getTiles() {
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < maxWidth; i++) {
            for (int j = 0; j < maxHeight; j++) {
                tiles.add(tileMap[j][i]);
            }
        }
        return tiles;
    }

    public Tile[][] getMap() {
        return tileMap;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMaxWidth() {
        return maxWidth;
    }
}
