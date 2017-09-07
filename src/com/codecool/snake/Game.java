package com.codecool.snake;


import com.codecool.snake.entities.enemies.SamuraiRat;
import com.codecool.snake.entities.enemies.AngryBall;
import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.powerups.BonusHealth;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.powerups.SuperPowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Game extends Pane {

    public Game() {
        new SnakeHead(this, 500, 500);

        //enemy creating
        for (int i = 0; i < 10; i++) {
            new AngryBall(this);
        }

        for (int i = 0; i < 4; i++) {
            new SimpleEnemy(this);
        }

//        new SamuraiRat(this);
//        for (int i = 0; i < 10; i++) {
//            new SimplePowerup(this);
//        }



        //powerup creating
        for (int i = 0; i < 5; i++) {
            new SimplePowerup(this);
        }

    }

    public void start() {
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = true; break;
                case RIGHT: Globals.rightKeyDown  = true; break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = false; break;
                case RIGHT: Globals.rightKeyDown  = false; break;
                case SPACE: Globals.spaceKeyDown = true; break;
                case R: Globals.gameLoop.stop(); Snake.restart(Globals.stage);
                    Globals.pane = null;
            }
        });

        Globals.gameLoop = new GameLoop();
        Globals.gameLoop.start();
    }
}
