package org.bulatnig.smily;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SmilyEncoderTest {

    private final SmilyEncoder encoder = new SmilyEncoder();

    @Test
    public void encodeString() {
        String result = encoder.encode("Hello world!");

        assertEquals(result, ";)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):))))))))))))))))))))))))))))):)))))))::))):(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):((((((((:))):((((((:((((((((:(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((");
    }

    @Test
    public void encodeNewLine() {
        String result = encoder.encode("1\n2");

        assertEquals(result, ";)))))))))))))))))))))))))))))))))))))))))))))))))\n" +
                ";))))))))))))))))))))))))))))))))))))))))))))))))))");
    }

    @Test
    public void encodeEmptyLines() {
        String result = encoder.encode("\n\n");

        assertEquals(result, "\n\n");
    }

}
