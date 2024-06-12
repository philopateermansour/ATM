package ProjectSoftware_ATM;

import java.sql.SQLException;
import java.util.Scanner;

public class ATM {
    private final Bank bank;
    private Account account;
    private final BankDatabase bankDatabase;

    public ATM(Bank bank, BankDatabase bankDatabase) {
        this.bank = bank;
         this.bankDatabase = bankDatabase;
    }

    public void run() throws SQLException {
        System.out.println("Welcome to " + bank.getName() + " ATM at " + bank.getLocation());

        while (true) {
            account = login();

            if (account == null) {
                continue;
            }

            while (true) {
                System.out.println("\nWhat would you like to do?\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Logout\n");
                String choice = readInput();

                if (choice.equals("1")) {
                    checkBalance();
                } else if (choice.equals("2")) {
                    deposit();
                } else if (choice.equals("3")) {
                    withdraw();
                } else if (choice.equals("4")) {
                    logout();
                    //bankDatabase.updateAccount(account); // Update account balance in databas
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private Account login() throws SQLException {
        System.out.print("Please enter your Account Number: ");
        String name = readInput();
        System.out.print("Please enter your PIN: ");
        String pin = readInput();
        Account account = bank.getAccount(name, pin);
        

        if (account != null) {
            System.out.println("Login successful!");
            return account;
        }

        System.out.println("Invalid AccountNumber or PIN. Please try again.");
        return null;
    }

    private void logout() {
        System.out.println("Thank you for using our ATM. Goodbye!");
        account = null;
    }

    private void checkBalance() {
        KeyPad keyPad = new KeyPad(new Scanner(System.in));
        Screen screen = new Screen();
        CheckBalance checkBalance = new CheckBalance(screen, account);
        checkBalance.run();
    }

    private void deposit() throws SQLException {
        KeyPad keyPad = new KeyPad(new Scanner(System.in));
        Screen screen = new Screen();
        CashDispenser depositSlot = new CashDispenser();
        Deposit deposit = new Deposit(keyPad, screen, account, depositSlot);
        deposit.run();
       // bankDatabase.updateAccount(account);
    }

    private void withdraw() throws SQLException {
        KeyPad keyPad = new KeyPad(new Scanner(System.in));
        Screen screen = new Screen();
        Withdraw withdraw = new Withdraw(keyPad, screen, account);
        withdraw.run();
        //bankDatabase.updateAccount(account);
    }

    private String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}