package org.bulatnig.smily;

public class SmilyDecoder {

    public String decode(String data) {
        StringBuilder totalBuilder = new StringBuilder();
        StringBuilder lineBuilder = new StringBuilder();
        int cur = 0;
        for (int i = 0; i < data.length(); i++) {
            char in = data.charAt(i);
            switch (in) {
                case SmilyEncoder.LF:
                    if (cur != 0) {
                        lineBuilder.append((char) cur);
                        totalBuilder.append(lineBuilder);
                    }
                    totalBuilder.append("\n");
                    lineBuilder = new StringBuilder();
                    cur = 0;
                    break;
                case Command.NEW_LINE:
                    if (cur != 0) {
                        lineBuilder.append((char) cur);
                    }
                    totalBuilder.append(lineBuilder);
                    if (i != 0 && SmilyEncoder.LF != data.charAt(i-1)) {
                        totalBuilder.append("\n");
                    }
                    lineBuilder = new StringBuilder();
                    cur = 0;
                    break;
                case Command.INCREMENT:
                    cur++;
                    break;
                case Command.DECREMENT:
                    cur--;
                    break;
                case Command.OUTPUT:
                    if (cur != 0) {
                        lineBuilder.append((char) cur);
                    }
                    break;
                default:
                    // omit it
            }
        }
        if (cur != 0) {
            lineBuilder.append((char) cur);
            totalBuilder.append(lineBuilder);
        }
        return totalBuilder.toString();
    }

}
