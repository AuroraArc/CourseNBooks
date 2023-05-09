package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.*;

public class NaiveLetterFreqGuesser implements Guesser {
    private final List<String> words;

    public NaiveLetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    @Override
    /** Makes a guess which ignores the given pattern. */
    public char getGuess(String pattern, List<Character> guesses) {
        return getGuess(guesses);
    }

    /** Returns a map from a given letter to its frequency across all words.
     *  This task is similar to something you did in hw0b! */
    public Map<Character, Integer> getFrequencyMap() {
        Map<Character, Integer> map = new TreeMap<>();
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                }
                else {
                    map.put(s.charAt(i), 1);
                }
            }
        }
        return map;
    }

    /** Returns the most common letter in WORDS that has not yet been guessed
     *  (and therefore isn't present in GUESSES). */
    public char getGuess(List<Character> guesses) {
        Map<Character, Integer> map = getFrequencyMap();
        if (map.isEmpty()) { // checks if there are any keys in the frequency map
            return '?';
        }
        for (char c : guesses) { // removes all the characters that have been guessed from the frequency map
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
        NaiveLetterFreqGuesser nlfg = new NaiveLetterFreqGuesser("proj0/data/example.txt");
        System.out.println("list of words: " + nlfg.words);
        System.out.println("frequency map: " + nlfg.getFrequencyMap());

        List<Character> guesses = List.of('e', 'l');
        System.out.println("guess: " + nlfg.getGuess(guesses));
    }
}
