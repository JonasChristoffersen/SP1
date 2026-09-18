package Iteration4;

import java.util.Scanner;

public class Shop {
    //Creation of a scanner class
    Scanner keyboardInput = new Scanner(System.in);

    public void shopMenu(Band band, GamePrinter gamePrinter) {
        while (true) {
            gamePrinter.printShopMenu();
            int userShopChoice = keyboardInput.nextInt(); //CHECK UP ON THIS
            if (userShopChoice == 1) {
                shopSpeakers(band);
            } else if (userShopChoice == 2) {
                shopEquipment(band);
            } else if (userShopChoice == 0) {
                break;
            } else {
                gamePrinter.printInvalidCommandText();
            }
        }

    }

    public void shopSpeakers(Band band) {
    }

    public void shopEquipment(Band band) {
    }
}
