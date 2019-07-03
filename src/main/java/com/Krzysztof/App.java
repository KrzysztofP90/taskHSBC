package com.Krzysztof;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello HSBC!" );
        BracketChecker checker = new BracketChecker("fds");


          System.out.println(checker.areBracketsMatchedAndNestedCorrectly());


    }
}
