/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectSoftware_ATM;

/**
 *
 * @author Mark
 */
public class CheckBalance extends Transaction {
    private final Screen screen;

    public CheckBalance(Screen screen, Account account) {
        super(account);
        this.screen = screen;
    }

    @Override
    public void run() {
        screen.displayMessage(account.toString());
        screen.displayMessage("Current balance: $" + account.getBalance());
    }
}