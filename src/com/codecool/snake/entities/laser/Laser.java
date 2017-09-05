package com.codecool.snake.entities.laser;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.awt.geom.Point2D;
import java.util.Random;

public class Laser extends GameEntity implements Animatable {

    private javafx.geometry.Point2D heading;


    public Laser(Pane pane, double dir) {
        super(pane);
        setImage(Globals.simpleEnemy);
        pane.getChildren().add(this);

        int speed = 10;

        setX(SnakeHead.getXc());
        setY(SnakeHead.getYc());

        double direction = dir;
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

        //collide with enemy check
        for (GameEntity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                if (entity instanceof SimpleEnemy) {
                    SimpleEnemy enemy = (SimpleEnemy) entity;
                    enemy.apply(this);
                }
            }
        }
    }

    public void apply(GameEntity enemy) {
        enemy.destroy();
    }

    public String getMessage() {
        return "Hit!";
    }
}

