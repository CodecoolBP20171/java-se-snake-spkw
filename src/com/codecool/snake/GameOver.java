package com.codecool.snake;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import javax.swing.plaf.ButtonUI;


public class GameOver {

    public static void gameOver(String bodyParts) {
        Stage gameOverWindow = new Stage();
        gameOverWindow.initModality(Modality.APPLICATION_MODAL);
        gameOverWindow.setTitle("Game Over");
        gameOverWindow.setMinWidth(250);


        Label label = new Label();
        label.setMinWidth(250);
        label.setMinHeight(100);

        label.setText("The Game is over" + "\n" + "\n" + "Body size " + bodyParts);
        Button restart = new Button("Restart Game");
        Button cloesetheWindow = new Button("Close the Game");

        restart.setOnAction(event -> {Snake.restart(Globals.stage); gameOverWindow.close();});
        cloesetheWindow.setOnAction(event -> {
            Globals.stage.close();
            gameOverWindow.close();
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(label, cloesetheWindow, restart);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        gameOverWindow.setScene(scene);
        gameOverWindow.show();
    }
}
