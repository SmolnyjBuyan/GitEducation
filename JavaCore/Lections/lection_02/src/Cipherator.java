public class Cipherator {
    private final String LowerCaseAlphabet =  "abcdefghijklmnopqrstuvwxyz";
    private final String UpperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String sentence;

    public Cipherator(String sentence) {
        this.sentence = sentence;
    }

    private int getLowerCaseAlphabetIndex(char symbol) {
        return LowerCaseAlphabet.indexOf(symbol);
    }

    private int getUpperCaseAlphabetIndex(char symbol) {
        return UpperCaseAlphabet.indexOf(symbol);
    }

    private char cipherLowerCaseLetter(int charIndex, int key) {
        return LowerCaseAlphabet.charAt((charIndex + key) % LowerCaseAlphabet.length());
    }

    private char cipherUpperCaseLetter(int charIndex, int key) {
        return UpperCaseAlphabet.charAt((charIndex + key) % UpperCaseAlphabet.length());
    }

    private char decipherLowerCaseLetter(int charIndex, int key) {
        return cipherLowerCaseLetter(charIndex, LowerCaseAlphabet.length() - (key % LowerCaseAlphabet.length()));
    }

    private char decipherUpperCaseLetter(int charIndex, int key) {
        return cipherUpperCaseLetter(charIndex, UpperCaseAlphabet.length() - (key % UpperCaseAlphabet.length()));
    }


    public String cipherOrDecipherCaesar(boolean isCipher, int key) {
        if (key < 0) {
            key = LowerCaseAlphabet.length() - Math.abs(key % LowerCaseAlphabet.length());
        }
        StringBuilder result = new StringBuilder();

        if (isCipher) {
            for (int i = 0; i < sentence.length(); i++) {
                char cipheredLetter;
                int charIndex = getLowerCaseAlphabetIndex(sentence.charAt(i));

                if (charIndex >= 0) {
                    cipheredLetter = cipherLowerCaseLetter(charIndex, key);
                } else {
                    charIndex = getUpperCaseAlphabetIndex(sentence.charAt(i));
                    if (charIndex >= 0) {
                        cipheredLetter = cipherUpperCaseLetter(charIndex, key);
                    } else {
                        cipheredLetter = sentence.charAt(i);
                    }
                }

                result.append(cipheredLetter);
            }
        } else {
            for (int i = 0; i < sentence.length(); i++) {
                char decipheredLetter;
                int charIndex = getLowerCaseAlphabetIndex(sentence.charAt(i));

                if (charIndex >= 0) {
                    decipheredLetter = decipherLowerCaseLetter(charIndex, key);
                } else {
                    charIndex = getUpperCaseAlphabetIndex(sentence.charAt(i));
                    if (charIndex >= 0) {
                        decipheredLetter = decipherUpperCaseLetter(charIndex, key);
                    } else {
                        decipheredLetter = sentence.charAt(i);
                    }
                }

                result.append(decipheredLetter);
            }
        }

        return result.toString();
    }
}
