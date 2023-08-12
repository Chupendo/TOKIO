package com.tokio.school.javafx.shape;


import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
/*
 * Dibuar Geogreba
 * https://www.geogebra.org/classic?lang=es
 */
public class Shape {
	public static double NODE_WIDHT_MAX= 320;
	public static double NODE_HEIGHT_MAX = 200;
	
	public static Line drawLine() {
		Line l = new Line();
		l.setStartX(0.0);
		l.setStartY(NODE_HEIGHT_MAX/2);
		l.setEndX(NODE_WIDHT_MAX);
		l.setEndY(NODE_HEIGHT_MAX/2);
		return l;
	}
	
	public static Rectangle drawRectangle() {
		Rectangle rectangle = new Rectangle();
		rectangle.setX(0);
		rectangle.setY(0);
		rectangle.setWidth(NODE_WIDHT_MAX/2);
		rectangle.setHeight(NODE_HEIGHT_MAX/2);
		return rectangle;
	}
	
	public static Rectangle drawRoundRectangle() {
		Rectangle rectangle = drawRectangle();
		rectangle.setArcHeight(20);
		rectangle.setArcWidth(20);
		return rectangle;
	}
	
	public static Circle drawCircle() {
		Circle circle = new Circle();
		circle.setRadius(NODE_WIDHT_MAX/4);
		circle.setCenterX(NODE_WIDHT_MAX/2);
		return circle;
	}
	
	public static Ellipse drawEllipse() {
		Ellipse ellipse = new Ellipse();
		ellipse.setRadiusX(NODE_WIDHT_MAX/4);
		ellipse.setRadiusY(NODE_HEIGHT_MAX/4);
		ellipse.setCenterX(NODE_WIDHT_MAX/2);
		ellipse.setCenterY(NODE_HEIGHT_MAX/2);
		return ellipse;
	}
	
	public static Polygon drawTiangle() {
		Polygon triangle  = new Polygon();
		triangle.getPoints().addAll(new Double[]{ 
				NODE_WIDHT_MAX/2, NODE_HEIGHT_MAX/4, 
				(NODE_WIDHT_MAX-NODE_WIDHT_MAX/4), (NODE_HEIGHT_MAX-NODE_HEIGHT_MAX/4),
				NODE_WIDHT_MAX/4, (NODE_HEIGHT_MAX-NODE_HEIGHT_MAX/4),
		      });
		
		return triangle;
	}
	
	public static Polygon drawTiangleRectagle() {
		Polygon triangle  = new Polygon();
		triangle.getPoints().addAll(new Double[]{ 
				NODE_WIDHT_MAX/2, NODE_HEIGHT_MAX/4, 
				NODE_WIDHT_MAX/2, (NODE_HEIGHT_MAX-NODE_HEIGHT_MAX/4),
				NODE_WIDHT_MAX/4, (NODE_HEIGHT_MAX-NODE_HEIGHT_MAX/4),
		      });
		
		return triangle;
	}
	
	public static Polygon drawTiangleRectagleInv() {
		Polygon triangle  = new Polygon();
		triangle.getPoints().addAll(new Double[]{ 
				NODE_WIDHT_MAX/2, NODE_HEIGHT_MAX/4, 
				NODE_WIDHT_MAX/4, (NODE_HEIGHT_MAX-NODE_HEIGHT_MAX/4),
				(NODE_WIDHT_MAX-NODE_WIDHT_MAX/4), (NODE_HEIGHT_MAX-NODE_HEIGHT_MAX/4),
		      });
		
		return triangle;
	}
	
	public static Polygon drawTiangleRectagleMultplyX(int x) {
		Polygon triangle  = new Polygon();
		triangle.getPoints().addAll((new Double[]{ 
				x*NODE_WIDHT_MAX/2, x*NODE_HEIGHT_MAX/4, 
				x*NODE_WIDHT_MAX/2, x*(NODE_HEIGHT_MAX-NODE_HEIGHT_MAX/4),
				x*NODE_WIDHT_MAX/4, x*(NODE_HEIGHT_MAX-NODE_HEIGHT_MAX/4),
		      }));
		
		return triangle;
	}
	
	public static Polygon drawTiangleRectagleInvMultplyX(int x)  {
		Polygon triangle  = new Polygon();
		triangle.getPoints().addAll(new Double[]{ 
				x*NODE_WIDHT_MAX/2, x*NODE_HEIGHT_MAX/4, 
				x*NODE_WIDHT_MAX/2, x*(NODE_HEIGHT_MAX-NODE_HEIGHT_MAX/4),
				x*(NODE_WIDHT_MAX-NODE_WIDHT_MAX/4),x*(NODE_HEIGHT_MAX-NODE_HEIGHT_MAX/4),
		      });
		
		return triangle;
	}
	
	public static Polygon drawRectanglePolygo()  {
		Polygon triangle  = new Polygon();
		triangle.getPoints().addAll(new Double[]{ 
				60d,160d,
				240d,160d,
				240d,60d,
				60d,60d
		      });
		
		return triangle;
	}
	
}
