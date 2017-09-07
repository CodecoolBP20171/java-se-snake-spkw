package com.codecool.snake;

import javafx.geometry.Point2D;

import java.util.Random;

public class Utils {

    /**
     * Converts a direction in degrees (0...360) to x and y coordinates.
     * The length of this vector is the second parameter
     *
     * @param directionInDegrees
     * @param length
     * @return
     */
    public static Point2D directionToVector(double directionInDegrees, double length) {
        double directionInRadians = directionInDegrees / 180 * Math.PI;
        Point2D heading = new Point2D(length * Math.sin(directionInRadians), -length * Math.cos(directionInRadians));
        return heading;
    }

    /**
     * Calculates a new direction based on the original by generating a random
     * degree between 1 and maxDegreeTurn. This new direction is used to turn the
     * original direction to left or right by this amount randomly.
     *
     * @param directionInDegrees direction to be modulated.
     * @param maxDegreeTurn      maximum potential direction change to left or right.
     * @return new modulated direction. If maxDegreeTurn is zero or larger than 359,
     * returns directionInDegrees unchanged.
     */
    public static double randomizeDirection(double directionInDegrees, final int maxDegreeTurn) {
        if (maxDegreeTurn > 0 && maxDegreeTurn < 360) {
            int rndDegreeTurn = new Random().nextInt(maxDegreeTurn * 2 + 1);
            double correctRndDirection = rndDegreeTurn;
            if (rndDegreeTurn < maxDegreeTurn) {
                if ((directionInDegrees - correctRndDirection) < -180) {
                    correctRndDirection = 360 - rndDegreeTurn;
                }
                directionInDegrees -= correctRndDirection;
            }
            else {
                if ((directionInDegrees + correctRndDirection) > 180) {
                    correctRndDirection = (directionInDegrees + correctRndDirection) - 360;
                }
                directionInDegrees += correctRndDirection;
            }
            return directionInDegrees;
        }
        return directionInDegrees;
    }
}
