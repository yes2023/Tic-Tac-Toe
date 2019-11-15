package ticTacToe;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {
    public Text text = new Text();

    public Tile() {
        Rectangle border = new Rectangle(200, 200);
        border.setFill(null);
        border.setStroke(Color.BLACK);

        text.setFont(Font.font(72));

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text);

        setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && Game.playable) {
                if (Game.turnX && text.getText()=="")
                {
                    drawX();
                    Game.turnX = false;
                    Game.checkState();
                    Game.computerChoose();
                    Game.checkState();
                }

            }
        });
    }

    public double getCenterX() {
        return getTranslateX() + 100;
    }

    public double getCenterY() {
        return getTranslateY() + 100;
    }

    public String getValue() {
        return text.getText();
    }

    private void drawX() {
        text.setText("X");
    }

    private void drawO() {
        text.setText("O");
    }
}