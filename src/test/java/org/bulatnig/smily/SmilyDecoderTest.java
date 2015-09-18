package org.bulatnig.smily;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SmilyDecoderTest {

    private final SmilyDecoder decoder = new SmilyDecoder();

    @Test
    public void decodeString() {
        String input = ";)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):))))))))))))))))))))))))))))):)))))))::))):(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):((((((((:))):((((((:((((((((:(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((";

        String result = decoder.decode(input);

        assertEquals(result, "Hello world!");
    }

    @Test
    public void decodeNewLine() {
        String input = ";)))))))))))))))))))))))))))))))))))))))))))))))));))))))))))))))))))))))))))))))))))))))))))))))))))";

        String result = decoder.decode(input);

        assertEquals(result, "1\n2");
    }

    @Test
    public void decodeEmptyLines() {
        String result = decoder.decode("\n\n");

        assertEquals(result, "\n\n");
    }

    @Test
    public void ignoreNewLineCommandAfterLF() {
        String result = decoder.decode("\n;");

        assertEquals(result, "\n");
    }

}
