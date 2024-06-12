/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectSoftware_ATM;

/**
 *
 * @author Mark
 */
public class Deposit extends Transaction {
    private final KeyPad keyPad;
    private final Screen screen;
    private final CashDispenser depositSlot;

    public Deposit(KeyPad keyPad, Screen screen, Account account, CashDispenser depositSlot) {
        super(account);
        this.keyPad = keyPad;
        this.screen = screen;
        this.depositSlot = depositSlot;
    }

    @Override
     // ocl applied 1.check if the amount to be Deposited is less than the amount Granted(1000)
    // 2.check if the deposit slot is working to Take money
    public void run() {
        double amount = keyPad.readAmount();
        if (depositSlot.dispenseCashd((int) amount)) {
             if (depositSlot.isEnvelopeReceived()) {
                   deposit(amount);     
                   screen.displayMessage("Deposit successful. New balance: $" + account.getBalance());
             }  
        } else {
         screen.displayMessage("Unable to deposit funds,Exceeded Granted Limit.");
        }
    }

    private void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
    }
}
