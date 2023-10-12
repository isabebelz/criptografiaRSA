package precode;

public class PreCode {

    public static String[] preCodeASCII(String text) {

        String[] preCode = new String[text.length()];

        for(int i = 0; i < text.length(); i++) {
            preCode[i] = String.valueOf((int) text.charAt(i));
        }

        return preCode;
    }


}

