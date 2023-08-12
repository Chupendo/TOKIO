package com.tokio.school.javafx.listView;

import javax.xml.ws.Response;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewListenerDemo extends Application {
	ListView<String> lvFruit;
	Label respose;

	@Override
	public void init() throws Exception {
		respose = new Label("");

		ObservableList<String> obsFruit = FXCollections.observableArrayList("Smarphone", "Table", "Notebook",
				"Desktop");
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
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
		rootNode.setAlignment(Pos.CENTER);

		// escenario
		Scene myScene = new Scene(rootNode, 200, 200);

		// registro del controlador al esuchador
		ListViewEvent<String> event = new ListViewEvent<>();
		lvFruit.getSelectionModel().selectedItemProperty().addListener(event);

		rootNode.getChildren().addAll(lvFruit, respose);

		primaryStage.setScene(myScene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	private class ListViewEvent<T> implements ChangeListener<T> {

		@Override
		public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
			String txt = respose.getText();
			System.out.println("valor antiguo: "+oldValue+", valor nuevo: "+newValue);
			
			if (newValue == null && oldValue!=null) {
				txt = txt.replace((String) oldValue, "");
			} else {
				txt += (" "+(String) newValue);
			}
			respose.setText(txt);
			System.out.println("ee: "+respose.getText());
		}
	}
}
