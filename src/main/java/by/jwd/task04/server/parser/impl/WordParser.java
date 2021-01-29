package by.jwd.task04.server.parser.impl;

import by.jwd.task04.entity.Word;
import by.jwd.task04.server.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class WordParser implements Parser {
    @Override
    public List<Word> parse(String parsingText) {
        List<Word> words = new ArrayList<>();
        for (String word : parsingText.split("[,.!?:;]?[ ]+")){
            words.add(new Word(word));
        }
        return words;
    }
}
