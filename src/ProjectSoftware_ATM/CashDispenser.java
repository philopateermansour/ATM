/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectSoftware_ATM;

/**
 *
 * @author Mark
 */

public class CashDispenser {
    private static final int INITIAL_COUNT = 10000;
     private static final int MAX_LIMIT = 1000;
    private int count;
    private int limit;

    public CashDispenser() {
        this.count = INITIAL_COUNT;
        this.limit = MAX_LIMIT;
    }

    public boolean dispenseCash(int amount) {
        if (count >= amount) {
            count -= amount;
            return true;
        }
        return false;
    }
    
    public boolean dispenseCashd(int amount) {
        if (limit >= amount) {
            limit -= amount;
            return true;
        }
        return false;
    }
    
      public boolean isEnvelopeReceived() {
        return true;
    }
}
