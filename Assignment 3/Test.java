/*
 * Name: Henry Riches
 * Student number: c1426527
 */

import java.io.*;
import java.util.*;

public class Test{
	public static void main(String[] args) throws IOException{
		// This will test Question 1
		// Make a new instance of the Shortener object
        Shortener test = new Shortener();
        // Tests the shortenWord method
        System.out.println(test.shortenWord("Thanks?"));
        System.out.println(test.shortenWord("Hello"));
        System.out.println(test.shortenWord("Harry"));
        System.out.println(test.shortenWord("Harry."));
        // Tests the shortenMessage method
        System.out.println(test.shortenMessage("hello. My name is Harry, thanks!"));
        System.out.println(test.shortenMessage("One + One = Seven?"));

        //-------------------------------------------------------------------------
        // Test passing through a new file this doesn't abbreviate numbers
        File newfile = new File("noNumberAbb.txt");
        Shortener test2 = new Shortener(newfile);
        // Tests the shortenWord method
        System.out.println(test2.shortenWord("Thanks?"));
        System.out.println(test2.shortenWord("Hello"));
        System.out.println(test2.shortenWord("Harry"));
        System.out.println(test2.shortenWord("Harry."));
        // Tests the shortenMessage method
        System.out.println(test2.shortenMessage("hello. My name is Harry, thanks!"));
        System.out.println(test2.shortenMessage("One + One = Seven?")); 

        //-------------------------------------------------------------------------
        // Test passing through a file path this doesn't abbreviate numbers or hello
        String pathToFile = "D:/Repos/CM1203/Assingment_3/PathTest/noNumberOrHello.txt";
        Shortener test3 = new Shortener(pathToFile);
        // Tests the shortenWord method
        System.out.println(test3.shortenWord("Thanks?"));
        System.out.println(test3.shortenWord("Hello"));
        System.out.println(test3.shortenWord("Harry"));
        System.out.println(test3.shortenWord("Harry."));
        // Tests the shortenMessage method
        System.out.println(test3.shortenMessage("hello. My name is Harry, thanks!"));
        System.out.println(test3.shortenMessage("One + One = Seven?"));
    }
}