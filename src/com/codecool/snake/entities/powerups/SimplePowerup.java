package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.util.Random;

public class SimplePowerup extends GameEntity implements Interactable {

    private static int counter;

    public SimplePowerup(Pane pane) {
        super(pane);
        setImage(Globals.powerupBerry);
        pane.getChildren().add(this);

        Random rnd = new Random();
        setX(rnd.nextDouble() * (Globals.WINDOW_WIDTH-Globals.POWERUP_SIZE));
        setY(rnd.nextDouble() * (Globals.WINDOW_HEIGHT-Globals.POWERUP_SIZE));
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.addPart(2);
        destroy();
        new SimplePowerup(pane);
        counter++;
        if (counter >= 5){
            new SuperPowerup(pane);
            counter = 0;
        }
    }

    @Override
    public String getMessage() {
        return "Got simple power-up :)";
    }
}
