package Iteration4;

import java.util.Scanner;

public class Shop {
    //Creation of a scanner class
    Scanner keyboardInput = new Scanner(System.in);

    public void shopMenu(Band band) {
        while (true) {
            System.out.println("\n" + "====== 🛒 SHOP 🛒 ======"
                    + "\n" + "This is the shop - Here you can buy/upgrade equipment"
                    + "\n" + "(Type the number of an item listed below, to show more details)"
                    + "\n" + "1 - Speakers " + "(Level 0)"
                    + "\n" + "2 - Equipment " + "(Level 0)"
                    + "\n" + "? - Stadium concert unlock" + "(Level ?)"
                    + "\n" + "? - Start a tour unlock" + "(Level ?)"
                    + "\n" + "0 - Back to main menu"
            );
            int userShopChoice = keyboardInput.nextInt(); //CHECK UP ON THIS
            if (userShopChoice == 1) {
                shopSpeakers(band);
            } else if (userShopChoice == 2) {
                shopEquipment(band);
            } else if (userShopChoice == 0) {
                break;
            } else {
                System.out.println("\n" + "Invalid command!");
            }
        }

    }

    public void shopSpeakers(Band band) {
    }

    public void shopEquipment(Band band) {
    }
}
