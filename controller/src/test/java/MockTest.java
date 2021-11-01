import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;


public final class MockTest {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    final Injector injector = Guice.createInjector();
    String filepath = "controller\\src\\test\\java\\books.txt";

    @Mock
    private @NotNull Book mockBook;

    @Spy
    private @NotNull Book spyBook = new Book();

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowExceptionAddBook() {
        Library lib = injector.getInstance(LibraryFactory.class).library(150, filepath);
        for(int i = 0; i < 60; i++) {
            lib.AddBook(spyBook);
        }
    }
    @Test
    public void testAddBook() {
        Library lib = injector.getInstance(LibraryFactory.class).library(150, filepath);
        lib.TakeBook(50);
        lib.AddBook(mockBook);
        assertEquals(lib.books[50], mockBook);
    }
    @After
    public void after() {
        Mockito.reset();
    }
}
