package by.jwd.task04.server.service;

import by.jwd.task04.entity.Word;

import java.util.regex.Pattern;

public class WordService {
    private Word word;

    public WordService(Word word) {
        this.word = word;
    }

    public double vowelsProportion() {
        int syllables = word.toString().split("[eauio]+").length;
        return syllables / (double) word.length();
    }

    public int indexOfFirstConsonant() {
        String consonant = "bcdfghjklmnpqrstvwxBCDFGHJKLMNPQRSTVWX";
        for (int i = 0; i < word.length(); i++) {
            if (consonant.contains(word.charAt(i) + "")) {
                return i;
            }
        }
        return -1;
    }

    public int count(char letter) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }

    public boolean startsWithConsonant() {
        Pattern pattern = Pattern.compile("[^aeoui]");
        return pattern.matcher(word.toString()).matches();
    }

    public boolean isPalindrom() {
        int n = word.length();
        for (int i = 0; i < (n/2); ++i) {
            if (word.charAt(i) != word.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
