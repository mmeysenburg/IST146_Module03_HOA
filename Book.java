import java.util.Locale;

/**
 * Class encapsulating a book.
 */
public class Book implements Comparable<Book>{

    /** Book's author. */
    private String author;

    /** Book's country of origin." */
    private String country;

    /** Language book originally written in. */
    private String language;

    /** Number of pages in the book. */
    private int pages;

    /** Title of the book. */
    private String title;

    /** Year book was first published. */
    private int year;

    /**
     * Default construtor - book with empty string fields,
     * zero for integer fields.
     */
    public Book() {
        setAuthor("");
        setCountry("");
        setLanguage("");
        setTitle("");
    }

    /**
     * Initializing constructor. Build a new book with the specified values.
     *
     * @param title Title of the book.
     * @param author Author of the book.
     * @param country Book's country of origin.
     * @param language Book's original language;
     * @param year Year of book's first publishing; positive values are CE,
     *             negative are BCE.
     * @param pages Number of pages in the book (must be positive).
     */
    public Book(String title, String author, String country, String language, int year, int pages) {
        setAuthor(author.toUpperCase());
        setCountry(country.toUpperCase());
        setLanguage(language.toUpperCase());
        setTitle(title.toUpperCase());
        setPages(pages);
        setYear(year);
    }

    /** @return Book's author. */
    public String getAuthor() {
        return author;
    }

    /** @param author new author value. */
    public void setAuthor(String author) {
        this.author = author;
    }

    /** @return Book's country of origin." */
    public String getCountry() {
        return country;
    }

    /** @param country new country value. */
    public void setCountry(String country) {
        this.country = country;
    }

    /** @return Language book originally written in. */
    public String getLanguage() {
        return language;
    }

    /** @param language new language value. */
    public void setLanguage(String language) {
        this.language = language;
    }

    /** @return Number of pages in the book. */
    public int getPages() {
        return pages;
    }

    /** @param pages new pages value. Must be positive. */
    public void setPages(int pages) {
        if(pages >= 0)
            this.pages = pages;
    }

    /** @return Title of the book. */
    public String getTitle() {
        return title;
    }

    /** @param title new title value. */
    public void setTitle(String title) {
        this.title = title;
    }

    /** @return Year book was first published. */
    public int getYear() {
        return year;
    }

    /** @param year new year value. Positive values are CE,
     *  negative are BCE.
     */
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Book)) {
            return false;
        } else {
            return toString().equalsIgnoreCase(o.toString());
        }
    }

    @Override
    public String toString() {
        return String.format(("%s\t%s\t%s\t%s\t%4d\t%d"),
                getTitle(),
                getAuthor(),
                getLanguage(),
                getCountry(),
                getYear(),
                getPages());
    }

    @Override
    public int compareTo(Book o) {
        return getTitle().compareTo(o.getTitle());
    }
}
