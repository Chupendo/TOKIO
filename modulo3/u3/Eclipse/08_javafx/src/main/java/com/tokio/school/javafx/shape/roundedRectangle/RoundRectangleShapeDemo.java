package com.tokio.school.javafx.shape.roundedRectangle;

import com.tokio.school.javafx.shape.Shape;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RoundRectangleShapeDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Line Shpae Draw");
		
		Rectangle rectangule = Shape.drawRoundRectangle();
		Group root = new Group(rectangule);
		
		FlowPane rootNode = new FlowPane();
		rootNode.getChildren().add(root);
		rootNode.setMaxSize(Shape.NODE_WIDHT_MAX, Shape.NODE_HEIGHT_MAX);
		rootNode.setMinSize(Shape.NODE_WIDHT_MAX, Shape.NODE_HEIGHT_MAX);
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode,Shape.NODE_WIDHT_MAX, Shape.NODE_HEIGHT_MAX);
		
		
		
		primaryStage.setScene(myScene);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}