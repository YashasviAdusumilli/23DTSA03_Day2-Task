package librarysystem;

import com.mongodb.client.*;
import org.bson.Document;

import static com.mongodb.client.MongoClients.create;

public class LibraryManager {
    public MongoCollection<Document> bookCollection;

    public LibraryManager() {
        MongoClient mongoClient = create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("library_db");
        MongoCollection<Document> collection = database.getCollection("books");

    }

    public void addBook(Book book) {
        Document doc = new Document("id", book.id)
                .append("title", book.title)
                .append("author", book.author);

        if (book instanceof FictionBook) {
            doc.append("type", "Fiction");
            doc.append("genre", ((FictionBook) book).genre);
        } else if (book instanceof NonFictionBook) {
            doc.append("type", "NonFiction");
            doc.append("subject", ((NonFictionBook) book).subject);
        }

        bookCollection.insertOne(doc);
        System.out.println("Book added to MongoDB.");
    }
}
