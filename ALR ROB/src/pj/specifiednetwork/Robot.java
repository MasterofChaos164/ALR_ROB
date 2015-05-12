package pj.specifiednetwork;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class Robot {
	
	private Point robotLocation;
	private Dimension robotSize;
	private Color robotColor;
	
	private Point sensorLocation;
	private Dimension sensorSize;
	private Color sensorColor;
	
	// Anzahl der Schritte pro Sekunde
	private static final int speed = 5;
	
	public void initializeRobot() {

		robotSize = new Dimension(20,20);
		robotLocation = new Point(20,20);
		robotColor = Color.GREEN;
		
		sensorSize = new Dimension(robotSize.width / 4, robotSize.height / 4);
		sensorLocation = new Point(robotLocation.x + robotSize.width, robotLocation.y + (robotSize.height / 2) - (sensorSize.height / 2));
		sensorColor = Color.BLUE;
	}
	
	// TODO Testen
	public void moveRobot(int ms) {
		double distance = speed * (ms / 1000);
		
		// Verhältnis von Sensormittelpunkt und Robotermittelpunkt (-> Blickrichtung)
		double x = sensorLocation.getX() - robotLocation.getX();
		double y = sensorLocation.getY() - robotLocation.getY();
		
		// Berechnung der Entfernung vom momentanen Standpunkt in x und y Richtung
		double proportion = x / y;
		double yLength = Math.sqrt(Math.pow(distance, 2) / (Math.pow(proportion, 2) + 1));
		double xLength = Math.sqrt(Math.pow(distance, 2) - Math.pow(yLength, 2));
		
		// Setzt Roboter und Sensor auf ihre neue Position
		setRobotLocation(xLength, yLength);
		setSensorLocation(xLength, yLength);
	}
	
	// TODO Testen, eventuell Exception Klasse anpassen
	public void rotateRobot(double angle) throws Exception {
		
		// Macht keinen Sinn sich im Kreis zu drehen
		if (angle < -360 || angle > 360)
			throw new Exception("Angle out of range");
		
		// Rotationsmatrix zur Berechnung der neuen x und y Werte in Abhängingkeit von der Roboterposition
		double xNew = (sensorLocation.getX() - robotLocation.getX()) * Math.cos(angle) + (sensorLocation.getY() - robotLocation.getY()) * Math.sin(angle);
		double yNew = -(sensorLocation.getX() - robotLocation.getX()) * Math.sin(angle) + (sensorLocation.getY() - robotLocation.getY()) * Math.cos(angle);

		sensorLocation.setLocation(robotLocation.getX() + xNew, robotLocation.getY() + yNew);
	}
	
	public void setRobotLocation(double xLength, double yLength) {
		robotLocation.setLocation(robotLocation.getX() + xLength, robotLocation.getY() + yLength);
	}
	
	public Point getRobotLocation(){
		return robotLocation;
	}
	
	public void setSensorLocation(double xLength, double yLength) {
		sensorLocation.setLocation(sensorLocation.getX() + xLength, sensorLocation.getY() + yLength);		
	}
	
	public Point getSensorLocation() {
		return sensorLocation;
	}
	
	public Dimension getRobotSize() {
		return robotSize;
	}
	
	public Color getRobotColor() {
		return robotColor;
	}
	
	public Dimension getSensorSize() {
		return sensorSize;
	}
	
	public Color getSensorColor() {
		return sensorColor;
	}
}
