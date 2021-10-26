import com.google.gson.Gson;

import static java.lang.Math.min;

public class LibraryFactory  extends Library{
    public Library library(int capacity, String filepath){
        Library lib = new Library();
        lib.books = new Book[capacity];
        FileBookFactory fileBooks = new FileBookFactory(filepath);
        Book[] allBooks = fileBooks.books().toArray(new Book[]{});
        if (allBooks.length > capacity){
            throw new IndexOutOfBoundsException("too small capacity");
        }
        int min_length = min(capacity, allBooks.length);
        for(int i = 0; i < min_length; i++) {
            lib.books[i] = allBooks[i];
        }
        return lib;
    }
}
