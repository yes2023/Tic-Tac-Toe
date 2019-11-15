package ticTacToe;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static boolean playable = true;
    public static boolean turnX = true;
    public static Label computerScore = new Label("Computer Score: 0");
    public static Label userScore = new Label("Your Score: 0");
    public static Label tiesScore = new Label("Ties Score: 0");

    public static Pane root = new Pane();

    private Parent createContent() {
        root.setPrefSize(850, 600);


        //Add score and reset button

        computerScore.setFont(new Font("Arial", 20));
        userScore.setFont(new Font("Arial", 20));
        tiesScore.setFont(new Font("Arial", 20));
        Button resetButton = new Button("Reset");
        resetButton.setFont(new Font("Arial", 20));
        VBox controlPanel = new VBox(5);
        resetButton.setOnMouseClicked(event -> {
            Game.reset();
        });
        controlPanel.setLayoutX(650);
        controlPanel.setLayoutY(100);
        controlPanel.getChildren().add(userScore);
        controlPanel.getChildren().add(computerScore);
        controlPanel.getChildren().add(tiesScore);
        controlPanel.getChildren().add(resetButton);
        controlPanel.setAlignment(Pos.CENTER);
        root.getChildren().add(controlPanel);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                root.getChildren().add(tile);

                Game.board[j][i] = tile;
            }
        }

        // horizontal
        for (int i = 0; i < 3; i++) {
            Game.combos.add(new Combo(Game.board[0][i], Game.board[1][i], Game.board[2][i]));
        }

        // vertical
        for (int x = 0; x < 3; x++) {
            Game.combos.add(new Combo(Game.board[x][0], Game.board[x][1], Game.board[x][2]));
        }

        // diagonals
        Game.combos.add(new Combo(Game.board[0][0], Game.board[1][1], Game.board[2][2]));
        Game.combos.add(new Combo(Game.board[2][0], Game.board[1][1], Game.board[0][2]));

        return root;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setTitle("Tic-Tac-Toe");
        Game.reset();
        primaryStage.show();
    }


    public static void playWinAnimation(Combo combo) {
        combo.tiles[0].setStyle("-fx-background-color: #00FF00;");
        combo.tiles[1].setStyle("-fx-background-color: #00FF00;");
        combo.tiles[2].setStyle("-fx-background-color: #00FF00;");
    }




    public static void main(String[] args) {
        launch(args);
    }
}