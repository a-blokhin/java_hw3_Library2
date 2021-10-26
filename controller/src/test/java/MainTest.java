import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainTest {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    final Injector injector = Guice.createInjector();
    String filepath = "C:\\Users\\tonyb\\Downloads\\Library-master\\controller\\src\\test\\java\\books.txt";


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testPrintContent() throws FileNotFoundException {
        int capacity = 150;
        Library lib = injector.getInstance(LibraryFactory.class).library(capacity, filepath);
        lib.PrintContent();
        String allbooks = "";
        for (int i = 0; i < capacity; i++){
            if (lib.books[i] == null){
                allbooks += i+ " " + "null" + "\n";
            }else{
                allbooks += i+ " " + lib.books[i].toString() + "\n";
            }

        }
        assertEquals(allbooks, output.toString());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowExceptionCapacity() {
        injector.getInstance(LibraryFactory.class).library(90, filepath);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowExceptionTakeBook() {
        Library lib = injector.getInstance(LibraryFactory.class).library(150, filepath);
        lib.TakeBook(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowExceptionAddBook() {
        Library lib = injector.getInstance(LibraryFactory.class).library(100, filepath);
        Book book60 = lib.TakeBook(60);
        lib.AddBook(book60);
        lib.AddBook(book60);
    }

    @Test
    public void testCreateLibrary() throws FileNotFoundException {
        int capacity = 150;
        Type listBooksType = new TypeToken<ArrayList<Book>>() {}.getType();
        ArrayList<Book> booksInFile = new Gson().fromJson(new BufferedReader(new FileReader(filepath)), listBooksType);
        Library lib = injector.getInstance(LibraryFactory.class).library(capacity, filepath);
        for(int i = 0; i < 100; i++) {
            assertEquals(booksInFile.get(i), lib.books[i]);
        }
        for(int i = 100; i < capacity; i++) {
            assertEquals(null, lib.books[i]);
        }
    }

    @Test
    public void testTakeBookOutput() {
        Library lib = injector.getInstance(LibraryFactory.class).library(150, filepath);
        Book book50 = lib.TakeBook(50);
        assertEquals(50+ " " + book50.toString() + "\n", output.toString());
    }

    @Test
    public void testTakeBook() {
        Library lib = injector.getInstance(LibraryFactory.class).library(150, filepath);
        assertEquals(lib.books[50], lib.TakeBook(50));
    }

    @Test
    public void testAddBook() {
        Library lib = injector.getInstance(LibraryFactory.class).library(150, filepath);
        lib.TakeBook(50);
        Book book60 = lib.TakeBook(60);
        lib.AddBook(book60);
        assertEquals(lib.books[50], book60);
    }


}
