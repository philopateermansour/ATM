/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectSoftware_ATM;

import java.util.Scanner;

/**
 *
 * @author Mark
 */
public class KeyPad {
    private final Scanner scanner;

    public KeyPad(Scanner scanner) {
        this.scanner = scanner;
    }

    public double readAmount() {
        System.out.print("Please enter an amount: ");
        return scanner.nextDouble();
    }
}