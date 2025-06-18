package librarysystem;

public class NonFictionBook extends Book {
    String subject;

    public NonFictionBook(String id, String title, String author, String subject) {
        super(id, title, author);
        this.subject = subject;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
    }
}
