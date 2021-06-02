import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test class for BookStore.
 */
public class BookStoreTest {
  private BookStore bs;

  @Before
  public void setUp() throws Exception {
    bs = new BookStore("books.json");
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testSearchForTitle() {
    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("BELOVED", 
      "TONI MORRISON", "UNITED STATES", "ENGLISH", 1987, 321));
    expected.add(new Book("LOVE IN THE TIME OF CHOLERA",
      "GABRIEL GARCÍA MÁRQUEZ", "COLOMBIA", 
      "SPANISH", 1985, 368));
    expected.add(new Book("SONS AND LOVERS",
      "D. H. LAWRENCE", "UNITED KINGDOM", "ENGLISH",
      1913, 432));

    ArrayList<Book> results = bs.searchForTitle("LOVE");
    
    assertEquals(expected.size(), results.size());

    for(int i = 0; i < expected.size(); i++) {
      assertEquals(expected.get(i), results.get(i));
    }

    expected.clear();

    results = bs.searchForTitle("THAT");

    assertEquals(expected.size(), results.size());

    for(int i = 0; i < expected.size(); i++) {
      assertEquals(expected.get(i), results.get(i));
    }
  }

  @Test
  public void testGetEarliestBook() {
    Book expected = new Book("THE EPIC OF GILGAMESH",
      "UNKNOWN", "SUMER AND AKKADIAN EMPIRE", "AKKADIAN",
      -1700, 160);
    Book result = bs.getEarliestBook();

    assertEquals(expected, result);
  }

  @Test
  public void testNumBooksLaterThan() {
    assertEquals(22, bs.numBooksLaterThan(1950));
    assertEquals(93, bs.numBooksLaterThan(-100));
    assertEquals(0, bs.numBooksLaterThan(2020));
  }

  @Test
  public void testMeanNumPages() {
    assertEquals(439.85, bs.meanNumPages(), 0.01);
  }

  @Test
  public void testBooksByAuthor() {
    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("THE ADVENTURES OF HUCKLEBERRY FINN",
      "MARK TWAIN", "UNITED STATES", "ENGLISH", 1884, 224));

    ArrayList<Book> results = bs.booksByAuthor("MARK TWAIN");

    assertEquals(expected.size(), results.size());
    for(int i = 0; i < expected.size(); i++) {
      assertEquals(expected.get(i), results.get(i));
    }

    expected.clear();
    expected.add(new Book("ANNA KARENINA", "LEO TOLSTOY",
      "RUSSIA", "RUSSIAN", 1877, 864));
    expected.add(new Book("THE DEATH OF IVAN ILYICH", "LEO TOLSTOY",
      "RUSSIA", "RUSSIAN", 1886, 92));
    expected.add(new Book("WAR AND PEACE", "LEO TOLSTOY",
      "RUSSIA", "RUSSIAN", 1867, 1296));

    results = bs.booksByAuthor("leo tolstoy");

    assertEquals(expected.size(), results.size());
    for(int i = 0; i < expected.size(); i++) {
      assertEquals(expected.get(i), results.get(i));
    }

    expected.clear();

    results = bs.booksByAuthor("JOHNson");
    assertEquals(expected.size(), results.size());
    for(int i = 0; i < expected.size(); i++) {
      assertEquals(expected.get(i), results.get(i));
    }
  }

  /**
   * Test launcher.
   *
   * @param args Command-line arguments; ignored by 
   * this application
   */
  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("BookStoreTest");
  }
}