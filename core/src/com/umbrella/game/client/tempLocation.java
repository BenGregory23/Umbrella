package com.umbrella.game.client;

public class tempLocation {

    private float x;
    private float y;

    private float rotation;

    public tempLocation(float x, float y) {
        this.x = x;
        this.y = y;

        this.rotation = 0;
    }

    public tempLocation(float x, float y, float rotation) {
        this.x = x;
        this.y = y;

        this.rotation = rotation;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRotation() {
        return rotation;
    }
}
