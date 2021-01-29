package by.jwd.task04.entity;

import java.io.Serializable;
import java.util.Objects;

public class Word implements Serializable {

    private String word;

    public Word() {}

    public Word(String word) {
        this.word = word;
    }

    public int length() {return word.length();}

    public char charAt(int index) {
        return word.charAt(index);
    }

    public boolean startWith(String letter) {
        return word.startsWith(letter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return word;
    }


}
