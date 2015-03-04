/*
 * Name: Henry Riches
 * Student number: c1426527
 */

/*
 * A class to represent a number of copies of a library book.
 */
public class Book {
    // Define fields here
	private String author;
	private String title;
	private int totalCopies;
	private int avaliableCopies;

	/*
	 * Constructor method for creating a book with a given author,
	 * title, and number of copies.
	 * This constructor checks that the total number of copies argument is 
	 * valid; i.e., the number of copies should be 1 or more. 
	 * If not valid, the constructor will throw an IllegalArgumentException with
	 * an appropriate error message.
	 */

	public Book( String inAuthor, String inTitle, int inTotalNumCopies ) {
		author = inAuthor;
		title = inTitle;
		totalCopies = inTotalNumCopies;
		avaliableCopies = inTotalNumCopies;
	}

	/*
	 * An accessor method that returns the book's author.
	 */
	public String getAuthor() {
		return author;
	}

	/*
	 * An accessor method that returns the book's title.
	 */
	public String getTitle() {
		return title;
	}

	/*
	 * An accessor method that returns the total number of copies of this book.
	 * This should count both withdrawn and returned books.
	 */ 
	public int getTotalCopies() {
		return totalCopies;
	}

	/*
	 * Returns the number of copies of the book that are available
	 * (i.e., not on loan).
	 */
	public int getAvailableCopies() {
		return avaliableCopies;
	}

	/*
	 * Mark one of the copies of this book as on loan.
	 * If there are no available copies to withdraw then this method should 
	 * throw an IllegalStateException with an appropriate error message.
	 */
	public void withdrawCopy() {
		if(avaliableCopies >= 1){
			avaliableCopies -= 1;
		}else{
			throw new IllegalStateException("I'm sorry but all copies of " + title + " are on loan."); 
		}
	}

	/*
	 * Mark one of the copies of this book as returned.
	 * If all of the copies of this book are already returned, this ethod
	 * should throw an IllegalStateException with an appropriate error message.
	 */
	public void returnCopy() {
		if(avaliableCopies < totalCopies){
			avaliableCopies += 1;
		}else{
			throw new IllegalStateException("All copies of " + title + " are currently in stock"); 
		}
	}

	public String toString( ) {
        return "Author: " +author + ", Title: " + title + ", Total Copies: " + totalCopies + ", Avaliable Copies: " + avaliableCopies;
    }
}


