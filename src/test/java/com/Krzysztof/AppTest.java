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

    @Test
    public void checkIfInputIsEmptyStringReturnTrue() {

        BracketChecker stub = new BracketChecker();
        String testString = "";

        boolean expected = true;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfUncorrectNumbersOfParentehesesReturnFalse() {

        BracketChecker stub = new BracketChecker();
        String testString = "My test (string) to check () all kinds of ())() sig(ns)correctly ";

        boolean expected = false;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfCorrectNumbersOfParentehesesReturnTrue() {

        BracketChecker stub = new BracketChecker();
        String testString = "My test (string) to check () all kinds of ()() sig(ns)correctly ";

        boolean expected = true;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfUncorrectNumbersOfBracesReturnFalse() {

        BracketChecker stub = new BracketChecker();
        String testString = "My test {string} to check {} all kinds of {}sig{correctly ";

        boolean expected = false;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfCorrectNumbersOfBracesReturnTrue() {

        BracketChecker stub = new BracketChecker();
        String testString = "My test (string) to check () all kinds of ()() sig(ns)correctly ";

        boolean expected = true;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }


}
