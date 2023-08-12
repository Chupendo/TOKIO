package com.tokio.school.javafx.shape.properties;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PropertiesShapeDemo1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle rec = new Rectangle();
		Line line = new Line();
		
		rec.setX(20);
		rec.setY(20);
		rec.setWidth(150);
		rec.setHeight(100);
		
		rec.setFill(Color.RED);
		rec.setStroke(Color.BLACK);
		
		rec.setStrokeWidth(10);
		rec.setStrokeMiterLimit(1);
		
		
		line.setStartX(20);
		line.setStartY(140);
		line.setEndX(180);
		line.setEndY(140);
		line.setFill(Color.BLUE);
		line.setStroke(Color.BROWN);
		line.setStrokeWidth(10);
		line.setStrokeLineCap(StrokeLineCap.BUTT);
		
		Text text = new Text("StrokeLineCap BUTT");
		text.setX(40);
		text.setY(170);
		
		Group root = new Group(rec,line, text);
		Scene myScene = new Scene(root,300,300);
		
		
		primaryStage.setScene(myScene);
		primaryStage.setTitle("Properties Shape");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
