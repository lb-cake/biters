package shutterstack.biters;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.awt.List;
import java.io.IOException;
import java.util.*;


import static javafx.application.Application.launch;

/**
 * Created by will on 4/8/17.
 */

public class Driver extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Biters");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //FIXME: Add proper fields
        Text sceneTitle = new Text("Enter Your Query");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label artistName1 = new Label("Artist Name 1:");
        TextField artistName1Text = new TextField();
        grid.add(artistName1, 0, 1);
        grid.add(artistName1Text, 1, 1);

        Label songName1 = new Label("Song Name 1:");
        TextField songName1Text = new TextField();
        grid.add(songName1, 0, 2);
        grid.add(songName1Text, 1, 2);

        Label artistName2 = new Label("Artist Name 2:");
        TextField artistName2Text = new TextField();
        grid.add(artistName2, 0, 3);
        grid.add(artistName2Text, 1, 3);

        Label songName2 = new Label("Song Name 2:");
        TextField songName2Text = new TextField();
        grid.add(songName2, 0, 4);
        grid.add(songName2Text, 1, 4);

        Scene scene = new Scene(grid, 400, 275);

        Button button = new Button("Calculate Similarities");
        HBox hbButton = new HBox(10);
        hbButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbButton.getChildren().add(button);
        grid.add(hbButton, 1, 6);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 7);
        //TODO: Call back for button click
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                try {
                    String artist1String = artistName1Text.getText();
                    String song1String   = songName1Text.getText();
                    String artist2String = artistName2Text.getText();
                    String song2String   = songName2Text.getText();
                    java.util.List<String> songList1 = LyricsGatherer.getSongLyrics(artist1String, song1String);
                    java.util.List<String> songList2 = LyricsGatherer.getSongLyrics(artist2String, song2String);
                    actiontarget.setFill(javafx.scene.paint.Paint.valueOf("Green"));
                    double result = StringUtils.getJaroWinklerDistance(songList1.toString(), songList2.toString());
                    result = result * 100;
                    String target = Double.toString(result) + "% Similarity";
                    actiontarget.setText(target);
                }
                catch (IOException error) {
                    error.printStackTrace();
                    System.out.println("Error: Artist/Song may not exist.");
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
