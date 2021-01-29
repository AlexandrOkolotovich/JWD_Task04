package by.jwd.task04.server.service.impl;

import by.jwd.task04.entity.SentenceType;
import by.jwd.task04.server.service.ActionHandler;
import by.jwd.task04.server.service.TextService;

public class TextActionHandler implements ActionHandler {
    private TextService service;

    public TextActionHandler(TextService service) {
        this.service = service;
    }

    @Override
    public Object getResult() {
        return getResult("0");
    }

    @Override
    public Object getResult(String taskNumberStr) {
        int taskNumber = Integer.parseInt(taskNumberStr);
        Object result;
        switch (taskNumber) {
            case 0:
                result = service.getText();
                break;
            case 1:
                result = service.findSentencesWithRepeatingWords();
                break;
            case 2:
                result = service.sortByWordAmount();
                break;
            case 3:
                result = service.findWordThatNotInOtherSentences();
                break;
            case 4:
                result = service.findRepeatingWordsWithLength(5, SentenceType.INTERROGATIVE);
                break;
            case 5:
                result = service.changeWordsInSomePlace(0, 3);
                break;
            case 6:
                result = service.sortByAlphabet();
                break;
            case 7:
                result = service.sortByVowelsProportion();
                break;
            case 8:
                result = service.sortByFirstConsonant();
                break;
            case 9:
                result = service.sortByLetterAppearance('и');
                break;
            case 10:
                result = service.sortByWordAppearanceInSentences();
                break;
            case 11:
                result = service.deleteSubstring("При", "перечисления");
                break;
            case 12:
                result = service.deleteWordsStartsWithConsonant();
                break;
            case 13:
                result = service.sortByLetterAppearance('и', true);
                break;
            case 14:
                result = service.findPalindrome();
                break;
            case 15:
                result = service.transformWordByDeleteLetter('п');
                break;
            case 16:
                result = service.replaceWord(2, 16, "объявляются");
                break;
            default:
                result = null;
        }
        return result;
    }
}
