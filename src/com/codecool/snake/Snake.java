package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class Snake extends Application{

    @Override
    public void start(Stage primaryStage) {
        Globals.stage = primaryStage;
        Game game = new Game();

        game.getChildren().add(label());

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        primaryStage.show();
        game.start();


    }

    public static void restart(Stage primaryStage) {
        for (GameEntity entitty: Globals.gameObjects){
            entitty.destroy();
        }
        Globals.gameObjects.clear();

        Game game1 = new Game();
        game1.getChildren().add(Globals.healthLabel);
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(game1, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        primaryStage.show();
        game1.start();
    }

    public Label label(){
        Label health = Globals.healthLabel;

        return health;
    }
}
