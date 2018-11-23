package be.ac.umons.odl;

import java.awt.*;

public class ConvexPolygon implements Drawable {
	private final Point[] vertices;
	private Point middlePoint;

	public ConvexPolygon(Point[] vertices) {
		this.vertices = vertices;
		this.middlePoint = computeMiddlePoint();
	}

	public Point[] getVertices() {
		return vertices;
	}

	public double computePerimeter() {
		int perimeter = 0;
		int nmbVertices = vertices.length;
		for (int i =0; i < nmbVertices-1;i++){
			perimeter+= vertices[i].distanceTo(vertices[i+1]);
		}
		perimeter += vertices[nmbVertices-1].distanceTo(vertices[0]);
		return perimeter;
	}

	public Point computeMiddlePoint(){
		//calcul du point du milieu
		int middlePointX = 0;
		//calcul de la coordonnée x du point du milieu
		for (int i = 0; i < vertices.length; i++) {
			middlePointX += vertices[i].getX();
		}
		middlePointX /= vertices.length;
		int middlePointY = 0;
		//calcul du la coordonnéee y du point du milieu
		for (int i = 0; i < vertices.length; i++) {
			middlePointY += vertices[i].getY();
		}
		middlePointY /= vertices.length;
		return new Point(middlePointX,middlePointY);
	}

	public double computeArea() {
		double area=0;

		computeMiddlePoint();
		int middlePointX = middlePoint.getX();
		int middlePointY = middlePoint.getY();
		//Calcul de la somme des aires des triangles entre le point du milieu et les sommets
		for (int i = 0; i < vertices.length - 1; i++) {
			area += Math.abs(((vertices[i].getX() - middlePointX) * (vertices[i + 1].getY() - middlePointY) -
				(vertices[i].getY() - middlePointY) * (vertices[i + 1].getX() - middlePointX)) / 2);
		}
		area += Math.abs(((vertices[vertices.length - 1].getX() - middlePointX) * (vertices[0].getY() - middlePointY) -
			(vertices[vertices.length - 1].getY() - middlePointY) * (vertices[0].getX() - middlePointX)) / 2);
		return area;
	}

	@Override
	public void draw(Graphics g) {
		int[] xPoints = new int[vertices.length];
		int[] yPoints = new int[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			Point vertex = vertices[i];
			xPoints[i] = vertex.getX();
			yPoints[i] = vertex.getY();
		}
		g.drawPolygon(xPoints, yPoints, vertices.length);
		//pour afficher le centre:
		/*if (middlePoint != null){
		int[] xMiddlePoint= {middlePoint.getX()-2,middlePoint.getX()-2,middlePoint.getX()+2,middlePoint.getX()+2};
		int[] yMiddlePoint= {middlePoint.getY()-2,middlePoint.getY()+2,middlePoint.getY()-2,middlePoint.getY()+2};
		g.drawPolygon(xMiddlePoint,yMiddlePoint,xMiddlePoint.length);}*/
	}
}
