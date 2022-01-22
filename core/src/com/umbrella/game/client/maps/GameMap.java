package com.umbrella.game.client.maps;

import com.badlogic.gdx.Gdx;

import java.util.Arrays;

public class GameMap {

    private int[][] map;

    final private int maxWidth;
    final private int maxHeight;

    public GameMap(int maxWidth, int maxHeight) {

        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;

        map = new int[maxHeight][maxWidth];
    }

    public void generateRandom() {

        int topWall = 2;
        int bottomWall = (maxHeight - 3);

        int leftWall = 2;
        int rightWall = maxWidth - 3;

        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < maxHeight; y++) {

                if (y == topWall || y == bottomWall) {

                    map[y][x] = 2;

                } else if (x == leftWall || x == rightWall ) {
                    map[y][x] = 2;

                }  else {
                    map[y][x] = 1;
                }

                if (x > rightWall || x < leftWall || y < topWall || y > bottomWall) {
                    map[y][x] = 0;
                }

            }
        }

        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[0].length; j++) {

                System.out.print(String.format(" %d ", map[i][j]));

            }
            System.out.println("");
        }
    }

    /**
     * The map size needs to be the same than the maximum height and width.
     * These values can be obtained using the getMaxWidth and getMaxHeight.
     * @param map - Data of the map to generate.
     */
    public void setMap(int[][] map) {
        this.map = map;
    }

    public int[][] getMap() {
        return map;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMaxWidth() {
        return maxWidth;
    }
}
