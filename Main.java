package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter name: ");
                        String name = scanner.next();
                        String accountId = bankService.createAccount(name);
                        System.out.println("Account created. ID: " + accountId);
                    }
                    case 2 -> {
                        System.out.print("Enter Account ID: ");
                        String id = scanner.next();
                        System.out.print("Amount to deposit: ");
                        double amount = scanner.nextDouble();
                        bankService.deposit(id, amount);
                        System.out.println("Deposited successfully.");
                    }
                    case 3 -> {
                        System.out.print("Enter Account ID: ");
                        String id = scanner.next();
                        System.out.print("Amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        bankService.withdraw(id, amount);
                        System.out.println("Withdrawn successfully.");
                    }
                    case 4 -> {
                        System.out.print("Enter Account ID: ");
                        String id = scanner.next();
                        double balance = bankService.checkBalance(id);
                        System.out.println("Current balance: $" + balance);
                    }
                    case 5 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
