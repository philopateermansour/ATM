/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectSoftware_ATM;

/**
 *
 * @author Mark
 */
public class Withdraw extends Transaction {
    private final KeyPad keyPad;
    private final Screen screen;
     private final CashDispenser depositSlot;

    public Withdraw(KeyPad keyPad, Screen screen, Account account) {
        super(account);
        this.keyPad = keyPad;
        this.screen = screen;
        this.depositSlot = new CashDispenser();
    }

    @Override
    // ocl applied 1.check if the amount to be withdrawn is less than the amount available(10000)
    // 2.check if the Withdraw slot is working to withdraw money
    public void run() {
        double amount = keyPad.readAmount();
        boolean success = false;
        if (depositSlot.dispenseCash((int) amount)) {
             if (depositSlot.isEnvelopeReceived()) {
               success = withdraw(amount);
             }  
        } else {
         screen.displayMessage("Unable to Withdraw,");
        }
       

        if (success) {
            screen.displayMessage("Withdrawal successful. New balance: $" + String.format("%.2f", account.getBalance()));
        } else {
            screen.displayMessage("Insufficient funds.");
        }
    }

    private boolean withdraw(double amount) {
        if (amount > account.getBalance()) {
            return false;
        }
        account.setBalance(account.getBalance() - amount);
        return true;
    }
}



