package com.tokio.school.javafx.textField;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TextFieldDemo extends Application {
	TextField inptTF;
	Button btnGetName;
	Label response;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		inptTF = new TextField();
		inptTF.setPrefColumnCount(10);
		inptTF.setPromptText("Insert a name");

		btnGetName = new Button("Get Name");

		response = new Label("Enter a name");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// titulo del escenario
		primaryStage.setTitle("Demostrate a TextField");

		// nodo raiz
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
		rootNode.setAlignment(Pos.CENTER);

		// escena
		Scene myScene = new Scene(rootNode, 210, 140);
		primaryStage.setScene(myScene);

		// eventos
		inptTF.setOnAction(ae -> {
			if (inptTF.getText() == null || inptTF.getText().isEmpty()) {
				response.setText("Enter a name");
			} else {
				response.setText("Enter press. Name is " + inptTF.getText());
			}
		});
		btnGetName.setOnAction(ae -> {
			if (inptTF.getText() == null || inptTF.getText().isEmpty()) {
				response.setText("Enter a name");
			} else {
				response.setText("Button press. Name is " + inptTF.getText());
			}
		});

		// se crea un separador grafico
		Separator separtor = new Separator();
		separtor.setPrefWidth(180);

		// escena grafica
		rootNode.getChildren().addAll(inptTF, btnGetName, separtor, response);

		// mostrar el escenario y su escena
		primaryStage.show();
	}
}
