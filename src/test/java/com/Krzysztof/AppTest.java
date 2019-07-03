package com.Krzysztof;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void checkIfCorrectNumberOfBracketsReturnTrue() {

        BracketChecker stub = new BracketChecker();
        String testString = "My test [string] to check br[]ackets ";
        boolean expected = true;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfUnCorrectNumberOfBracketsReturnFalse() {

        BracketChecker stub = new BracketChecker();
        String testString = "My test [string] to check br[ackets ";
        boolean expected = false;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfFirstCloseSignBeforeOpenSignReturnFalse() {

        BracketChecker stub = new BracketChecker();
        String testString = "My test [string] to check br][ackets ";

        boolean expected = false;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfArgWillBeNullNpExceptionReturnFalse() {

        BracketChecker stub = new BracketChecker();
        String testString = null;

        boolean expected = false;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfCorrectNumbersOfAllKindOfSignReturnTrue() {

        BracketChecker stub = new BracketChecker();
        String testString = "My test [string] to check {} all kinds of{}{}{} ()()() sig(ns) [][ ]correctl{y} ";

        boolean expected = true;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfUncorrectNumbersOfAllKindOfSignReturnFalse() {

        BracketChecker stub = new BracketChecker();
        String testString = "My test [string] to check {} all kinds of{}{{} ())() sig(ns) ][ ]correctl{y} ";

        boolean expected = false;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

}
