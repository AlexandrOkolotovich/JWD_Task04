package by.jwd.task04.server.parser.impl;

import by.jwd.task04.entity.Sentence;
import by.jwd.task04.server.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser implements Parser {

    @Override
    public List<Sentence> parse(String parsingText) {
        List<Sentence> sentences = new ArrayList<>();
        for(String sentence : parsingText.split("[.][ ]?")) {
            sentences.add(new Sentence(sentence));
        }
        return sentences;
    }
}
