package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.util.Random;

public class BonusHealth extends GameEntity implements Interactable {

    public BonusHealth(Pane pane) {
        super(pane);
        setImage(Globals.healthPowerup);
        pane.getChildren().add(this);

        Random rnd = new Random();
        setX(rnd.nextDouble() * (Globals.WINDOW_WIDTH-Globals.POWERUP_SIZE));
        setY(rnd.nextDouble() * (Globals.WINDOW_HEIGHT-Globals.POWERUP_SIZE));
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.addPart(1);
        snakeHead.changeHealth(10);
        destroy();
    }

    @Override
    public String getMessage() {
        return "Got simple power-up :)";
    }
}
