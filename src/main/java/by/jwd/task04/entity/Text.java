package by.jwd.task04.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text implements Serializable {

    private String text;

    private List<Sentence> sentences;
    private List<Word> words;

    {
        sentences = new ArrayList<>();
        words = new ArrayList<>();
    }

    public Text() {
    }

    public Text(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;
        Text text1 = (Text) o;
        return text.equals(text1.text) && sentences.equals(text1.sentences) && words.equals(text1.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, sentences, words);
    }

    @Override
    public String toString() {
        return  text;
    }
}
