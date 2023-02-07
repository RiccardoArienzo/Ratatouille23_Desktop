package com.example.ratatouille23;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Accordion accordion = new Accordion();

        TitledPane tp1 = new TitledPane("TitledPane 1", new StackPane());
        TitledPane tp2 = new TitledPane("TitledPane 2", new StackPane());
        TitledPane tp3 = new TitledPane("TitledPane 3", new StackPane());

        tp1.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = tp1.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(tp1.getText());
                db.setContent(content);
                event.consume();
            }
        });

        tp2.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = tp2.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(tp2.getText());
                db.setContent(content);
                event.consume();
            }
        });

        tp3.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = tp3.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(tp3.getText());
                db.setContent(content);
                event.consume();
            }
        });

        accordion.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                String title = db.getString();
                TitledPane droppedTitledPane = null;

                for (TitledPane titledPane : accordion.getPanes()) {
                    if (titledPane.getText().equals(title)) {
                        droppedTitledPane = titledPane;
                        break;
                    }
                }
                accordion.getPanes().remove(droppedTitledPane);
                accordion.getPanes().add(accordion.getPanes().indexOf(event.getTarget()), droppedTitledPane);
                event.setDropCompleted(true);
                event.consume();
            }
        });

        accordion.getPanes().addAll(tp1, tp2, tp3);
        StackPane root = new StackPane();
        root.getChildren().add(accordion);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("JavaFX Drag and Drop Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        /*
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

         */
    }

    public static void main(String[] args) {
        launch();
    }
}