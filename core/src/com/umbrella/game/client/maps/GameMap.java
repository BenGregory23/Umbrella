package com.umbrella.game.client.maps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.umbrella.game.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class GameMap {

    private Tile[][] tileMap;
    private TextureRegion[][] region;

    final private int maxWidth;
    final private int maxHeight;

    public GameMap(int maxWidth, int maxHeight) {

        region = TextureRegion.split(new Texture("maps/tilemap.png"), 16, 16);

        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;

        tileMap = new Tile[maxHeight][maxWidth];
    }

    public void generateRandom() {

        int bottomWall = 2;
        int topWall = (maxHeight - 3);

        int leftWall = 2;
        int rightWall = maxWidth - 3;

        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < maxHeight; y++) {

                if (y == topWall && x == leftWall) {
                    tileMap[y][x] = new Tile("wall", region[0][2],
                            16*x, 16*y,
                            true, false, false);
                } else if (y == topWall && x == rightWall) {
                    tileMap[y][x] = new Tile("wall", region[0][4],
                            16*x, 16*y,
                            true, false, false);
                } else if (y == topWall) {
                    tileMap[y][x] = new Tile("wall", region[0][3],
                            16 * x, 16 * y,
                            true, false, false);
                } else if (y == (topWall-1) && (x != leftWall && x != rightWall)) {
                    tileMap[y][x] = new Tile("wall", region[1][3],
                            16 * x, 16 * y,
                            true, false, false);
                } else if (y == bottomWall && x == rightWall) {
                    tileMap[y][x] = new Tile("wall", region[1][4],
                            16*x, 16*y,
                            true, false, false);
                } else if (y == bottomWall && x == leftWall) {
                    tileMap[y][x] = new Tile("wall", region[2][2],
                            16*x, 16*y,
                            true, false, false);
                } else if (y == bottomWall) {
                    tileMap[y][x] = new Tile("wall", region[0][3],
                            16*x, 16*y,
                            true, false, false);
                } else if (x == rightWall) {
                    tileMap[y][x] = new Tile("wall", region[1][2],
                            16*x, 16*y,
                            true, false, false);
                } else if (x == leftWall) {
                    tileMap[y][x] = new Tile("wall", region[1][2],
                            16*x, 16*y,
                            true, false, false);
                } else {
                    tileMap[y][x] = new Tile("ground", region[9][0],
                            16*x, 16*y,
                            true, false, false);
                }

                if (x < leftWall || x > rightWall || y > topWall || y < bottomWall) {
                    tileMap[y][x] = null;
                }

            }
        }

        populateMap();
    }

    private void populateMap() {
        int amount = Utils.randomNumberInRange(5, 30);

        for (int i = 0; i < amount; i++) {
            int x = Utils.randomNumberInRange(4, 36);
            int y = Utils.randomNumberInRange(5, 18);

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
