/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectSoftware_ATM;

/**
 *
 * @author Mark
 */
public class Account {
    private final String AccountNumber;
    private final String pin;
    private double balance;

    public Account(String AccountNumber, String pin, double balance) {
        this.AccountNumber = AccountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance=balance;
    }
}