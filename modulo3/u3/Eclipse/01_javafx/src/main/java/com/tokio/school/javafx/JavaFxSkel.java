package com.tokio.school.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFxSkel extends Application{

	
	public static void main(String[] args) {
		JavaFxSkel.launch(args);
	}

	@Override
	public void init() throws Exception {
		//
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Agrega un titulo al esceneario
		primaryStage.setTitle("Skeleton JavaFX");
		
		// Crea un nodo raiz
		FlowPane rootNode= new FlowPane();
		
		// Crea una escena
		Scene myScene = new Scene(rootNode,300,200);
		
		// Sete la esecena al escenario
		primaryStage.setScene(myScene);
		
		// muestra el escecenario
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
	
	}

}