package com.tokio.school.javafx.image;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Multples Imagners
 * @author andre
 *
 */
public class ImageLoadDemo2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("imgs/whatsapp.png"));

		// Setting the image view 1
		ImageView imageView1 = new ImageView(image);

		// Setting the position of the image
		imageView1.setX(50);
		imageView1.setY(25);

		// setting the fit height and width of the image view
		imageView1.setFitHeight(300);
		imageView1.setFitWidth(250);

		// Setting the preserve ratio of the image view
		imageView1.setPreserveRatio(true);

		// Setting the image view 2
		ImageView imageView2 = new ImageView(image);

		// Setting the position of the image
		imageView2.setX(350);
		imageView2.setY(25);

		// setting the fit height and width of the image view
		imageView2.setFitHeight(150);
		imageView2.setFitWidth(250);

		// Setting the preserve ratio of the image view
		imageView2.setPreserveRatio(true);

		// Setting the image view 3
		ImageView imageView3 = new ImageView(image);

		// Setting the position of the image
		imageView3.setX(350);
		imageView3.setY(200);

		// setting the fit height and width of the image view
		imageView3.setFitHeight(100);
		imageView3.setFitWidth(100);

		// Setting the preserve ratio of the image view
		imageView3.setPreserveRatio(true);

		// Creating a Group object
		Group root = new Group(imageView1, imageView2, imageView3);

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
