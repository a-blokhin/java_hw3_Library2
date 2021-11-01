import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        int capacity;

        System.out.println("Введите вместимость библиотеки (при ошибочном вводе будет задана вместимость 150):");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            capacity = Integer.parseInt(input);
        }
        catch (NumberFormatException e)
        {
            capacity = 150;
        }

        System.out.println("Введите полный путь к файлу, например:");
        System.out.println("controller\\src\\main\\resources\\books.txt");
        String filepath = scanner.nextLine();

        final Injector injector = Guice.createInjector();
        Library lib = injector.getInstance(LibraryFactory.class).library(capacity, filepath);
        lib.PrintContent();

    }
}
