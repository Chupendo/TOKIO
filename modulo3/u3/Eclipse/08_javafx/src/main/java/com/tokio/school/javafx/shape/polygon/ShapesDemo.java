package com.tokio.school.javafx.shape.polygon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShapesDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane gridPane = new GridPane();

		Text text = new Text("Shape Geometrics");
		// Setting font to the text
		text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		// setting the position of the text
		text.setX(0);
		text.setY(0);

		// Creating a Group object

		// gridPane.setAlignment(Pos.CENTER);
		// Agregamos nodos en la FILA 0
		/*
		 * GridPane.setColumnIndex(group, 0); GridPane.setRowIndex(group, 0);
		 * GridPane.setColumnSpan(group, 3);
		 */
		Polygon triangle = new Polygon();
		triangle.getPoints().addAll(getTriangle());
		Polygon triangleRight = new Polygon();
		triangleRight.getPoints().addAll(getTriangleRight());
		Polygon triangleScalene = new Polygon();
		triangleScalene.getPoints().addAll(getTriangleScalene());
		Polygon scquare = new Polygon();
		scquare.getPoints().addAll(getSquare());
		Polygon rectangle = new Polygon();
		rectangle.getPoints().addAll(getRectangle());
		Polygon parallelogram = new Polygon();
		parallelogram.getPoints().addAll(getParallelogram());
		Polygon rhombus = new Polygon();
		rhombus.getPoints().addAll(getRhombus());
		Circle ciclce = getCircle();
		Ellipse ellipse = getElipse();

		Arc openArc = getOpenArc();
		Arc closserc = getCloseArc();
		Arc roundnArc = getRoundArc();
		SVGPath svgPath = getSVGPath();
		SVGPath svgPathCurve = getSVGPathCurve();

		Polygon pentagon = new Polygon();
		pentagon.getPoints().addAll(getPentagon());
		Text textBicolor = getTextFormBiColor();
		ImageView imageView = getImageView(this.getClass().getClassLoader().getResourceAsStream("img/whatsapp.png"));
