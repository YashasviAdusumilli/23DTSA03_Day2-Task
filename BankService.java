package org.example;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

public class BankService {
    private final MongoCollection<Document> accounts;

    public BankService() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("BankDB");
        accounts = database.getCollection("Accounts");
    }

    public String createAccount(String name) {
        Document doc = new Document("name", name).append("balance", 0.0);
        accounts.insertOne(doc);
        return doc.getObjectId("_id").toString();
    }

    public void deposit(String accountId, double amount) {
        Document account = findAccount(accountId);
        double newBalance = account.getDouble("balance") + amount;
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        accounts.updateOne(new Document("_id", new ObjectId(accountId)),
                new Document("$set", new Document("balance", newBalance)));
    }

    public void withdraw(String accountId, double amount) {
        Document account = findAccount(accountId);
        double currentBalance = account.getDouble("balance");
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > currentBalance) throw new IllegalArgumentException("Insufficient balance");
        double newBalance = currentBalance - amount;
        accounts.updateOne(new Document("_id", new ObjectId(accountId)),
                new Document("$set", new Document("balance", newBalance)));
    }

    public double checkBalance(String accountId) {
        Document account = findAccount(accountId);
        return account.getDouble("balance");
    }

    private Document findAccount(String accountId) {
        Document account = accounts.find(new Document("_id", new ObjectId(accountId))).first();
        if (account == null) throw new IllegalArgumentException("Account not found");
        return account;
    }
}
