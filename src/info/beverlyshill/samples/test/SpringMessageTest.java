package info.beverlyshill.samples.test;

/**
 * Manages the Spring test message
 * 
 * @author bhill2
 */

public class SpringMessageTest {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void printMessage() {
		System.out.println(this.message);
	}
}
