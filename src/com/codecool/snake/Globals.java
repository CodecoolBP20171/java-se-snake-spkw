package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.image.Image;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// class for holding all static stuff
public class Globals {

    public static final double WINDOW_WIDTH = 1000;
    public static final double WINDOW_HEIGHT = 700;

    public static Image snakeHead = new Image("snake_head.png");
    public static Image SPKWHead = new Image("SPKWHead.png");
    public static Image snakeBody = new Image("snake_body.png");
    public static Image simpleEnemy = new Image("simple_enemy.png");
    public static Image powerupBerry = new Image("powerup_berry.png");

    public static Image laser = new Image("laser2.png");

    public static Image snakeBodyBlue = new Image("snakeBodyBlue.png");
    public static Image snakeBodyCyan = new Image("snakeBodyCyan.png");
    public static Image snakeBodyDark = new Image("snakeBodyDark.png");
    public static Image snakeBodyGreen = new Image("snakeBodyGreen.png");
    public static Image snakeBodyOrange = new Image("snakeBodyOrange.png");
    public static Image snakeBodyPink = new Image("snakeBodyPink.png");
    public static Image snakeBodyRed = new Image("snakeBodyRed.png");
    public static Image snakeBodyYellow = new Image("snakeBodyYellow.png");
    //.. put here the other images you want to use

    public static boolean leftKeyDown;
    public static boolean rightKeyDown;
    public static boolean spaceKeyDown;
    public static List<GameEntity> gameObjects;
    public static List<GameEntity> newGameObjects; // Holds game objects crated in this frame.
    public static List<GameEntity> oldGameObjects; // Holds game objects that will be destroyed this frame.
    public static GameLoop gameLoop;

    static {
        gameObjects = new LinkedList<>();
        newGameObjects = new LinkedList<>();
        oldGameObjects = new LinkedList<>();
    }

    public static void addGameObject(GameEntity toAdd) {
        newGameObjects.add(toAdd);
    }

    public static void removeGameObject(GameEntity toRemove) {
        oldGameObjects.add(toRemove);
    }

    public static List<GameEntity> getGameObjects() {
        return Collections.unmodifiableList(gameObjects);
    }
}
