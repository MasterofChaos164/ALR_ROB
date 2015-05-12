package pj.neuralnetwork.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pj.specifiednetwork.Robot;

public class TestRobotUI {
	
	Robot robot;

	@Before
	public void setUp() throws Exception {
		robot = new Robot();
		robot.initializeRobot();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMoveRobot() {
		
		assertEquals (robot.getRobotLocation(), new Point(20, 20));
		
		//fail("Not yet implemented");
	}

	@Test
	public void testRotateRobot() {
		fail("Not yet implemented");
	}

}
