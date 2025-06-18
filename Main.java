package librarysystem;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();

        FictionBook fiction = new FictionBook("F101", "The Hobbit", "J.R.R. Tolkien", "Fantasy");
        NonFictionBook nonFiction = new NonFictionBook("NF202", "A Brief History of Time", "Stephen Hawking", "Science");

        fiction.displayInfo();
        manager.addBook(fiction);

        System.out.println();

        nonFiction.displayInfo();
        manager.addBook(nonFiction);
    }
}