//getClass().getResource("img/whatsapp.png").getFile()
		GridPane.setConstraints(text, 0, 0, 5, 1);

		GridPane.setConstraints(triangle, 1, 1);
		GridPane.setConstraints(triangleRight, 1, 2);
		GridPane.setConstraints(triangleScalene, 1, 3);
		GridPane.setConstraints(scquare, 1, 4);
		GridPane.setConstraints(rectangle, 1, 5);
		GridPane.setConstraints(parallelogram, 1, 6);
		GridPane.setConstraints(rhombus, 1, 7);
		GridPane.setConstraints(ciclce, 1, 8);
		GridPane.setConstraints(ellipse, 1, 9);

		GridPane.setConstraints(openArc, 2, 1);
		GridPane.setConstraints(closserc, 2, 2);
		GridPane.setConstraints(roundnArc, 2, 3);
		GridPane.setConstraints(svgPath, 2, 4);
		GridPane.setConstraints(svgPathCurve, 2, 5);

		GridPane.setConstraints(pentagon, 3, 1);
		GridPane.setConstraints(textBicolor, 3, 2);
		GridPane.setConstraints(imageView, 3, 3);

		gridPane.setMaxHeight(65);
		gridPane.setMaxWidth(100);
		Group group = new Group(text, triangle, triangleRight, triangleScalene, scquare, rectangle, parallelogram,
				rhombus, ciclce, ellipse, openArc, closserc, roundnArc, svgPath, svgPathCurve, pentagon, textBicolor,
				imageView);

		// agregamos nodos hijos al nodo raiz
		gridPane.getChildren().addAll(group);

		Scene myScene = new Scene(gridPane, 600, 300);
		primaryStage.setScene(myScene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

	// https://www.geogebra.org/classic?lang=es
	public static Double[] getTriangle() {
		return new Double[] { 20d, 60d, 60d, 60d, 40d, 20d };
	}

	public static Double[] getTriangleRight() {
		return new Double[] { 80d, 60d, 100d, 60d, 100d, 20d };
	}

	public static Double[] getTriangleScalene() {
		return new Double[] { 120d, 60d, 150d, 60d, 160d, 20d };
	}

	public static Double[] getSquare() {
		return new Double[] { 180d, 60d, 220d, 60d, 220d, 20d, 180d, 20d };
	}

	public static Double[] getRectangle() {
		return new Double[] { 240d, 60d, 300d, 60d, 300d, 20d, 240d, 20d };
	}

	public static Double[] getParallelogram() {
		return new Double[] { 320d, 60d, 340d, 60d, 360d, 20d, 340d, 20d };
	}

	public static Double[] getRhombus() {
		return new Double[] { 400d, 60d, 420d, 40d, 400d, 20d, 380d, 40d };
	}

	public static Circle getCircle() {

		Circle c = new Circle();
		c.setCenterX(460d);
		c.setCenterY(40d);
		c.setRadius(20d);

		return c;
	}

	public static Ellipse getElipse() {
		Ellipse e = new Ellipse(520, 40d, 540 - 520d, 40d - 30d);
		return e;
	}

	// https://tutoriales.edu.lat/pub/javafx/2dshapes-types-of-arc/javafx-tipos-de-arco-de-formas-2d
	public static Arc getOpenArc() {
		Arc arc = new Arc();
		// Setting the properties of the arc
		arc.setCenterX(40.0f);
		arc.setCenterY(100.0f);
		arc.setRadiusX(60d - 40d);
		arc.setRadiusY(60d - 40d);
		arc.setStartAngle(90d);
		arc.setLength(-90.0f);
		arc.setType(ArcType.OPEN);
		return arc;
	}

	public static Arc getCloseArc() {
		Arc arc = new Arc();
		// Setting the properties of the arc
		arc.setCenterX(80.0f);
		arc.setCenterY(100.0f);
		arc.setRadiusX(100d - 80d);
		arc.setRadiusY(60d - 40d);
		arc.setStartAngle(90d);
		arc.setLength(-90.0f);
		arc.setType(ArcType.CHORD);
		return arc;
	}

	public static Arc getRoundArc() {
		Arc arc = new Arc();
		// Setting the properties of the arc
		arc.setCenterX(140.0f);
		arc.setCenterY(100.0f);
		arc.setRadiusX(160d - 140d);
		arc.setRadiusY(60d - 40d);
		arc.setStartAngle(90d);
		arc.setLength(-90.0f);
		arc.setType(ArcType.ROUND);
		return arc;
	}

	// se debe dibujar una forma en forma de cadena
	public static SVGPath getSVGPath() {
		// https://tutoriales.edu.lat/pub/javafx/2dshapes-svgpath/javafx-svgpath-de-formas-2d
		SVGPath svgpath = new SVGPath();
		// https://www.w3.org/TR/SVG/paths.html
		String path = "M 180 100 L 200 92 L 220 100 z";
		// Setting the SVGPath in the form of string
		svgpath.setContent(path);
		return svgpath;
	}

	public static SVGPath getSVGPathCurve() {
		// https://tutoriales.edu.lat/pub/javafx/2dshapes-svgpath/javafx-svgpath-de-formas-2d
		SVGPath svgpath = new SVGPath();
		// https://www.w3.org/TR/SVG/paths.html, https://yqnn.github.io/svg-path-editor/
		String path = "M 240 100 L 252 86 L 258 84 L 256 90 L 242 102 C 244 104 244 106 246 104 C 246 106 248 108 246 108 A 2.84 2.84 90 0 1 244 110 A 10 10 90 0 0 240 104 Q 239 103.8 239 105 T 236 107.6 T 234.4 106 T 237 103 T 238 102 A 10 10 90 0 0 232 98 A 2.84 2.84 90 0 1 234 96 C 234 94 236 96 238 96 C 236 98 238 98 240 100 M 252 86 L 252 90 L 256 90 L 252.4 89.6 L 252 86 ";
		// Setting the SVGPath in the form of string
		svgpath.setContent(path);
		return svgpath;
	}

	public static Double[] getPentagon() {
		return new Double[] { 30d, 160d, 50d, 160d, 60d, 140d, 40d, 120d, 20d, 140d };
	}

	// https://tutoriales.edu.lat/pub/javafx/javafx-text/javafx-texto
	public static Text getTextFormBiColor() {
		// Creating a Text object
		Text text = new Text();

		// Setting font to the text
		text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

		// setting the position of the text
		text.setX(80);
		text.setY(140);

		// Setting the color
		text.setFill(Color.BROWN);

		// Setting the Stroke
		text.setStrokeWidth(2);

		// Setting the stroke color
		text.setStroke(Color.BLUE);

		// Setting the text to be added.
		text.setText("Hi how are you");
		return text;
	}

	// https://tutoriales.edu.lat/pub/javafx/javafx-images/javafx-imagenes
	public static ImageView getImageView(InputStream is) throws FileNotFoundException {

		// Creating an image
		//File file = new File("classpath:img/whatsapp.png");
		Image image = new Image(is);

		// Setting the image view
		ImageView imageView = new ImageView(image);

		// Setting the position of the image
		imageView.setX(280);
		imageView.setY(120);

		// setting the fit height and width of the image view
		imageView.setFitHeight(50);
		imageView.setFitWidth(40);

		// Setting the preserve ratio of the image view
		imageView.setPreserveRatio(true);

		return imageView;
	}
}
