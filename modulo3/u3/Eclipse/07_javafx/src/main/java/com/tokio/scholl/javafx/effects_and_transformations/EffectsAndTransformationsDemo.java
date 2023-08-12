package com.tokio.scholl.javafx.effects_and_transformations;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class EffectsAndTransformationsDemo extends Application {

	public double angle = 0.0;
	public double scaleFactor = 0.4;
	public double blurVal = 1.0;
	
	public Label lbReflect;
	public Button btnRotate, btnScale, btnBlur;
	
	@Override
	public void init() throws Exception {
		btnRotate = new Button("Rotate");
		btnScale = new Button("Scale");
		btnBlur = new Button("Blur");
		lbReflect = new Label("Reflection Adds Visual Sparkle.");
		lbReflect.setEffect(getReflection());
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// titulo del escenario
		primaryStage.setTitle("Effects and Transformation in JavaFx");
		
		// nodo raiz y nodos
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL,10,10);
		rootNode.setAlignment(Pos.CENTER);
		FlowPane btnNode = new FlowPane(Orientation.HORIZONTAL,10,30);
		btnNode.setAlignment(Pos.CENTER);
		FlowPane lbNode = new FlowPane(Orientation.HORIZONTAL,10,30);
		lbNode.setAlignment(Pos.CENTER);
		
		// Eventos
		btnRotate.setOnAction(ae->rotateBtn());
		btnScale.setOnAction(ae->scaleBtn());
		btnBlur.setOnAction(ae->blurBtnOnOff());
		// Escenas Graficas
		btnNode.getChildren().addAll(btnRotate,btnScale,btnBlur);
		lbNode.getChildren().addAll(lbReflect);
		rootNode.getChildren().addAll(btnNode,lbNode);
		Scene myScene = new Scene(rootNode, 340, 200);
		
		// Escenario y Escena
		primaryStage.setScene(myScene);
		primaryStage.show();
	}
	
	public Reflection getReflection() {
		Reflection reflection = new Reflection();
		reflection.setTopOffset(.2);
		reflection.setFraction(0.5);
		reflection.setTopOpacity(0.75);
		reflection.setBottomOpacity(0.15);
		return reflection;
	}
	
	
	public void rotateBtn() {
		Rotate rotate = new Rotate();
		angle = (angle + 15.0) % 45;
		rotate.setAngle(angle);
		rotate.setPivotX(btnRotate.getWidth()/2);
		rotate.setPivotY(btnRotate.getHeight()/2);
		
		btnRotate.getTransforms().add(rotate);
	}
	
	public void scaleBtn() {
		Scale scale = new Scale();
		
		scaleFactor += 0.1;
		if(scaleFactor > 2.0 ) scaleFactor = 0.4;
		
		scale.setPivotX(scaleFactor);
		scale.setPivotY(scaleFactor);
		
		btnScale.getTransforms().add(scale);
	}

	public void blurBtnOnOff() {
		BoxBlur blur = new BoxBlur(1.0,1.0,1);
		if(blurVal == 10.0) {
			blurVal = 1.0;
			btnBlur.setEffect(null);;
			btnBlur.setText("Blur off");
		}else{
			blurVal++;
			btnBlur.setEffect(blur);
			btnBlur.setText("Blur on");
		}
		
		blur.setWidth(blurVal);
		blur.setHeight(blurVal);
	}

}

