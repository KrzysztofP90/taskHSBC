package com.Krzysztof;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{




    @Test
    public void testPairedSquareBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[]");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testEmptyString() {
        BracketChecker bracketChecker = new BracketChecker("");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testUnpairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[[");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testIncorrectlyOrderedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("}{");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testSingleOpenBracketWithIncorrectClosingBracket() {
        BracketChecker bracketChecker = new BracketChecker("{]");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testPairedBracketsWithWhitespace() {
        BracketChecker bracketChecker = new BracketChecker("{ }");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testPartiallyPairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{[])");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testSimpleNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{[]}");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testSeveralPairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{}[]");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testPairedAndNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("([{}({}[])])");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testUnopenedClosingBracket() {
        BracketChecker bracketChecker = new BracketChecker("{[)][]}");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testUnpairedAndNestedBracket() {
        BracketChecker bracketChecker = new BracketChecker("([{])");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testPairedAndIncorrectlyNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[({]})");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testValidMathExpression() {
        BracketChecker bracketChecker = new BracketChecker("(((185 + 223.85) * 15) - 543)/2");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }


    @Test
    public void testValidComplexLaTeXExpression() {
        BracketChecker bracketChecker = new BracketChecker(
                "\\left(\\begin{array}{cc} \\frac{1}{3} & x\\\\ \\mathrm{e}^{x} &... x^2 \\end{array}\\right)");

        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }



}
