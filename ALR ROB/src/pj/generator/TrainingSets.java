package pj.generator;

import java.awt.image.BufferedImage;

public class TrainingSets {
	
	public static final String robotFileName = "robot.png";
	public BufferedImage robotImage;
	public int[][] robotRGBSet;
	
	public static final String twoBoxesFileName = "twoBoxes.png";
	public BufferedImage twoBoxesImage;
	public int[][] twoBoxesRGBSet;
	
	public static final String robotPath = "RoboterLinie.png";
	public BufferedImage robotPathImage;
	public int[][] robotPathRGBSet;
	
	public static final String exOrFileName = "exOr.txt";
	public String exOrSetString;
	public int[][] exOrSet;
	
	public TrainingSets() {
		initialize();
		generate();
	}
	
	public void initialize() {
		ImageAdapter.initializeAdapter();
		TextFileAdapter.initializeAdapter();
	}
	
	public void generate() {
		generateSetTwoBoxes();
		generateSetExOr();
		generateSetRobot();
		generateSetRobotPath();
		
//		System.out.println("\nresult1 in RGB\n");
//		System.out.println("Length: "+twoBoxesRGBSet.length+", Length[0]: "+twoBoxesRGBSet[0].length);
//		Color myColor;
//		for(int i=0;i<twoBoxesRGBSet.length;i++) {
//			for(int j=0;j<twoBoxesRGBSet[0].length;j++) {
//				myColor = new Color(twoBoxesRGBSet[i][j]);
//				System.out.print("("+myColor.getRed()+","+myColor.getGreen()+","+myColor.getBlue()+") ");
//				
//			}
//			System.out.println();
//		}
	}
	
	public void generateSetRobot() {
		twoBoxesImage = ImageAdapter.readImage(twoBoxesFileName);
		twoBoxesRGBSet = ImageAdapter.getPixelsOf(twoBoxesImage);
	}
	
	public void generateSetTwoBoxes() {
		twoBoxesImage = ImageAdapter.readImage(twoBoxesFileName);
		twoBoxesRGBSet = ImageAdapter.getPixelsOf(twoBoxesImage);
		
//		String set = "";
//		int numSets = twoBoxesRGBSet.length*twoBoxesRGBSet[0].length;
//		
//		for(int row=0;row<twoBoxesRGBSet.length;row++) {
//			for(int col=0;col<twoBoxesRGBSet[0].length;col++) {
//				set += row+" "+col+" "+(twoBoxesRGBSet[row][col] == -1? 0 : 1);
//				set += System.lineSeparator();
//			}
//		}
//		TextFileAdapter.writeTextFile(exOrFileName, set);
//		String twoBoxesString = TextFileAdapter.readTextFile(exOrFileName);
//
//		twoBoxesSet = TextFileAdapter.convertToIntArray(exOrSetString,numSets,3);
	}
	
	public void generateSetTwoSpirals() {
		
	}
	
	public void generateSetRobotPath() {
		robotPathImage = ImageAdapter.readImage(robotPath);
		robotPathRGBSet = ImageAdapter.getPixelsOf(robotPathImage);
	}
	
	public void generateSetExOr() {
		String set = "";
		int input1, input2;
		int targetOutput;
		int numSets = 8000;
		
		for(int setNum=0;setNum<numSets;setNum++) {
			input1 = generateRandomValue(0,1);
			input2 = generateRandomValue(0,1);
			targetOutput = (input1==1 && input2==0)||(input1==0 && input2==1)? 1: 0;
			set += input1+" "+input2+" "+targetOutput+" ";
			set += System.lineSeparator();
		}
		
		TextFileAdapter.writeTextFile(exOrFileName, set);
		String exOrSetString = TextFileAdapter.readTextFile(exOrFileName);
		exOrSet = TextFileAdapter.convertToIntArray(exOrSetString,numSets,3);
	}
	
	public int generateRandomValue(int von, int bis) {
		return (int)(Math.random()*(bis-von+1)+von);
	}
}
