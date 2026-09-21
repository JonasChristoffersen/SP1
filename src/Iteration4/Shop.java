package Iteration4;

import java.util.Scanner;

public class Shop {
    //Variables for unlock logic
    private boolean startATourUnlocked = false;
    private boolean stadiumConcertUnlocked = false;

    public void shopMenu(Band myBand, GamePrinter gamePrinter, Scanner keyboardInput, Shop shop) {
        while (true) {
            gamePrinter.printShopMenu(shop);
            int userShopChoice = keyboardInput.nextInt(); //CHECK UP ON THIS
            if (userShopChoice == 1) {
                shopSpeakers(myBand);
            } else if (userShopChoice == 2) {
                shopEquipment(myBand);
            } else if (userShopChoice == 3) {
                if (!isStadiumConcertUnlocked()) {
                    if (myBand.getBandCurrentBalance() >= getStadiumConcertUnlockPrice()) {
                        myBand.spendMoney(getStadiumConcertUnlockPrice());
                        unlockStadiumConcert();
                        gamePrinter.printStadiumConcertUnlocked();
                    } else {
                        gamePrinter.printNotEnoughFounds();
                    }
                } else {
                    gamePrinter.printAlreadyUnlocked();
                }
            } else if (userShopChoice == 4) {
                if (!isStatATourUnlocked()) {
                    if (myBand.getBandCurrentBalance() >= getStatATourUnlockPrice()) {
                        myBand.spendMoney(getStatATourUnlockPrice());
                        unlockStartATour();
                        gamePrinter.printStartATourUnlocked();
                    } else {
                        gamePrinter.printNotEnoughFounds();
                    }
                } else {
                    gamePrinter.printAlreadyUnlocked();
                }
            } else if (userShopChoice == 0) {
                break;
            } else {
                gamePrinter.printInvalidCommandText();
            }
        }
    }

    public double getStadiumConcertUnlockPrice() {
        return 10000;
    }

    public double getStatATourUnlockPrice() {
        return 25000;
    }

    public void unlockStartATour() {
        startATourUnlocked = true;
    }

    public void unlockStadiumConcert() {
        stadiumConcertUnlocked = true;
    }

    public boolean isStatATourUnlocked() {
        return startATourUnlocked;
    }

    public boolean isStadiumConcertUnlocked() {
        return stadiumConcertUnlocked;
    }

    public String stadiumUnlockShopText() {
        if (isStadiumConcertUnlocked()) {
            return "✅ already purchased!";
        } else {
            return "$" + getStadiumConcertUnlockPrice() + " 🔒";
        }
    }

    public String startATourShopText() {
        if (isStatATourUnlocked()) {
            return "✅ already purchased!";
        } else {
            return "$" + getStatATourUnlockPrice() + " 🔒";
        }
    }

    public void shopSpeakers(Band band) {

    }

    public void shopEquipment(Band band) {
    }
}