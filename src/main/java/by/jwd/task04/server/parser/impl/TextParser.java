package by.jwd.task04.server.parser.impl;

import by.jwd.task04.entity.Sentence;
import by.jwd.task04.entity.Text;
import by.jwd.task04.server.parser.Parser;

import java.util.List;

public class TextParser implements Parser {

    @Override
    public Text parse(String parsingText) {
        Text parsedText = new Text(parsingText);

        SentenceParser sentenceParser = new SentenceParser();
        WordParser wordParser = new WordParser();

        List<Sentence> sentences = sentenceParser.parse(parsingText);
        for (Sentence sentence : sentences){
            sentence.setWords(wordParser.parse(sentence.toString()));
        }
        parsedText.setSentences(sentences);
        return parsedText;
    }
}
