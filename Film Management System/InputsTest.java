package projektPC2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputsTest {

    @Test
    void testOnlyNumbersValidInput() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Inputs.onlyNumbers(1, 10);
        assertEquals(5, result, "Input should be 5");
    }

    @Test
    void testOnlyNumbersInvalidInput() {
        String input = "abc\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Inputs.onlyNumbers(1, 5);
        assertEquals(3, result, "Input should be 3");
    }

    @Test
    void testOnlyNameValidInput() {
        String input = "John\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = Inputs.onlyName();
        assertEquals("John", result, "Input should be 'John'");
    }

    @Test
    void testOnlyName_InvalidInput() {
        String input = "John123\nDoe\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = Inputs.onlyName();
        assertEquals("Doe", result, "Input should be 'Doe'");
    }

    @Test
    void testNameAndDigit_ValidInput() {
        String input = "John123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = Inputs.nameAndDigit();
        assertEquals("John123", result, "Input should be 'John123'");
    }

    @Test
    void testNameAndDigit_InvalidInput() {
        String input = "John2....!!\nDoe2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = Inputs.nameAndDigit();
        assertEquals("Doe2", result, "Input should be 'Doe2'");
    }
}
