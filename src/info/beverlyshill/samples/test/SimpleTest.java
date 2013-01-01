package info.beverlyshill.samples.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import info.beverlyshill.samples.controller.PagesController;

/**
 * Test of the JUnit framework
 * 
 * @author bhill2
 */
public class SimpleTest extends TestCase {
	int value1 = 2, value2 = 3, expectedResult = 5;

	public static void main(String args[]) {
		junit.textui.TestRunner.run(suite());
	}

	public static Test suite() {
		return new TestSuite(SimpleTest.class);
	}

	/**
	 * This test should return true
	 */
	public void testAddSuccess() {
		assertTrue(value1 + value2 == expectedResult);
	}

	/**
	 * This test should fail as an indication that the testing framework is
	 * functioning properly
	 */
	public void testAddFail() {
		//Remove comment in order to have a failing test
		//assertTrue(value1 - value2 == expectedResult);
	}
}
