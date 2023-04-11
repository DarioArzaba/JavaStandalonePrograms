package Various;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class HelloWorldTests {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}
	
	@AfterEach
	public void restoreStreams() {
		System.setOut(System.out);
	}
	
	@Test
	public void mainTest() {
		HelloWorld print = new HelloWorld();
		print.printDefaultMessage();
		assertEquals("Hello, World!", outContent.toString());
	}
	
}