package precode;

import java.util.ArrayList;
import java.util.List;

public class PreCode {

    private static final int BLOCK_SIZE = 256; // block size in bits

    public static String preCodeASCII(String message) {

        StringBuilder preCode = new StringBuilder();

        for(int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            preCode.append((int) character);//.append(" ");
        }

        return preCode.toString();
    }


    public static List<String> divideBlocksAddPadding(String message) {

        List<String> blocks = new ArrayList<>();

        String preCode = preCodeASCII(message);

        int paddingSize = BLOCK_SIZE / 8 - preCode.length() % (BLOCK_SIZE / 8);

        StringBuilder block = new StringBuilder(preCode);

        block.append(String.valueOf((char) paddingSize).repeat(paddingSize));

        for(int i = 0; i < block.length(); i += BLOCK_SIZE / 8) {
            int end = Math.min(i + BLOCK_SIZE / 8, block.length());
            blocks.add(block.substring(i, end));
        }

        return blocks;
    }

}

