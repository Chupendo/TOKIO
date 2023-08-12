package com.tokio.schoo.javafx.label;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXLabel extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Use Label in JavaFX");
		
		FlowPane rootNode = new FlowPane();
		rootNode.setAlignment(Pos.TOP_CENTER);
		
		Scene myScene = new Scene(rootNode, 230, 200);
		primaryStage.setScene(myScene);
		
		Label myLabel = new Label("Hello Java version"+System.getProperty("java.version"));
		rootNode.getChildren().add(myLabel);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
