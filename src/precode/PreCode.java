package precode;

public class PreCode {

    public static String preCodeASCII(String message) {

        StringBuilder preCode = new StringBuilder();

        for(int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            preCode.append((int) character).append(" ");
        }

        return preCode.toString();
    }


}

