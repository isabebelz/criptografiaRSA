package precode;

/**
 * A classe PreCode fornece um método para a pré-codificação de texto em formato ASCII.
 */
public class PreCode {

    /**
     * Converte um texto em uma matriz de strings representando os valores ASCII de cada caractere.
     *
     * @param text O texto a ser pré-codificado.
     * @return Uma matriz de strings representando os valores ASCII de cada caractere do texto.
     */
    public static String[] preCodeASCII(String text) {

        String[] preCode = new String[text.length()];

        for(int i = 0; i < text.length(); i++) {
            preCode[i] = String.valueOf((int) text.charAt(i));
        }

        return preCode;
    }
}


