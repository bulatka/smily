package org.bulatnig.smily;

public class SmilyEncoder {

    static final char CR = 13;
    static final char LF = 10;

    public String encode(String data) {
        StringBuilder totalBuilder = new StringBuilder();
        StringBuilder lineBuilder = new StringBuilder();
        int cur = 0;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (CR == c) {
                continue;
            }
            if (LF == c) {
                totalBuilder.append(lineBuilder);
                totalBuilder.append("\n");
                lineBuilder = new StringBuilder();
                cur = 0;
                continue;
            }
            if (cur == 0) {
                lineBuilder.append(Command.NEW_LINE);
            } else {
                lineBuilder.append(Command.OUTPUT);
            }
            int diff = c - cur;
            if (diff > 0) {
                appendCharTimes(lineBuilder, Command.INCREMENT, Math.abs(diff));
            } else if (diff < 0) {
                appendCharTimes(lineBuilder, Command.DECREMENT, Math.abs(diff));
            }
            cur = c;
        }
        totalBuilder.append(lineBuilder);
        return totalBuilder.toString();
    }

    private void appendCharTimes(StringBuilder sb, char c, int times) {
        for (int i = 0; i < times; i++) {
            sb.append(c);
        }
    }

}
