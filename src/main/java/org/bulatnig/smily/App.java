package org.bulatnig.smily;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {

    private final Mode mode;
    private final String inputFilePath;

    public App(Mode mode, String inputFilePath) {
        this.mode = mode;
        this.inputFilePath = inputFilePath;
    }

    private void process() throws RuntimeException {
        try {
            String input = new String(Files.readAllBytes(Paths.get(inputFilePath)), StandardCharsets.UTF_8);
            if (Mode.encode == mode) {
                String encoded = new SmilyEncoder().encode(input);
                Files.write(Paths.get("encoded.out"), encoded.getBytes(StandardCharsets.UTF_8));
            } else {
                String decoded = new SmilyDecoder().decode(input);
                Files.write(Paths.get("decoded.out"), decoded.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            throw new RuntimeException("Processing failed for input=" + inputFilePath, e);
        }
    }

    public static void main(String[] args) {
        if (args.length == 2) {
            Mode mode = Mode.valueOf(args[0]);
            App app = new App(mode, args[1]);
            app.process();
        } else {
            System.out.println("smily.jar mode[encode/decode] inputFile");
        }
    }

    private enum Mode {
        encode,
        decode
    }
}
