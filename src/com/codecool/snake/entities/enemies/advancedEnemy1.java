package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.security.SecureRandom;

public class advancedEnemy1 extends GameEntity implements Animatable, Interactable {

    private Point2D heading;
    private static final int damage = 20;
    private double direction;
    int speed;
    SecureRandom rnd;

    public advancedEnemy1(Pane pane) {
        super(pane);
        this.speed = 1;
        this.rnd = new SecureRandom();
        setImage(Globals.simpleEnemy);
        pane.getChildren().add(this);
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
        this.direction = rnd.nextDouble() * 360;
        setRotate(direction);
        this.heading = Utils.directionToVector(direction, speed);

    }

    @Override
    public void step() {
        // Random chance to change direction
        if (rnd.nextInt(100) == 0) {
            direction = Utils.randomizeDirection(direction, 60);
            heading = Utils.directionToVector(direction, speed);
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(SnakeHead player) {
        player.changeHealth(-damage);
        destroy();
    }

    @Override
    public String getMessage() {
        return damage + " damage from " + advancedEnemy1.class.getSimpleName();

    }
}
