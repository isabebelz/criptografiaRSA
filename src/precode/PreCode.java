package precode;

import java.util.ArrayList;
import java.util.List;

public class PreCode {

    //private static final int BLOCK_SIZE = 128; // block size in bits 256

    public static String[] preCodeASCII(String text) {

        String[] preCode = new String[text.length()];

        for(int i = 0; i < text.length(); i++) {
            preCode[i] = String.valueOf((int) text.charAt(i));
        }

        return preCode;
    }


    /*public static List<String> addPaddingDivideBlocks(String preCode) {

        List<String> blocks = new ArrayList<>();

        //int paddingSize = BLOCK_SIZE / 8 - preCode.length() % (BLOCK_SIZE / 8);

        StringBuilder block = new StringBuilder(preCode);


        //block.append(String.valueOf(paddingSize).repeat(paddingSize));


        for(int i = 0; i < block.length(); i += BLOCK_SIZE / 8) {
            int end = Math.min(i + BLOCK_SIZE / 8, block.length());
            blocks.add(block.substring(i, end));
        }

        return blocks;
    }*/


}

