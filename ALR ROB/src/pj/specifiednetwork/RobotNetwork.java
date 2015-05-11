package pj.specifiednetwork;

import java.awt.Point;
import java.util.Vector;

import pj.neuralnetwork.Network;
import pj.ui.RobotUI;

public class RobotNetwork {
	public Main main;
	public Network net;
	public RobotUI robotUI;
	
	public RobotNetwork(Main main) {
		this.main = main;
		robotUI = new RobotUI(main);
	}
	
	public void trainRobot() {
		Point robotLocation = new Point();
		Vector<Integer> topology = new Vector<Integer>();
		topology.add(2);
		topology.add(3);
		topology.add(1);
		double bias = 1.0;
		
		net = new Network(topology, bias);
		while(true) {
			//TODO: Merke Zeit

			robotUI.moveRobot();
			//if(Roboter is ausserhalb vom Pfad)
				robotLocation.x = main.robotNetwork.robotUI.robotLocation.x;
				robotLocation.y = main.robotNetwork.robotUI.robotLocation.y;
				Vector<Double> inputVals = new Vector<Double>();
				
				inputVals.add((double)robotLocation.x);
				inputVals.add((double)robotLocation.y);
				net.feedForward(inputVals);
				
				Vector<Double> targetVals = new Vector<Double>();
				targetVals.add(1.0); // 1.0 ist Schwarz und 0 ist Weiss
				net.backProp(targetVals);
		
				Vector<Double> resultVals = new Vector<Double>();
				net.getResults(resultVals);
				
				System.out.println("Result: "+String.format("%.2f", resultVals.get(0))+" target: "+targetVals.get(0));
				net.showRecentAverageError("%.2f");
				System.out.println();
				//TODO rotateRobot() aufrufen
			//}
				
			robotUI.repaint();
		}
	}
}
