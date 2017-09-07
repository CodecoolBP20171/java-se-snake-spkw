package com.codecool.snake.entities;

import com.codecool.snake.Globals;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

// The base class for every game entity.
public abstract class GameEntity extends ImageView {

    protected Pane pane;

    protected GameEntity(Pane pane) {
        Globals.pane = pane;

        this.pane = pane;
        // add to the main loop.
        Globals.addGameObject(this);
    }

    public void destroy() {
        if (getParent() != null) {
            pane.getChildren().remove(this);
        }
        Globals.removeGameObject(this);
    }

    protected boolean isOutOfBounds() {
        if (getX() > Globals.WINDOW_WIDTH || getX() < 0 ||
                getY() > Globals.WINDOW_HEIGHT || getY() < 0) {
            return true;
        }
        return false;
    }

    protected boolean isOutOfBounds(int leftMargin, int rightMargin, int topMargin, int bottomMargin) {
        if (getX() > Globals.WINDOW_WIDTH - rightMargin || getX() < leftMargin ||
                getY() > Globals.WINDOW_HEIGHT - bottomMargin || getY() < topMargin) {
            return true;
        }
        return false;
    }
}
