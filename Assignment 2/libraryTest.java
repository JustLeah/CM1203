public class libraryTest {

    public static void main( String[] args ) {

        // Create and fill library
        Library l = new Library();
        Book b1 = new Book("Niccolo Machiavelli", "The Prince", 3);
        Book b2 = new Book("John R.R. Tolkien", "The Hobbit", 3);
        Book b3 = new Book("Dan Ariely", "Predictably Irrational", 4);
        l.addBook( b1 );
        l.addBook( b2 );
        l.addBook( b3 );
       if(10 == l.numberAvailableBooks())
            System.out.println("PASS");
        else
            System.out.println("FAIL");
        b1.withdrawCopy();
        b1.withdrawCopy();
        b1.withdrawCopy();
        if(7 == l.numberAvailableBooks())
            System.out.println("PASS");
        else
            System.out.println("FAIL");

        b1.returnCopy();

        if(8 == l.numberAvailableBooks())
            System.out.println("PASS");
        else
            System.out.println("FAIL");

        b2.withdrawCopy();
        b3.withdrawCopy();
        b3.withdrawCopy();
        if(5 == l.numberAvailableBooks())
            System.out.println("PASS");
        else
            System.out.println("FAIL");
    }

}
