package com.tokio.school.javafx.shape.polygon;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

// https://tutoriales.edu.lat/pub/javafx/javafx-2d-shapes/javafx-formas-2d
public class ShapePathDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Path shapePath = new Path();
		// pont start
		MoveTo moveTo = new MoveTo(232d, 82d);
		// Points
		LineTo l1 = new LineTo(321, 61);
		LineTo l2 = new LineTo(269, 250d);
		LineTo l3 = new LineTo(126,232);
		LineTo l4 = new LineTo(108, 51);
		
		shapePath.getElements().add(moveTo);
		shapePath.getElements().addAll(l1,l2,l3,l4);
		
		Group root = new Group(shapePath);
		
		Scene sc = new Scene(root,600,300);
		
		primaryStage.setScene(sc);
		primaryStage.setTitle("ShapePathDemo example");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
