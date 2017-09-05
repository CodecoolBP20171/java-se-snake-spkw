package com.codecool.snake.entities.laser;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.awt.geom.Point2D;
import java.util.Random;

public class Laser extends GameEntity implements Animatable, Interactable {

    private Point2D heading;


    Laser(Pane pane) {
        super(pane);
        setImage(Globals.simpleEnemy);
        pane.getChildren().add(this);

        int speed = 1;

        setX();
        setY();

        double direction = rnd.nextDouble() * 360;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            destroy();
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(SnakeHead player) {

    }

    @Override
    public String getMessage() {
        return "10 damage";
    }
}

