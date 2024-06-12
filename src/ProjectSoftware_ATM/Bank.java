/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectSoftware_ATM;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mark
 */
public class Bank {
    private final String name;
    private final String location;
    private final ArrayList<Account> accounts;
    private final BankDatabase bankDatabase;

    public Bank(String name, String location, BankDatabase bankDatabase) {
        this.name = name;
        this.location = location;
        this.accounts = new ArrayList<>();
        this.bankDatabase = bankDatabase;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void addAccount(Account account) throws SQLException {
         //bankDatabase.addAccount(account);
        accounts.add(account);
        System.out.println("Account Number " + account.getAccountNumber() + " has been created.");
}

public Account getAccount(String AccountNumber, String pin) throws SQLException {
        //return bankDatabase.getAccount(AccountNumber, pin);
    
    return accounts.stream()
            .filter(account -> account.getAccountNumber().equals(AccountNumber) && account.getPin().equals(pin))
            .findFirst().orElse(null);
}
}

