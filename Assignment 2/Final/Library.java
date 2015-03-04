/*
* Name: Henry Riches
 * Student number: c1426527
 */

/*
 * A class to represent a library.
 * A library can either have unlimited book capacity or limited book capacity.
 * For limited capacity libraries, books on loan still count towards the 
 * capacity (there must be space reserved for when a book is returned).
 */
import java.util.*;

public class Library {
    // Define fields here
	// to be completed
    private Vector<Book> listOfBooksVector;
    private Book[] listOfBooksArray;
    private int currentSize;
    private int maxSize = -1;
    private int MAX_ENTRIES;
    

    /*
     * Construct a Library with unlimited capacity.
     */ 
    public Library() {
		listOfBooksVector = new Vector<Book>();
    }

    /*
     * Construct a Library with limited capacity.
     */ 
    public Library( int inCapacity ) {
        if(inCapacity > 0){
            MAX_ENTRIES = inCapacity;
            listOfBooksArray = new Book[MAX_ENTRIES];
            currentSize = 0;
            maxSize = inCapacity;
        }
        else
        {
            throw new IllegalStateException("You need to be able to store more then 0 books you numpty");             
        }
    }
    
    // Add methods here
    
    // Add book
    public void addBook(Book newBook){
        if(maxSize == -1){
            listOfBooksVector.add(newBook);
        }else{
            if(currentSize < maxSize){
                listOfBooksArray[currentSize] = newBook;
                currentSize += 1;
            }
            else
            {
                throw new IllegalStateException("There is not enough space to add your book"); 
            }
        }
    }

    //hasBookwithTitle
    public boolean hasBookWithTitle(String bookTitle){
        if(maxSize != -1){
            for (int i = 0; i < maxSize; ++i) {
                if ( listOfBooksArray[i].getTitle().toLowerCase().equals(bookTitle.toLowerCase()) )
                    return true;
                else
                    return false;
            }
        }
        else{
            for (int i = 0; i < listOfBooksVector.size(); ++i) {
                if(listOfBooksVector.get(i).getTitle().toLowerCase().equals(bookTitle.toLowerCase()))
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    //getBookWithTitle
    public Book getBookWithTitle(String bookTitle){
        if(maxSize != -1){
            for (int i = 0; i < maxSize; ++i) {
                if ( listOfBooksArray[i].getTitle().toLowerCase().equals(bookTitle.toLowerCase()) )
                    return listOfBooksArray[i];
                else
                    return null;
            }
        }
        else{
            for (int i = 0; i < listOfBooksVector.size(); ++i) {
                if(listOfBooksVector.get(i).getTitle().toLowerCase().equals(bookTitle.toLowerCase()))
                    return listOfBooksVector.get(i);
                else
                    return null;
            }
        }
        return null;
    }

    //numberAvaliabableBooks
    public int numberAvailableBooks(){
        int avaliableBooks = 0;
        if(maxSize != -1){
            for (int i = 0; i < maxSize; ++i)
               avaliableBooks += listOfBooksArray[i].getAvailableCopies();
             }
        else{
            for (int i = 0; i < listOfBooksVector.size(); ++i) 
                avaliableBooks += listOfBooksVector.get(i).getAvailableCopies();
            }
        return avaliableBooks;
    }

    // Overwrite the toString method
    // Just used this for debugging for myself
     public String toString( ) {
        StringBuffer temp = new StringBuffer();
        if(maxSize != -1){
             for (int i = 0; i < currentSize; ++i) {
                temp.append( listOfBooksArray[i].toString() + "\n" );
             }
        }
        else{
            for (int i = 0; i < listOfBooksVector.size(); ++i) {
                temp.append( listOfBooksVector.get(i).toString() + "\n" );
            }
        }
        return temp.toString();
    }
}


