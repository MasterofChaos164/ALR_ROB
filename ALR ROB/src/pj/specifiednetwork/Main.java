package pj.specifiednetwork;
import java.util.Vector;

import pj.generator.TrainingSets;
import pj.neuralnetwork.Network;
import pj.ui.RobotUI;
import pj.ui.TwoBoxesUI;

public class Main {
	public TrainingSets trainingSets;
	public TwoBoxesUI twoBoxesUI;
	public RobotUI robotUI;
	public ExOrNetwork exOrNetwork;
	public TwoBoxesNetwork twoBoxesNetwork;
	public RobotNetwork robotNetwork;
	
	public Main() {
		trainingSets = new TrainingSets();
		
		twoBoxesUI = new TwoBoxesUI(this);
		robotUI = new RobotUI(this);
		
		exOrNetwork = new ExOrNetwork(this);
		twoBoxesNetwork = new TwoBoxesNetwork(this);
		robotNetwork = new RobotNetwork(this);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
//		main.exOrNetwork.trainExOr();
//		main.exOrNetwork.testExOr();
//		main.twoBoxesNetwork.trainTwoBoxes();
//		main.twoBoxesNetwork.testTwoBoxes();
		main.robotNetwork.trainExOr();
	}
}
