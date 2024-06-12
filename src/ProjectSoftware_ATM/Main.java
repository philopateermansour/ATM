/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ProjectSoftware_ATM;
import java.sql.SQLException;
/**
 *
 * @author Mark
 */
// SOLID Principle: Single Responsibility Principle

public class Main {
public static void main(String[] args) {
    try {
        BankDatabase bankDatabase = new BankDatabase();
        Bank bank = new Bank("QNB", "Helwan ", bankDatabase);

       bank.addAccount(new Account("202000538", "1234", 10000));
       bank.addAccount(new Account("202000690", "5678", 10000));
        ATM atm = new ATM(bank, bankDatabase);
        atm.run();

    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
}

}

