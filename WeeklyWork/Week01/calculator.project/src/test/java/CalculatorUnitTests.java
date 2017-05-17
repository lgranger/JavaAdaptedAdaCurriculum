import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class CalculatorUnitTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream psOut = new PrintStream(outContent);


    @Before
    public void setUpStreams() {
        System.setOut(psOut);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void calculator_should_welcome_upon_startup() {
        // Given
        Calculator calculator = new Calculator();

        // When
        calculator.main();
        String[] outArray = outContent.toString().split("\n");

        // Then
        assertEquals("Welcome to Calculator!", outArray[0]);
    }
}
