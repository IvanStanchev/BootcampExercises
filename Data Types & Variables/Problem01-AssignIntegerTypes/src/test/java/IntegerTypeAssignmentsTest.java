import org.example.IntegerTypeAssignments;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerTypeAssignmentsTest {

    @Test
    public void testIntegerTypeAssignments() {
        String input = "60\n" +
                "-100\n" +
                "127\n" +
                "128\n" +
                "-144243\n" +
                "255\n" +
                "256\n" +
                "144243\n" +
                "3641\n" +
                "-4512\n" +
                "65535\n" +
                "10000000000000000000\n" +
                "65536\n" +
                "-1000000000000000000\n" +
                "-30000\n" +
                "q\n";

        String expectedOutput = "byte: 60\n" +
                "byte: -100\n" +
                "byte: 127\n" +
                "short: 128\n" +
                "int: -144243\n" +
                "short: 255\n" +
                "short: 256\n" +
                "int: 144243\n" +
                "short: 3641\n" +
                "short: -4512\n" +
                "int: 65535\n" +
                "string: 10000000000000000000\n" +
                "int: 65536\n" +
                "long: -1000000000000000000\n" +
                "short: -30000\n";

        InputStream sysInBackup = System.in;
        PrintStream sysOutBackup = System.out;

        try {
            ByteArrayInputStream inStream = new ByteArrayInputStream(input.getBytes());
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();

            System.setIn(inStream);
            System.setOut(new PrintStream(outStream));

            IntegerTypeAssignments.main(new String[]{});

            String actualOutput = outStream.toString();
            assertEquals(expectedOutput, actualOutput);
        } finally {
            System.setIn(sysInBackup);
            System.setOut(sysOutBackup);
        }
    }
}
