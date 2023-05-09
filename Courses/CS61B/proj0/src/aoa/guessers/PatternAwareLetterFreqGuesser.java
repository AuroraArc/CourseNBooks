package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.*;

public class PatternAwareLetterFreqGuesser implements Guesser {
    private final List<String> words;

    public PatternAwareLetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }


    public char[][] getWordsArray() {
        char[][] wordsArray = new char[words.size()][1];
        int i = 0;
        for (String word : words) {
            wordsArray[i] = word.toCharArray();
            i++;
        }
        return wordsArray;
    }
    @Override
    /** Returns the most common letter in the set of valid words based on the current
     *  PATTERN. */
    public char getGuess(String pattern, List<Character> guesses) {
        List<String> temp = new ArrayList<>();
        List<String> temp2 = new ArrayList<>();
        List<String> finalList;
        char[] patternArray = pattern.toCharArray();
        char[][] wordsArray = getWordsArray();
        for (int i = 0; i < patternArray.length; i++) {
            if (patternArray[i] == '-') {
                continue;
            }
            if (temp.size() == 0) {
                for (char[] chars : wordsArray) {
                    if (chars[i] == patternArray[i] && chars.length == pattern.length()) {
                        temp.add(String.valueOf(chars));
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

        Map<Character, Integer> map = new TreeMap<>();
        for (String s : finalList) {
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                }
                else {
                    map.put(s.charAt(i), 1);
                }
            }
        }

        for (char c : guesses) {
            map.remove(c);
        }


        List<Character> keyArray = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            keyArray.add((Character)map.keySet().toArray()[i]); // converts the keys in the map into an array
        }
        List<Character> duplicates = new ArrayList<>();
        int answer = map.get(keyArray.get(0));
        duplicates.add(keyArray.get(0));
        for (int i = 1; i < keyArray.size(); i++) {
            if (map.get(keyArray.get(i)) == answer) {
                duplicates.add(keyArray.get(i));
            }
            if (map.get(keyArray.get(i)) > answer) {
                duplicates.clear();
                answer = map.get(keyArray.get(i));
                duplicates.add(keyArray.get(i));
            }
        }
        return duplicates.get(0);
    }

    public static void main(String[] args) {
        PatternAwareLetterFreqGuesser palfg = new PatternAwareLetterFreqGuesser("data/example.txt");
        System.out.println(palfg.getGuess("-e--", List.of('e')));
    }
}