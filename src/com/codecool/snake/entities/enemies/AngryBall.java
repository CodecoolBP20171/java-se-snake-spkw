package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.laser.Laser;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.security.SecureRandom;

public class AngryBall extends GameEntity implements Animatable, Interactable {

    private static final int damage = 20;
    private final int SIZE = 30;
    private final int spawnRadius = SIZE*2;
    int speed;
    SecureRandom rnd;
    private Point2D heading;
    private double direction;

    public AngryBall(Pane pane) {
        super(pane);
        this.speed = 1;
        this.rnd = new SecureRandom();

        setImage(Globals.angryBall);
        pane.getChildren().add(this);

        double actualX = rnd.nextDouble() * (Globals.WINDOW_WIDTH - SIZE);
        double actualY = rnd.nextDouble() * (Globals.WINDOW_HEIGHT - SIZE);
        double snakeHeadX = SnakeHead.getXc();
        double snakeHeadY = SnakeHead.getYc();

        while (snakeHeadX - spawnRadius < actualX && actualX < snakeHeadX + spawnRadius &&
                snakeHeadY - spawnRadius < actualY && actualY < snakeHeadY + spawnRadius){
            actualX = rnd.nextDouble() * (Globals.WINDOW_WIDTH - SIZE);
            actualY = rnd.nextDouble() * (Globals.WINDOW_HEIGHT - SIZE);
        }

        setX(actualX);
        setY(actualY);
        this.direction = rnd.nextDouble() * 360;

        setRotate(direction);
        this.heading = Utils.directionToVector(direction, speed);

    }

    @Override
    public void step() {

        // Check for collision with margin
        if (isOutOfBounds(0, SIZE, 0, SIZE)) {
            direction += 180;
            heading = Utils.directionToVector(direction, speed);
        }

        // Random chance to change direction
        else if (rnd.nextInt(100) == 0) {
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

    public void die(){
        destroy();
    }

    @Override
    public String getMessage() {
        return damage + " damage from " + AngryBall.class.getSimpleName();
    }
}
