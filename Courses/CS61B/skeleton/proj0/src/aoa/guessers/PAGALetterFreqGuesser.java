package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.*;

public class PAGALetterFreqGuesser implements Guesser {
    private final List<String> words;

    public PAGALetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    @Override
    /** Returns the most common letter in the set of valid words based on the current
     *  PATTERN and the GUESSES that have been made. */
    public char getGuess(String pattern, List<Character> guesses) {
        List<String> temp = new ArrayList<>();
        List<String> temp2 = new ArrayList<>();
        List<String> finalList;
        char[] patternArray = pattern.toCharArray();
        if (guesses.size() != 0 && pattern.equals("----")) {
            for (String s : words) {
                for (int i = 0; i < s.length(); i++) {
                    for (char c : guesses) {
                        if (s.charAt(i) == c) {
                            words.remove(s);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < patternArray.length; i++) {
            if (patternArray[i] == '-') {
                continue;
            }
            if (temp.size() == 0) {
                for (String s : words) {
                    if (s.charAt(i) == patternArray[i] && s.length() == pattern.length()) {
                        temp.add(s);
                    }
                }
            }
            else {
                for (String s : temp) {
                    if (pattern.charAt(i) == s.charAt(i)) {
                        temp2.add(s);
                    }
                }
                temp = List.copyOf(temp2);
                temp2.clear();
            }
        }
        finalList = List.copyOf(temp);

        if (pattern.equals("----")) {
            finalList = words;
        }

        return GuessHelper.getGuess(guesses, finalList);
        // TODO: Fill in this method.
    }



    public static void main(String[] args) {
        PAGALetterFreqGuesser pagalfg = new PAGALetterFreqGuesser("proj0/data/example.txt");
        System.out.println(pagalfg.getGuess("----", List.of('e')));
    }
}
