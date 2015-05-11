package pj.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pj.specifiednetwork.Main;

public class RobotUI extends JPanel{
	public Main main;
	public BufferedImage image; // Is the background Image of the frame
	public int[][] imageRGB;
	public int frame_width;
	public int frame_height;
	public JFrame frame;
	
	public Point robotLocation;
	public double robotAngle;
	public Dimension robotSize;
	public Color robotColor;
	
	public Point sensorLocation;
	public Dimension sensorSize;
	public Color sensorColor;
	
	public RobotUI(Main main) {
		this.main = main;
		this.image = main.trainingSets.twoBoxesImage;
		this.imageRGB = main.trainingSets.twoBoxesRGBSet;
		this.frame_width = this.image.getWidth();
		this.frame_height = this.image.getHeight();
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Neural Network");
		frame.setLocationRelativeTo(null);
		frame.setLocation(frame.getX()-frame_width/2,frame.getY()-frame_height/2);
		frame.add(this);
		frame.setVisible(true);
		this.frame_height += frame.getInsets().top+frame.getInsets().bottom;
		frame.setSize(frame_width,frame_height);
				
		this.setBackground(Color.cyan);
		
		initializeRobot();
	}
	
	public void initializeRobot() {
		robotLocation = new Point(20,20);
		robotSize = new Dimension(20,20);
		robotColor = Color.GREEN;
		sensorLocation = new Point(robotLocation.x, robotLocation.y);
		sensorSize = new Dimension(sensorSize.width, sensorSize.height);
		sensorColor = Color.BLUE;
		calculateSensorPosition(); //wuerden wir diese Methode moveSensor() nennen, waere es aus semantischer Sicht nicht so sinnvoll.
	}
	
	public void calculateRobotPosition() {
		//TODO Roboter Position Berechnung anhand des Angles
		//sensorLocation.x = 
		//sensorLocation.y = 
		calculateSensorPosition();
	}
	
	public void calculateSensorPosition() {
		//TODO Sensor Position Berechnung anhand des Angles
		//sensorLocation.x = 
		//sensorLocation.y = 
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBackground(g);
		drawRobot(g);
	}
	
	public void drawBackground(Graphics g) {
		g.drawImage(image,0,0,this);
	}
	
	public void drawRobot(Graphics g) {
		g.setColor(robotColor);
		g.fillRect(robotLocation.x,robotLocation.y,robotSize.width,robotSize.height);
		drawSensor(g);
	}
	
	public void drawSensor(Graphics g) {
		g.setColor(sensorColor);
		g.fillRect(sensorLocation.x,sensorLocation.y,sensorSize.width,sensorSize.height);
		drawSensor(g);
	}
	
	public void moveRobot() {
		calculateRobotPosition(); // Ist vielleicht ein bisschen unnoetig, aber semantisch ganz nett (siehe auch Initialisierung)
	}
	
	public void rotateRobot(int dir, int ms) {
		switch(dir) {
		case 0: // Drehe Rechts
			break;
		case 1: // Drehe Links
			break;
		}
		//TODO: Berechne Angle aufgrund der Drehzeit
	}
}
