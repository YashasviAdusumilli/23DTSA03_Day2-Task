package librarysystem;

public class FictionBook extends Book {
    String genre;

    public FictionBook(String id, String title, String author, String genre) {
        super(id, title, author);
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Genre: " + genre);
    }
}
