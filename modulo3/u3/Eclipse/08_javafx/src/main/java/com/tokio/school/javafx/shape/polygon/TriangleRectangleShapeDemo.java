package com.tokio.school.javafx.shape.polygon;

import com.tokio.school.javafx.shape.Shape;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class TriangleRectangleShapeDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Triangle Shpae Draw and Group");
		
		Polygon polygon1 = Shape.drawTiangleRectagleMultplyX(1);
		Polygon polygon2 = Shape.drawTiangleRectagleInvMultplyX(2);
		Group pol1 = new Group(polygon1);
		Group pol2 = new Group(polygon2);
		Group polFull = new Group(Shape.drawTiangleRectagleMultplyX(3),Shape.drawTiangleRectagleInvMultplyX(3));
		
		VBox rootNode = new VBox();
		rootNode.getChildren().addAll(pol1,pol2,polFull);
		rootNode.setAlignment(Pos.CENTER);
		
		
		Scene myScene = new Scene(rootNode,Shape.NODE_WIDHT_MAX*4, Shape.NODE_HEIGHT_MAX*4);
		
		
		
		primaryStage.setScene(myScene);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}