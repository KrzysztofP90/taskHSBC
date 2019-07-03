package com.Krzysztof;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;
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
    public void checkIfCorrectNumberOfBracketsReturnTrue() throws BracketChecker.BadInputException {

        BracketChecker stub = new BracketChecker();
        String testString = "My test [string] to check br[]ackets ";
        boolean expected = true;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfUnCorrectNumberOfBracketsReturnFalse() throws BracketChecker.BadInputException {

        BracketChecker stub = new BracketChecker();
        String testString = "My test [string] to check br[ackets ";
        boolean expected = false;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfFirstCloseSignBeforeOpenSignReturnFalse()  throws BracketChecker.BadInputException{

        BracketChecker stub = new BracketChecker();
        String testString = "My test [string] to check br][ackets ";

        boolean expected = false;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = BracketChecker.BadInputException.class)
    public void checkIfArgWillBeNullNpExceptionThrowsBadInputExcpetion() throws BracketChecker.BadInputException {

        BracketChecker stub = new BracketChecker();
        String testString = null;

        boolean expected = false;

        stub.areBracketsMatchedAndNestedCorrectly(testString);
    }

    @Test
    public void checkIfCorrectNumbersOfAllKindOfSignReturnTrue() throws BracketChecker.BadInputException{

        BracketChecker stub = new BracketChecker();
        String testString = "My test [string] to check {} all kinds of{}{}{} ()()() sig(ns) [][ ]correctl{y} ";

        boolean expected = true;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfUncorrectNumbersOfAllKindOfSignReturnFalse() throws BracketChecker.BadInputException {

        BracketChecker stub = new BracketChecker();
        String testString = "My test [string] to check {} all kinds of{}{{} ())() sig(ns) ][ ]correctl{y} ";

        boolean expected = false;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = BracketChecker.BadInputException.class)
    public void checkIfInputIsEmptyStringThrowBadInputException() throws BracketChecker.BadInputException {

        BracketChecker stub = new BracketChecker();
        String testString = "";

        boolean expected = true;
        stub.areBracketsMatchedAndNestedCorrectly(testString);

    }

    @Test
    public void checkIfUncorrectNumbersOfParentehesesReturnFalse() throws BracketChecker.BadInputException {

        BracketChecker stub = new BracketChecker();
        String testString = "My test (string) to check () all kinds of ())() sig(ns)correctly ";

        boolean expected = false;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfCorrectNumbersOfParentehesesReturnTrue() throws BracketChecker.BadInputException{

        BracketChecker stub = new BracketChecker();
        String testString = "My test (string) to check () all kinds of ()() sig(ns)correctly ";

        boolean expected = true;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfUncorrectNumbersOfBracesReturnFalse() throws BracketChecker.BadInputException {

        BracketChecker stub = new BracketChecker();
        String testString = "My test {string} to check {} all kinds of {}sig{correctly ";

        boolean expected = false;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfCorrectNumbersOfBracesReturnTrue() throws BracketChecker.BadInputException {

        BracketChecker stub = new BracketChecker();
        String testString = "My test (string) to check () all kinds of ()() sig(ns)correctly ";

        boolean expected = true;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIfFirstCloseSignBeforeOpenInDiffrentKindOfSignsReturnFalse()  throws BracketChecker.BadInputException{

        BracketChecker stub = new BracketChecker();
        String testString = "My test [string] }{ to )(check br][ackets ";

        boolean expected = false;

        boolean actual = stub.areBracketsMatchedAndNestedCorrectly(testString);

        Assert.assertEquals(expected, actual);
    }


}
