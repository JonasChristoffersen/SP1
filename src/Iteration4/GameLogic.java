package Iteration4;

import java.util.Scanner;

public class GameLogic {
    private int firstTimerCount = 0;
    public boolean isFirstTimer() {
        if (firstTimerCount == 0) {
            firstTimerCount++;
            return true;
        } else {
            return false;
        }
    }

    public boolean isAdmin(Band myBand) {
        if (myBand.getBandName().equals("Admin")) {
            return true;
        } else {
            return false;
        }
    }

    public void gameMenuMessages(GamePrinter gamePrinter, Band myBand) {
        if (isAdmin(myBand)) {
            gamePrinter.printAdminMainMenu();
        } else if (isFirstTimer()) {
            gamePrinter.printFirstTimerMainMenu();
        } else {
            gamePrinter.printMainMenu();
        }
    }

    public void shopAdminMenu(Band myBand, GamePrinter gamePrinter, Scanner keyboardInput) {
        while (true) {
            gamePrinter.printAdminSetterMenu(myBand);
            int userAdminMenuChoice = keyboardInput.nextInt();
            keyboardInput.nextLine();
            if (userAdminMenuChoice == 1) {
                gamePrinter.printAdminSetValueQuestion();
                String userInputBandName = keyboardInput.nextLine();
                myBand.setBandName(userInputBandName);
                gamePrinter.printAdminValuesIsChanged(userInputBandName);
            } else if (userAdminMenuChoice == 2) {
                gamePrinter.printAdminSetValueQuestion();
                int userInputFameLevel = keyboardInput.nextInt();
                myBand.setBandFameLevel(userInputFameLevel);
                gamePrinter.printAdminValuesIsChanged(myBand.getBandFameLevel() + ""); //Set +"" to make this a string
            } else if (userAdminMenuChoice == 3) {
                gamePrinter.printAdminSetValueQuestion();
                int userInputFans = keyboardInput.nextInt();
                myBand.setBandCurrentFans(userInputFans);
                gamePrinter.printAdminValuesIsChanged(myBand.getBandCurrentFans() + ""); //Set +"" to make this a string
            } else if (userAdminMenuChoice == 4) {
                gamePrinter.printAdminSetValueQuestion();
                int userInputXP = keyboardInput.nextInt();
                myBand.setBandXP(userInputXP);
                gamePrinter.printAdminValuesIsChanged(myBand.getBandXP() + ""); //Set +"" to make this a string
            } else if (userAdminMenuChoice == 5) {
                gamePrinter.printAdminSetValueQuestion();
                double userInputBalance = keyboardInput.nextDouble();
                myBand.setBandCurrentBalance(userInputBalance);
                gamePrinter.printAdminValuesIsChanged(userInputBalance + "");
            } else if (userAdminMenuChoice == 0) {
                break;
            } else {
                gamePrinter.printInvalidCommandText();
            }
        }
    }

    public void exitConfirmationLoop(GamePrinter gamePrinter, Scanner keyboardInput) {
        //Flush of keyboardInput
        keyboardInput.nextLine();
        while (true) {
            gamePrinter.printExitConfirmationText();
            String userExitInput = keyboardInput.nextLine();
            if (userExitInput.equalsIgnoreCase("y")) {
                gamePrinter.printThanksForPlaying();
                System.exit(0);
            } else if (userExitInput.equalsIgnoreCase("n")) {
                break;
            } else {
                gamePrinter.printInvalidCommandText();
            }
        }
    }

    public void concertMenu(Band myBand, Band rivalBand, VenueLogic venueLogic, RandomEvents randomEvents,
                            GamePrinter gamePrinter, GameLogic gameLogic, Scanner keyboardInput, Shop shop) {
        while (true) {
            //Print of options
            gamePrinter.printConcertMenu(myBand, gameLogic, shop);

            //BE AWARE THAT LOGIC FOR LOCKED CONCERTS THAT NEEDS TO BE BOUGHT IN SHOP IS NOT CREATED/IMPLEMENTED YET!
            int concertUserChoice = keyboardInput.nextInt();
            if (concertUserChoice == 1 && isVenueUnlocked(myBand, 1)) {
                venueLogic.smallVenue(myBand, rivalBand, shop);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 2 && isVenueUnlocked(myBand, 2)) {
                venueLogic.mediumVenue(myBand, rivalBand, shop);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 3 && isVenueUnlocked(myBand, 3)) {
                venueLogic.largeVenue(myBand, rivalBand, shop);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 4 && shop.isStadiumConcertUnlocked()) {
                venueLogic.stadiumConcert(myBand, rivalBand, shop);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 5 && isVenueUnlocked(myBand, 2)) {
                venueLogic.festivalSmallStage(myBand, rivalBand, shop);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 6 && isVenueUnlocked(myBand, 3)) {
                venueLogic.festivalMediumStage(myBand, rivalBand, shop);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 7 && isVenueUnlocked(myBand, 4)) {
                venueLogic.festivalLargeStage(myBand, rivalBand, shop);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 8 && isVenueUnlocked(myBand, 5)) {
                venueLogic.festivalMainStage(myBand, rivalBand, shop);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 9 && shop.isStatATourUnlocked()) {
                venueLogic.showTourMenu(myBand, rivalBand, gamePrinter, venueLogic, keyboardInput, shop);
                //executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter); //This is not correctly implemented here!
            } else if (concertUserChoice == 0) {
                break;
            } else {
                gamePrinter.printNotUnlockedOrInvalidText();
            }
        }
    }

    public void executeRandomEvent(Band myBand, Band rivalBand, RandomEvents randomEvents, GamePrinter gamePrinter) {
        randomEvents.randomEventLogic(rivalBand, gamePrinter);
        gamePrinter.printRandomEvent(myBand, randomEvents, gamePrinter);
        myBand.isActive(gamePrinter);
    }

    public String getVenueStatus(boolean isVenueUnlocked) {
        if (isVenueUnlocked) {
            return "Unlocked ✅";
        } else {
            return "Locked 🔒";
        }
    }

    public String getStadiumStatus(Shop shop) {
        if (shop.isStadiumConcertUnlocked()) {
            return "(Unlocked ✅)";
        } else {
            return "(Locked 🔒 - Visit the shop)";
        }
    }

    public String getStartATourStatus(Shop shop) {
        if (shop.isStatATourUnlocked()) {
            return "(Unlocked ✅)";
        } else {
            return "(Locked 🔒 - Visit the shop)";
        }
    }

    public boolean isVenueUnlocked(Band myBand, int requiredFameLevel) {
        return myBand.getBandFameLevel() >= requiredFameLevel;
    }
}
