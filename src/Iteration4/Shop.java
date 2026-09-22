package Iteration4;

import java.util.Scanner;

public class Shop {
    //Variables for unlock logic
    private boolean startATourUnlocked = false;
    private boolean stadiumConcertUnlocked = false;
    private int equipmentShopLevel = 0;
    private int speakersShopLevel = 0;

    public void shopMenu(Band myBand, GamePrinter gamePrinter, Scanner keyboardInput, Shop shop) {
        while (true) {
            gamePrinter.printShopMenu(shop);
            int userShopChoice = keyboardInput.nextInt(); //CHECK UP ON THIS
            if (userShopChoice == 1) {
                shopSpeakers(myBand, gamePrinter);
            } else if (userShopChoice == 2) {
                shopEquipment(myBand, gamePrinter);
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

    public double equipmentPriceLogic() {
        switch (equipmentShopLevel) {
            case 0 -> {return 1300;}
            case 1 -> {return 3800;}
            case 2 -> {return 5200;}
            case 3 -> {return 7900;}
            case 4 -> {return 13000;}
            default -> {return 2147483647;} //Max value possible in java
        }
    }

    public double speakersPriceLogic() {
        switch (speakersShopLevel) {
            case 0 -> {return 1200;}
            case 1 -> {return 3700;}
            case 2 -> {return 5300;}
            case 3 -> {return 7900;}
            case 4 -> {return 11000;}
            default -> {return 2147483647;} //Max value possible in java
        }
    }

    public double getSpeakersBonus() {
        switch (speakersShopLevel) {
            case 0 -> {return 1.0;}
            case 1 -> {return 1.1;}
            case 2 -> {return 1.2;}
            case 3 -> {return 1.3;}
            case 4 -> {return 1.4;}
            case 5 -> {return 1.5;}
            default -> {return 0;}
        }
    }

    public double getEquipmentBonus() {
        switch (equipmentShopLevel) {
            case 0 -> {return 1.0;}
            case 1 -> {return 1.1;}
            case 2 -> {return 1.2;}
            case 3 -> {return 1.3;}
            case 4 -> {return 1.4;}
            case 5 -> {return 1.5;}
            default -> {return 0;}
        }
    }

    public String speakersPriceText() {
        if (speakersShopLevel <= 4) {
            return " $" + speakersPriceLogic();
        } else {
            return "";
        }
    }

    public String equipmentPriceText() {
        if (equipmentShopLevel <= 4) {
            return " $" + equipmentPriceLogic();
        } else {
            return "";
        }
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

    public int getSpeakersShopLevel() {
        return speakersShopLevel;
    }

    public int getEquipmentShopLevel() {
        return equipmentShopLevel;
    }

    public void shopSpeakers(Band myBand, GamePrinter gamePrinter) {
        if (speakersShopLevel == 0 && myBand.getBandCurrentBalance() >= speakersPriceLogic()) {
            myBand.spendMoney(speakersPriceLogic());
            speakersShopLevel++;
        } else if (speakersShopLevel == 1 && myBand.getBandCurrentBalance() >= speakersPriceLogic()) {
            myBand.spendMoney(speakersPriceLogic());
            speakersShopLevel++;
        } else if (speakersShopLevel == 2 && myBand.getBandCurrentBalance() >= speakersPriceLogic()) {
            myBand.spendMoney(speakersPriceLogic());
            speakersShopLevel++;
        } else if (speakersShopLevel == 3 && myBand.getBandCurrentBalance() >= speakersPriceLogic()) {
            myBand.spendMoney(speakersPriceLogic());
            speakersShopLevel++;
        } else if (speakersShopLevel == 4 && myBand.getBandCurrentBalance() >= speakersPriceLogic()) {
            myBand.spendMoney(speakersPriceLogic());
            speakersShopLevel++;
        } else {
            gamePrinter.printNotEnoughFounds();
        }
    }

    public void shopEquipment(Band myBand, GamePrinter gamePrinter) {
        if (equipmentShopLevel == 0 && myBand.getBandCurrentBalance() >= equipmentPriceLogic()) {
            myBand.spendMoney(equipmentPriceLogic());
            equipmentShopLevel++;
        } else if (equipmentShopLevel == 1 && myBand.getBandCurrentBalance() >= equipmentPriceLogic()) {
            myBand.spendMoney(equipmentPriceLogic());
            equipmentShopLevel++;
        } else if (equipmentShopLevel == 2 && myBand.getBandCurrentBalance() >= equipmentPriceLogic()) {
            myBand.spendMoney(equipmentPriceLogic());
            equipmentShopLevel++;
        } else if (equipmentShopLevel == 3 && myBand.getBandCurrentBalance() >= equipmentPriceLogic()) {
            myBand.spendMoney(equipmentPriceLogic());
            equipmentShopLevel++;
        } else if (equipmentShopLevel == 4 && myBand.getBandCurrentBalance() >= equipmentPriceLogic()) {
            myBand.spendMoney(equipmentPriceLogic());
            equipmentShopLevel++;
        } else {
            gamePrinter.printNotEnoughFounds();
        }
    }
}