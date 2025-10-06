package pr2.bootstrap.hello;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    private static PrintStream out;

    @BeforeAll
    static void setup() {
        out = System.out;
    }

    @AfterAll
    static void tearDown() {
        System.setOut(out);
    }

    @Test
    void testHelloWorld() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        System.setOut(ps);

        HelloWorld.main(new String[] {});
        assertEquals("Hallo <Unbekannter>", bos.toString().trim());
        bos.reset();

        HelloWorld.main(new String[] { "Peter Testmann" });
        assertEquals("Hallo Peter Testmann", bos.toString().trim());
        bos.reset();

        bos.close();
        // Don't close ps!
    }
}
