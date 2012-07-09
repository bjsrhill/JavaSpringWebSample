package info.beverlyshill.samples.test;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Tests that the Spring framwork is configured properly
 * 
 * @author bhill2
 */
public class SpringTest {
	public static void main(String args[]) throws Exception {
		FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext(
				"src/conf/springtest-applicationcontext.xml");
		SpringMessageTest message = (SpringMessageTest) factory
				.getBean("springmessagetest");
	}
}
