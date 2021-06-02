import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for the IST 146 Module 03 HOA.
 */
public class Main {
    /**
     * Display the menu of options
     */
    private static void printMenu() {
        System.out.println("Welcome to our bookstore! Please choose:");
        System.out.println("\tP)rint entire inventory");
        System.out.println("\tSearch by T)itle");
        System.out.println("\tShow E)arliest book");
        System.out.println("\tShow number of books since a given Y)ear");
        System.out.println("\tM)ean number of pages");
        System.out.println("\tShow books by a given A)uthor");
        System.out.println("\tQ)uit the program");
        System.out.print("Enter option: ");
    }
    /**
     * Application entry point.
     *
     * @param args Command-line arguments; ignored by this app.
     */
    public static void main(String[] args) {
        BookStore bs = new BookStore("books.json");
        Scanner stdin = new Scanner(System.in);

        printMenu();
        String choice = stdin.nextLine();
        while (!choice.equalsIgnoreCase("Q")) {
            switch (choice) {
                case "p":
                case "P":
                    System.out.println(bs);
                    break;
                case "t":
                case "T":
                    System.out.print("Enter title keyword: ");
                    String title = stdin.nextLine().toUpperCase();
                    ArrayList<Book> res = bs.searchForTitle(title);
                    System.out.println("Results:");
                    for(Book b : res) {
                      System.out.println(b);
                    }
                    break;
                case "e":
                case "E":
                    System.out.println("Earliest book: " + bs.getEarliestBook());
                    break;
                case "y":
                case "Y":
                    System.out.print("Enter year: ");
                    int year = Integer.parseInt(stdin.nextLine());
                    System.out.printf("Number of books since %d: %d\n", year, bs.numBooksLaterThan(year));
                    break;
                case "m":
                case "M":
                    System.out.printf("Mean number of pages: %.2f\n", bs.meanNumPages());
                    break;
                case "a":
                case "A":
                    System.out.print("Enter author: ");
                    String author = stdin.nextLine();
                    System.out.printf("Books by %s\n", author);
                    for(Book b : bs.booksByAuthor(author)) {
                        System.out.println("\t" + b);
                    }
                    break;
                default:
                    System.out.println("Please enter P, E, Y, M, A, or Q.");
                    break;
            } // switch

            System.out.println();
            printMenu();
            choice = stdin.nextLine();
        } // while

        System.out.println("Thanks for using our bookstore!");
    } // main
} // Main
