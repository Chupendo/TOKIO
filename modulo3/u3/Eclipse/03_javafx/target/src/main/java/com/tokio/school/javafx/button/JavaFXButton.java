package com.tokio.school.javafx.button;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXButton extends Application {

	Label result;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		// Se agrega un titulo al escenarioa
		primaryStage.setTitle("Use BUtton and Event JavaFX");
		
		FlowPane rootNode = new FlowPane(Orientation.HORIZONTAL, 10, 10);
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode, 300,200);
		primaryStage.setScene(myScene);
		
		Button btnUp = new Button("Up");
		Button btnDown = new Button("Donw");
		result = new Label("");
		
		rootNode.getChildren().addAll(btnUp,btnDown,result);
		
		btnUp.setOnAction(new EventHandler() {
			public void handle(Event event) {
				result.setText("Press on Up");
				
			}
		});
		
		btnDown.setOnAction(new EventHandler() {
			public void handle(Event event) {
				result.setText("Press on Donw");
				
			}
		});
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
