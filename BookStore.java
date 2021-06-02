import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.json.*;

/**
 * Class encapsulating a Bookstore. The class manages a
 * list of Book objects.
 */
public class BookStore {
    /** List of Book objects maintained by this class. */
    private ArrayList<Book> library;

    /**
     * Default constructor. Create an empty bookstore.
     */
    public BookStore() {
        library = new ArrayList<>();
    }

    /**
     * Initializing constructor. Create a bookstore initialized
     * with data from the indicated local JSON file.
     *
     * @param fileName Name of JSON file containing array of books.
     */
    public BookStore(String fileName) {
        library = new ArrayList<>();
        try {
            // read in the JSON as a String
            Scanner source = new Scanner(new FileInputStream(fileName));
            String json = "";
            while (source.hasNext()) {
                json += source.nextLine();
            }

            // Convert to JSON Array
            JSONArray jBooks = new JSONArray(json);

            // iterate through JSON Array, add to bookstore list
            for (int i = 0; i < jBooks.length(); i++) {
                JSONObject jBook = jBooks.getJSONObject(i);
                library.add(new Book(
                        jBook.getString("title"),
                        jBook.getString("author"),
                        jBook.getString("country"),
                        jBook.getString("language"),
                        jBook.getInt("year"),
                        jBook.getInt("pages")
                ));
            }
            // size the list appropriately
            library.trimToSize();
            // sort books by title
            Collections.sort(library);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // initializing constructor

    /**
     * Generates list of books containing searchString
     *
     * @param searchString the keyword to search for
     * @return the ArrayList of books containing the keyword
     */
    public ArrayList<Book> searchForTitle(String searchString) {
        ArrayList<Book> searchResult = new ArrayList<>();
        for (Book currentBook : library) {
            if (currentBook.getTitle().indexOf(searchString) != -1)
                searchResult.add(currentBook);
        }
        searchResult.trimToSize();
        return searchResult;
    }

    /**
     * Get the earliest book in this bookstore.
     *
     * @return The Book object with the smallest year value.
     */
    public Book getEarliestBook() {
        // TODO: Write code to find and return eariest book in library

        return null; // TODO: modify return value
    }

    /**
     * Find the number of books in the bookstore published after a given year.
     *
     * @param year Earliest year for books counted
     * @return Number of books in this bookstore published in a year >=
     * the parameter.
     */
    public int numBooksLaterThan(int year) {
        // TODO: Write code to count books in library with year >=
        // the parameter

        return 0;
    }

    /**
     * Calculate the mean number of pages of all the
     * books in this bookstore.
     *
     * @return Mean number of pages of all the books
     */
    public double meanNumPages() {
        // TODO: write code to compute mean number of pages

        return 0.0; // TODO: modify return value
    }

    /**
     * Get a list of all the books in the store by a given author.
     *
     * @param author name of the author to search for
     *
     * @return ArrayList of all books in the library by that author
     * (exact match only, ignoring case)
     */
    public ArrayList<Book> booksByAuthor(String author) {
        // TODO: write code to find all books by a given author

        return new ArrayList<Book>(); // TODO: modify return value
    }

    @Override
    public String toString() {
        String res = "";
        for(Book b : library) {
            res = res + b + "\n";
        }
        return res;
    }
}
