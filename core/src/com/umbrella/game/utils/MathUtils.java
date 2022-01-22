package com.umbrella.game.utils;

import com.badlogic.gdx.math.Vector2;
import com.umbrella.game.client.tempLocation;
import static java.lang.Math.*;

public class MathUtils {

    public static Vector2 rotateFunction(Vector2 vector, tempLocation loc) {
        float rotation = (float) (loc.getRotation() / 180.0 * Math.PI);

        return rotate(vector, rotation);
    }

    public static Vector2 rotate(Vector2 vector, float angle) {
        float x = (float) (vector.x * cos(angle) - vector.y * sin(angle));
        float y = (float) (vector.y * cos(angle) + vector.x * sin(angle));

        return vector.set(x, y);
    }

}
