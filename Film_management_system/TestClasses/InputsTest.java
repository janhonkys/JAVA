package projektPC2.TestClasses;

import org.junit.jupiter.api.Test;
import projektPC2.Inputs;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Tests for Inputs class
class InputsTest {

    @Test
    void testOnlyNumbersValidInput() {
        // Provide valid input to the onlyNumbers method
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the onlyNumbers method and assert the result
        int result = Inputs.onlyNumbers(1, 10);
        assertEquals(5, result, "Input should be 5");
    }

    @Test
    void testOnlyNumbersInvalidInput() {
        // Provide invalid input to the onlyNumbers method
        String input = "abc\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the onlyNumbers method and assert the result
        int result = Inputs.onlyNumbers(1, 5);
        assertEquals(3, result, "Input should be 3");
    }

    @Test
    void testOnlyNameValidInput() {
        // Provide valid input to the onlyName method
        String input = "John\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the onlyName method and assert the result
        String result = Inputs.onlyName();
        assertEquals("John", result, "Input should be 'John'");
    }

    @Test
    void testOnlyNameInvalidInput() {
        // Provide invalid input to the onlyName method
        String input = "John123\nDoe\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the onlyName method and assert the result
        String result = Inputs.onlyName();
        assertEquals("Doe", result, "Input should be 'Doe'");
    }

    @Test
    void testNameAndDigitValidInput() {
        // Provide valid input to the nameAndDigit method
        String input = "John123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the nameAndDigit method and assert the result
        String result = Inputs.nameAndDigit();
        assertEquals("John123", result, "Input should be 'John123'");
    }

    @Test
    void testNameAndDigitInvalidInput() {
        // Provide invalid input to the nameAndDigit method
        String input = "John2....!!\nDoe2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the nameAndDigit method and assert the result
        String result = Inputs.nameAndDigit();
        assertEquals("Doe2", result, "Input should be 'Doe2'");
    }
}
