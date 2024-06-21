import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        String firstWord = "fish";
//        String secondWord = "vista";

        String firstWord = "fish";
        String secondWord = "fort";

        String inputWord = "fosh";
        System.out.println(findMaxLengthForSubstring(inputWord, firstWord));
        System.out.println(findMaxLengthForSubstring(inputWord, secondWord));

        System.out.println();
        System.out.println(findMaxLengthForSubsequence(inputWord, firstWord));
        System.out.println(findMaxLengthForSubsequence(inputWord, secondWord));
    }

    public static int findMaxLengthForSubstring(String inputWord, String comparedWord) {
        int[][] lengthsOfSubstring = new int[inputWord.length()][comparedWord.length()];
        int maxLength = 0;

        for (int j = 0; j < lengthsOfSubstring[0].length; j++) {
            if (inputWord.charAt(0) == comparedWord.charAt(j)) {
                lengthsOfSubstring[0][j] += 1;
                maxLength = lengthsOfSubstring[0][j];
            }
        }

        for (int i = 1; i < lengthsOfSubstring.length; i++) {
            if (inputWord.charAt(i) == comparedWord.charAt(0)) {
                lengthsOfSubstring[i][0] += 1;
                maxLength = lengthsOfSubstring[i][0];
            }
        }

        for (int i = 1; i < lengthsOfSubstring.length; i++) {
            for (int j = 1; j < lengthsOfSubstring[0].length; j++) {
                if (inputWord.charAt(i) == comparedWord.charAt(j)) {
                    lengthsOfSubstring[i][j] = lengthsOfSubstring[i - 1][j - 1] + 1;
                    if (lengthsOfSubstring[i][j] > maxLength) maxLength = lengthsOfSubstring[i][j];
                }
            }
        }

        for (int[] ints : lengthsOfSubstring) {
            System.out.println(Arrays.toString(ints));
        }

        return maxLength;
    }

    public static int findMaxLengthForSubsequence(String inputWord, String comparedWord) {
        int[][] lengthsOfSubsequence = new int[inputWord.length()][comparedWord.length()];
        int maxLength = 0;

        for (int j = 0; j < lengthsOfSubsequence[0].length; j++) {
            if (inputWord.charAt(0) == comparedWord.charAt(j)) {
                lengthsOfSubsequence[0][j] = 1;
                maxLength = lengthsOfSubsequence[0][j];
            } else {
                lengthsOfSubsequence[0][j] = maxLength;
            }
        }

        for (int i = 1; i < lengthsOfSubsequence.length; i++) {
            if (inputWord.charAt(i) == comparedWord.charAt(0)) {
                lengthsOfSubsequence[i][0] = 1;
            } else {
                lengthsOfSubsequence[i][0] = lengthsOfSubsequence[i - 1][0];
            }
        }

        for (int i = 1; i < lengthsOfSubsequence.length; i++) {
            for (int j = 1; j < lengthsOfSubsequence[0].length; j++) {
                if (inputWord.charAt(i) == comparedWord.charAt(j)) {
                    lengthsOfSubsequence[i][j] = lengthsOfSubsequence[i - 1][j - 1] + 1;
                } else {
                    lengthsOfSubsequence[i][j] = Math.max(lengthsOfSubsequence[i - 1][j], lengthsOfSubsequence[i][j - 1]);
                }
            }
        }

        for (int[] ints : lengthsOfSubsequence) {
            System.out.println(Arrays.toString(ints));
        }

        return lengthsOfSubsequence[lengthsOfSubsequence.length - 1][lengthsOfSubsequence[0].length - 1];
    }
}