import lombok.Data;

@Data public class Book {
    public Author author = new Author();
    public  String name;
}