package Iteration4;

import java.util.Scanner;

public class Shop {

    public void shopMenu(Band myBand, GamePrinter gamePrinter, Scanner keyboardInput, Shop shop) {
        while (true) {
            gamePrinter.printShopMenu(shop);
            int userShopChoice = keyboardInput.nextInt(); //CHECK UP ON THIS
            if (userShopChoice == 1) {
                shopSpeakers(myBand);
            } else if (userShopChoice == 2) {
                shopEquipment(myBand);
            } else if (userShopChoice == 0) {
                break;
            } else {
                gamePrinter.printInvalidCommandText();
            }
        }
    }

    public int getStadiumConcertUnlockPrice() {
        return 10000;
    }

    public int getStatATourUnlockPrice() {
        return 25000;
    }

    public void shopSpeakers(Band band) {

    }

    public void shopEquipment(Band band) {
    }

}
