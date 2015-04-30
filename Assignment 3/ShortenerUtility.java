/*
 * Name: Henry Riches
 * Student number: c1426527
 */

import java.io.*;
import java.util.*;

/*
 * A command-line application that shortens a message.
 */
public class ShortenerUtility {
    public static void main(String[] args) throws IOException{
		// Collect all the args passed through from the command line and make a string
		// This is incase the user doesn't use quotation marks around their string
		// Even if they do the output will still be the same
		// And yes I did read that it would be a single command line arguement but I was curious as to what would be the best way to do it!
    	StringBuffer message = new StringBuffer();
		for(int i = 0; i < args.length; i++){
			if(i == 0){
                message.append(args[i]);
           }
           else{
                message.append(" " + args[i]);
           }
		}
		// Turn the messsage to a String
		String finalMessage = message.toString();
		// Make a new instance of the Shortener object
        Shortener commandLineShort = new Shortener();
        // Print out the abbreviated version of that message
        System.out.println(commandLineShort.shortenMessage(finalMessage));
    }
}