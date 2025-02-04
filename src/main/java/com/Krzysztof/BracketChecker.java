package com.Krzysztof;

public class BracketChecker {

    private final char openBracket = '[';
    private final char closeBracket = ']';
    private final char openBrace = '{';
    private final char closeBrace = '}';
    private final char openParenthes = '(';
    private final char closeParenthes = ')';
    private String textToCheck;

    public BracketChecker(String textToCheck) {
        this.textToCheck = textToCheck;
    }

    public boolean areBracketsMatchedAndNestedCorrectly()  {

        if (textToCheck == null || textToCheck.equals("")) {
            return false;
        }
        int countOfBrackets = 0;
        int countOfBraces = 0;
        int countOfParenthes = 0;

        char[] textArray = textToCheck.toCharArray();

        for (char ch : textArray) {
            switch (ch) {
                case openBracket: countOfBrackets ++;
                break;
                case closeBracket: countOfBrackets --;
                break;
                case openBrace: countOfBraces ++;
                break;
                case closeBrace: countOfBraces --;
                break;
                case openParenthes: countOfParenthes ++;
                break;
                case closeParenthes: countOfParenthes --;
                break;
            }
            if (countOfBraces == -1 || countOfBrackets == -1 || countOfParenthes == -1) {
                return false;
            }

        }
        if (countOfBrackets == 0 && countOfBraces == 0 && countOfParenthes == 0) {
            return true;
        } else return false;
    }

    class BadInputException extends Exception {


    }
}
