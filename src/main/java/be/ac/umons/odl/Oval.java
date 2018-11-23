package be.ac.umons.odl;

import java.awt.*;

public class Oval implements Drawable {
	private final int yAxisLength;
	private final int xAxisLength;
	private final int x;
	private final int y;

	/*public Oval(Point[] coords) {
		this.coords = coords;
	}*/
	public Oval(int x, int y, int xAxisLength, int yAxisLength) {
		this.xAxisLength = xAxisLength;
		this.yAxisLength = yAxisLength;
		this.x =x;
		this.y=y;
	}
	/*public Point[] getCoords() {
		return coords;
	}*/

	@Override
	public void draw(Graphics g){
	int width = xAxisLength;
	int heigth = yAxisLength;
		/*int width = Math.abs(coords[1].getX() - coords[0].getX());
		int heigth = Math.abs(coords[1].getY() - coords[0].getY());
		Point vertex = coords[1];
		int x = vertex.getX();
		int y = vertex.getY();*/
		g.drawOval(x, y, width, heigth);
	}

}
