package com.beverlyshill.samples.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Test for configuration of Commons Logging
 * 
 * @author bhill2
 * 
 */
public class CommonsLoggingTest {

	private static Log log = LogFactory.getLog(CommonsLoggingTest.class);

	/**
	 * Accesses the logging framework to log various levels of log messages
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		log.fatal("This is a fatal error message");
		log.error("This is an error message");
		log.warn("This is a warn message");
		log.info("This is an info messsage");
		log.debug("This is a debug message");
	}
}
