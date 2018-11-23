package be.ac.umons.odl;

import java.awt.*;

public class Ellipsis implements Drawable{
	private Point center;
	private double xAxisLength;
	private double yAxisLength;

	public Ellipsis(Point center, double xAxisLength, double yAxisLength){
		this.center = center;
		this.xAxisLength = xAxisLength;
		this.yAxisLength = yAxisLength;
	}

	public double computePerimeter()
	{
		return (2*Math.PI*Math.sqrt(0.5*((xAxisLength)*(xAxisLength)+(yAxisLength)*yAxisLength)));
	}
	public double computeArea(){
		return(Math.PI*xAxisLength*yAxisLength/4);
	}

	public Point getCenter(){return center;}

	@Override
	public void draw(Graphics g){
		g.drawOval(center.getX()-(int)xAxisLength/2,center.getY()-(int)yAxisLength/2,(int)xAxisLength,(int)yAxisLength);
	}


}
