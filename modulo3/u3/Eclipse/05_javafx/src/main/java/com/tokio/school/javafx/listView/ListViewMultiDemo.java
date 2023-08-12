package com.tokio.school.javafx.listView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewMultiDemo extends Application {

	ListView<String> lvFruit;
	Button btnShow;
	Label respose;
	
	@Override
	public void init() throws Exception {
		btnShow = new Button("Show");
		respose = new Label("");
		
		ObservableList<String> obsFruit = FXCollections.observableArrayList("Smarphone","Table","Notebook","Desktop");
		lvFruit = new ListView(obsFruit);
		lvFruit.setMaxWidth(100);
		lvFruit.setPrefSize(100, 70);
		lvFruit.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// se agrega titulo
		primaryStage.setTitle("ListView Multiple Selection use");
		
		// nodo raiz
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL,10,10);
		rootNode.setAlignment(Pos.CENTER);
		
		// nodo second
		FlowPane secondNode = new FlowPane(Orientation.HORIZONTAL,10,10);
		secondNode.setAlignment(Pos.CENTER);
		secondNode.setPrefSize(200, 70);
		
		// escenario
		Scene myScene = new Scene(rootNode, 200, 200);
		
		// registro del controlador al esuchador
		ButtonEvent event = new ButtonEvent();
		btnShow.setOnAction(ae->event.handle(ae));
		
		secondNode.getChildren().addAll(btnShow,respose);
		rootNode.getChildren().addAll(lvFruit,secondNode);
		
		
		primaryStage.setScene(myScene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private class ButtonEvent implements EventHandler<ActionEvent>{
				
		@Override
		public void handle(ActionEvent event) {
			MultipleSelectionModel model = lvFruit.getSelectionModel();
			
			if(!model.getSelectedItems().isEmpty()) {
				String text = (String) model.getSelectedItems().stream().reduce("", (t, u) ->  t+" "+u);
				respose.setText(text);

			}else {
				respose.setText("");
			}
		}
	
	}

}
