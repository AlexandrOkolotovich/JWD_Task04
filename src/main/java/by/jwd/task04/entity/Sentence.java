package by.jwd.task04.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence implements Serializable {

    private String sentence;
    private List<Word> words;

    private SentenceType sentenceType;

    {
        words = new ArrayList<>();
    }

    public Sentence() {}

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public Sentence(String sentence, List<Word> words) {
        this.sentence = sentence;
        this.words = words;
    }

    public void setWords(List<Word> words) {this.words = words;}

    public List<Word> getWords() {
        return words;
    }

   public void setSentenceType(SentenceType sentenceType) {
        this.sentenceType = sentenceType;
    }

    public SentenceType getSentenceType() {
        return sentenceType;
    }

    public int length() {return sentence.length();}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;
        Sentence sentence1 = (Sentence) o;
        return sentence.equals(sentence1.sentence) && words.equals(sentence1.words) && sentenceType.equals(sentence1.sentenceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence, words, sentenceType);
    }

    @Override
    public String toString() {
        return sentence;
    }
}
