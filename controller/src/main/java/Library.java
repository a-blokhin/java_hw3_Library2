import com.google.gson.Gson;
import lombok.Data;

@Data
public class Library  {
    Book[] books;

    public Book TakeBook(int num){
        if (books[num] == null) {
            throw new IllegalArgumentException("Cell is empty");
        }
        Book returnedBook = books[num];
        System.out.println(num + " " + returnedBook);
        books[num] = null;
        return returnedBook;
    }

    public void AddBook(Book book){
        for(int i = 0; i < books.length; i++) {
            if(books[i] == null) {
                books[i] = book;
                break;
            }
            if (i+1 == books.length){
                throw new IndexOutOfBoundsException("Cell is empty");
            }
        }
    }

    public void PrintContent(){
        for(int i = 0; i < books.length; i++){
            System.out.println(i +" " + books[i]);
        }
    }
}
