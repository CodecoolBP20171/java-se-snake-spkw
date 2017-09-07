package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.util.Random;

public class SuperPowerup extends GameEntity implements Interactable {

    public SuperPowerup(Pane pane) {
        super(pane);
        setImage(Globals.superPowerup);
        pane.getChildren().add(this);

        Random rnd = new Random();

        setX(rnd.nextDouble() * (Globals.WINDOW_WIDTH-Globals.POWERUP_SIZE));
        setY(rnd.nextDouble() * (Globals.WINDOW_HEIGHT-Globals.POWERUP_SIZE));
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.changeSpeed(0.5);
        snakeHead.addPart(1);
        destroy();
    }

    @Override
    public String getMessage() {
        return "Got super power-up :)";
    }
}
