/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectSoftware_ATM;

/**
 *
 * @author Mark
 */
public abstract class Transaction {
    protected final Account account;

    public Transaction(Account account) {
        this.account = account;
    }

    public abstract void run();
}
