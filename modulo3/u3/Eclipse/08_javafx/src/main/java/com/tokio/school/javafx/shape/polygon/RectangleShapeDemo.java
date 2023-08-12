package com.tokio.school.javafx.shape.polygon;

import com.tokio.school.javafx.shape.Shape;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class RectangleShapeDemo  extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Triangle Shpae Draw and Group");
		
		Polygon polygon = Shape.drawRectanglePolygo();
		Group pol1 = new Group(polygon);

	
		VBox rootNode = new VBox();
		rootNode.getChildren().add(pol1);
		rootNode.setAlignment(Pos.CENTER);
		
		
		Scene myScene = new Scene(rootNode,Shape.NODE_WIDHT_MAX, Shape.NODE_HEIGHT_MAX);
		
		primaryStage.setScene(myScene);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}