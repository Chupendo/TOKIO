package com.tokio.school.javafx.checkbox;

import java.util.Arrays;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CheckBoxDemo2 extends Application {
	CheckBox cbSmartphone, cbTablet, cbNotebook, cbDesktop;
	Label heading, response, selected;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// asigna un titutlo al esceneario
		primaryStage.setTitle("Check Box use");

		// crea un panel como nodo raiz
		int hgap = 10, vgap = 10;
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL, hgap, vgap);

		// centra los controles en el nodo
		rootNode.setAlignment(Pos.CENTER);

		// se crea una escena
		int width = 320, higth = 200;
		Scene myScene = new Scene(rootNode, width, higth);

		// se asinga la escena al escenario
		primaryStage.setScene(myScene);

		// se define una etiqueta con informacion
		heading = new Label("What Computers Do You Own?");
		// se define una etiqueta con el etado de la selección
		response = new Label("");
		// se define una etiqueta que indica los elementos selecionados
		selected = new Label("");

		// se define las casillas de verificación
		cbSmartphone = new CheckBox("Smartphone");
		cbTablet = new CheckBox("Tablet");
		cbNotebook = new CheckBox("Notebook");
		cbDesktop = new CheckBox("Desktop");

		// se habilita el estado intermedio
		cbSmartphone.setAllowIndeterminate(Boolean.TRUE);
		cbTablet.setAllowIndeterminate(Boolean.TRUE);
		cbNotebook.setAllowIndeterminate(Boolean.TRUE);
		cbDesktop.setAllowIndeterminate(Boolean.TRUE);

		// se registrna los eventos de acion
		CheckBoxAction cbSmartphoneEvent = new CheckBoxAction(cbSmartphone);
		CheckBoxAction cbTabletEvent = new CheckBoxAction(cbTablet);
		CheckBoxAction cbNotebookEvent = new CheckBoxAction(cbNotebook);
		CheckBoxAction cbDesktopEvent = new CheckBoxAction(cbDesktop);
		cbSmartphoneEvent.setEvent();
		cbTabletEvent.setEvent();
		cbNotebookEvent.setEvent();
		cbDesktopEvent.setEvent();

		// se crea la escena garifca
		rootNode.getChildren().addAll(heading, cbSmartphone, cbTablet, cbNotebook, cbDesktop, response, selected);

		// Muestra el escenario
		primaryStage.show();

		showAll();
	}

	public static void main(String[] args) {
		// inicia la apalicaicon javafx
		launch(args);
	}

	public void showAll() {
		StringBuilder computers = new StringBuilder("Computer selected: ");
		if (cbSmartphone.isSelected())
			computers.append(getMsg("Smartphone"));
		if (cbTablet.isSelected())
			computers.append(getMsg("Tablet"));
		if (cbNotebook.isSelected())
			computers.append(getMsg("Notebook"));
		if (cbDesktop.isSelected())
			computers.append(getMsg("Desktop"));

		if (!computers.toString().equals("Computer selected: ")) {
			selected.setText(computers.toString());
		} else {
			selected.setText("");
		}

	}

	public String getMsg(String... args) {
		Stream<String> stream = Arrays.stream(args).map(arg -> String.format("%s ", arg));
		return stream.reduce("", (a, b) -> a.concat(b)).toString();

	}

	private class CheckBoxAction implements EventHandler<ActionEvent> {
		private CheckBox cb;

		public CheckBoxAction(CheckBox cb) {
			this.cb = cb;
		}

		public void setEvent() {
			this.cb.setOnAction(this);
		}

		@Override
		public void handle(ActionEvent event) {
			if(this.cb.isIndeterminate()) {
				response.setText(getMsg(cb.getText(), " state is indetemrinate."));
			}else if (this.cb.isSelected()) {
				response.setText(getMsg(cb.getText(), " was just selected."));
			} else {
				response.setText(getMsg(cb.getText(), " was just cleared."));
			}

			showAll();
		}
	}

}
