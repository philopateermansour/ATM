/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectSoftware_ATM;
import java.sql.*;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Mark
 */

public class BankDatabase {
    Connection conn = null;
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/atm","root", "");
            System.out.print("Database is connected !");
            conn.close();
        }
        catch(Exception e) {
            System.out.print("Do not connect to DB - Error:"+e);
        }
    }
    public void addAccount(Account account) throws SQLException {
        PreparedStatement pstmt = this.conn.prepareStatement("INSERT INTO Account(AccountNumber,Balance, pin) VALUES (?, ?, ?)");
        pstmt.setString(1, account.getAccountNumber());
        pstmt.setString(2, account.getPin());
        pstmt.setDouble(3, account.getBalance());
        pstmt.executeUpdate();
        pstmt.close();
    }

    public Account getAccount(String accountNumber, String pin) throws SQLException {
        PreparedStatement pstmt = this.conn.prepareStatement("SELECT * FROM Account WHERE AccountNumber = ? AND pin = ?");
        pstmt.setString(1, accountNumber);
        pstmt.setString(2, pin);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String retrievedAccountNumber = rs.getString("AccountNumber");
            String retrievedPin = rs.getString("pin");
            double retrievedBalance = rs.getDouble("Balance");
            Account account = new Account(retrievedAccountNumber, retrievedPin, retrievedBalance);
            pstmt.close();
            return account;
        } else {
            pstmt.close();
            return null;
        }
    }

    public ArrayList<Account> getAllAccounts() throws SQLException {
        ArrayList<Account> accounts = new ArrayList<>();
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Account");

        while (rs.next()) {
            String accountNumber = rs.getString("AccountNumber");
            String pin = rs.getString("pin");
            double balance = rs.getDouble("Balance");
            Account account = new Account(accountNumber, pin, balance);
            accounts.add(account);
        }

        stmt.close();
        return accounts;
    }

    public void updateAccount(Account account) throws SQLException {
        PreparedStatement pstmt = this.conn.prepareStatement("UPDATE Account SET Balance = ? WHERE AccountNumber = ?");
        pstmt.setDouble(1, account.getBalance());
        pstmt.setString(2, account.getAccountNumber());
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void close() throws SQLException {
        this.conn.close();
    }
}







