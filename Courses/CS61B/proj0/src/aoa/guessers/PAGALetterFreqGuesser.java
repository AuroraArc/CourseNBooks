package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.*;

public class PAGALetterFreqGuesser implements Guesser {
    private final List<String> words;

    public PAGALetterFreqGuesser(String dictionaryFile) {
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
     *  PATTERN and the GUESSES that have been made. */
    public char getGuess(String pattern, List<Character> guesses) {
        List<String> temp = new ArrayList<>();
        List<String> finalList = new ArrayList<>();
        char[] patternArray = pattern.toCharArray();
        char[][] wordsArray = getWordsArray();
        for (int i = 0; i < patternArray.length; i++) {
            if (patternArray[i] == '-') {
                continue;
            }
            for (char[] chars : wordsArray) {
                if (chars[i] == patternArray[i]) {
                    temp.add(String.valueOf(chars));
                }
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                if (temp.get(i).equals(temp.get(j))) {
                    finalList.add(temp.get(i));
                    temp.remove(i);
                    temp.remove(i);
                    i--;
                }
            }
        }

        if (finalList.size() == 0)  {
            finalList = temp;
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
        Collections.sort(duplicates);
        return duplicates.get(0);
        // TODO: Fill in this method.
    }



    public static void main(String[] args) {
        PAGALetterFreqGuesser pagalfg = new PAGALetterFreqGuesser("proj0/data/example.txt");
        System.out.println(pagalfg.getGuess("----", List.of('e')));
    }
}
