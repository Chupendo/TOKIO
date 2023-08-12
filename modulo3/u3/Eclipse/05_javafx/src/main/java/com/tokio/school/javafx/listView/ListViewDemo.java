package com.tokio.school.javafx.listView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application {

	Label result;
	Button btnShow;
	ListView<String> lvFruits;

	@Override
	public void init() throws Exception {
		result = new Label("");
		btnShow = new Button("Show");

		ObservableList<String> obsList = FXCollections.observableArrayList("Melon", "Limon", "Straberry", "Tomate",
				"Kiwi", "Banana");
		lvFruits = new ListView<String>(obsList);
		lvFruits.setPrefSize(100, 70);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// asiga un titulo la escenario
		primaryStage.setTitle("ListView Example events ignorate");

		// se crea el nodo raiz
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
		rootNode.setAlignment(Pos.CENTER);

		FlowPane secondNode = new FlowPane(Orientation.HORIZONTAL, 10, 10);
		secondNode.setAlignment(Pos.CENTER);
		
		// se registra el botno a un escuchador de accion
		btnShow.setOnAction((ae)->{
			// Opcion A
			/*
			//si no hay elemebnto selecionado this.lvFruits.getSelectionModel().getSelectedItem() devuelve null
			String elem = this.lvFruits.getSelectionModel().getSelectedItem() != null?this.lvFruits.getSelectionModel().getSelectedItem():"";
			 this.lvFruits.getSelectionModel().selectedItemProperty();
			if(!elem.isEmpty())
				this.result.setText(elem+" was seletected");
			else
				this.result.setText("Selecte a element");
			*/
			
			// Opcion B
			//si no hay elemebnto selecionado this.lvFruits.getSelectionModel().getSelectedItem() devuelve null como string
			String elem = this.lvFruits.getSelectionModel().selectedItemProperty().get();
			System.out.println(this.lvFruits.getSelectionModel().selectedItemProperty().isNull().isValid() );
			if(this.lvFruits.getSelectionModel().selectedItemProperty().isNotNull().isValid())
				this.result.setText(elem+" was seletected");
			else
				this.result.setText("Selecte a element");
			
			
			this.lvFruits.getSelectionModel().getSelectedItems().forEach(f->System.out.println(f));
		});
		
		// se crea la escena grafica
		secondNode.getChildren().addAll(btnShow,result);
		rootNode.getChildren().addAll(lvFruits, secondNode);
		
		// se crea la escena
		Scene myScene = new Scene(rootNode, 500, 200);

		// se asinga una escena y se muestra
		primaryStage.setScene(myScene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
