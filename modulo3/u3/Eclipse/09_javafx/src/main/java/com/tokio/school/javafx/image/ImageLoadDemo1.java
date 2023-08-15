package com.tokio.school.javafx.image;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * Cargar imange
 * @author andre
 *
 */
public class ImageLoadDemo1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Image img = new Image(this.getClass().getClassLoader().getResourceAsStream("imgs/whatsapp.png"));
		
		// Setting the image view
		ImageView imageView = new ImageView(img);
		
		// Setting the position of the image
		imageView.setX(50);
		imageView.setY(25);

		// setting the fit height and width of the image view
		imageView.setFitHeight(455);
		imageView.setFitWidth(500);

		// Setting the preserve ratio of the image view
		imageView.setPreserveRatio(true);

		// Creating a Group object
		Group root = new Group(imageView);

		// Creating a scene object
		Scene myScene = new Scene(root, 600, 500);

		primaryStage.setScene(myScene);
		primaryStage.setTitle("Image Load Shample");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
