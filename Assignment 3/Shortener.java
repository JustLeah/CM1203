/*
 * Name: Henry Riches
 * Student number: c1426527
 */
import java.io.*;
import java.util.*;

public class Shortener {
    // This class is only a starting point. You should complete all members
    // below, but you may also need to add other fields and methods to
    // finish the implementation as per the question on the assignment sheet.

    // Added the current file that will be used as well as the abbMap
    // The abbMap will be created when an instance of this object is created
    // All abbreviations will be stored in there to save reloading a file constantly
    private HashMap<String, String> abbMap;
    private File currentFile;

    /*
     * Default constructor that will load a default abbreviations text file.
     */
    public Shortener() throws IOException{
        currentFile = new File ("abbreviations.txt");
        // Now also loads the HashMap
        abbMap = makeMap();
    }
    
    /*
     * Constructor that will load the abbreviations file represented by the
     * File parameter.
     */
    public Shortener( File inAbbreviationsFile ) throws IOException {
        currentFile = inAbbreviationsFile;
        // Now also loads the HashMap
        abbMap = makeMap();
    }
    
    /*
     * Constructor that will load the abbreviations file that the String 
     * parameter is a file path for.
     */
    public Shortener( String inAbbreviationsFilePath ) throws IOException {
        currentFile = new File(inAbbreviationsFilePath);
        // Now also loads the HashMap
        abbMap = makeMap();
    }

    // This method will create a hashmap which is going to be used to abbreviate words
    public HashMap<String, String> makeMap() throws IOException{     
        abbMap = new HashMap<String, String>();
        // Loads the desired file with the correct path that has already been configured
        FileInputStream fis = new FileInputStream(currentFile);
        BufferedReader fileData = new BufferedReader(new InputStreamReader(fis));
        String line = null;
        // Goes through each line of the file and splits the file by the commas and puts 
        // each of those values in to the hashmap which is then returned at the end.
        // Also converts to lowercase to ensure no issues later
        while((line = fileData.readLine()) != null){
               String[] thisLine = line.split(",");
               abbMap.put(thisLine[0].toLowerCase(), thisLine[1].toLowerCase());
            }
        // Close and then return the map
        fileData.close();
        return abbMap;
    }
    
    /*
     * This method attempts to shorten a word by finding its abbreviation. If 
     * no abbreviation exists for this word, then this method will return the 
     * original (i.e., unshortened) word.
     * 
     * You may assume that words are always lower case.
     *
     * `inWord` should be a single word (no spaces). It may optionally be
     * followed by one of the five following punctuation characters:
     *   ,
     *   ?
     *   .
     *   !
     *   ;
     * If one of these characters is at the end of the word this method will
     * shorten the word (ignoring the punctuation) and return the shortened
     * word with the punctuation character at the end.
     * For example,
     *     shortenerObject.shortenWord( "hello?" )
     * should return
     *     "lo?"
     *
     * You may assume that words are always lower case.
     */
    public String shortenWord( String inWord ) {
        // Converts the string to lower, and sets up some variables that will be used
        inWord = inWord.toLowerCase();
        String punc = ",?.!;";
        String ch = Character.toString(inWord.charAt((inWord.length()-1)));
        String lastCh = "";
        String noPuncWord = inWord;
        // Checks to see if the last character is in the punc string
        // If it is it replaces the last character with nothing and puts that character in it's own string
        if(punc.contains(ch)){
            lastCh = ch;
            noPuncWord = inWord.replace(lastCh, "");
        }

        // Gets the shortened value from the map if it exists and returns it with any punc if there was some
        String shortStr = abbMap.get(noPuncWord);
        if(shortStr != null && !shortStr.isEmpty()){
            return (shortStr + lastCh);
        }
        else{
            return (noPuncWord + lastCh);
        }        
    }
    
    /*
     * Attempts to shorten a message by replacing words with their 
     * abbreviations. 
     *
     * You may assume that messages are always lower case.
     *
     * Punctuation characters (,?.!;) should be retained after shortening. See
     * `shortenWord( String inWord )` for more information.
     */
    public String shortenMessage( String inMessage ) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] messageArray = inMessage.split(" ");
        String finalString;

        for(int i = 0; i < messageArray.length; i++){
           if(i == 0){
                stringBuffer.append(shortenWord(messageArray[i]));
           }
           else{
                stringBuffer.append(" " + shortenWord(messageArray[i]));
           }
        }
        finalString = stringBuffer.toString();
        return finalString;
    }
}
