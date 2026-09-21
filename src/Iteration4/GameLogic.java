package Iteration4;

import java.util.Scanner;

public class GameLogic {
    private int count = 0;
    public boolean isFirstTimer() {
        if (count == 0) {
            count++;
            return true;
        } else {
            return false;
        }
    }

    public void gameMenuMessages(GamePrinter gamePrinter) {
        if (isFirstTimer()) {
            gamePrinter.printFirstTimerMainMenu();
        } else {
            gamePrinter.printMainMenu();
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
                venueLogic.smallVenue(myBand, rivalBand);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 2 && isVenueUnlocked(myBand, 2)) {
                venueLogic.mediumVenue(myBand, rivalBand);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 3 && isVenueUnlocked(myBand, 3)) {
                venueLogic.largeVenue(myBand, rivalBand);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 4 && shop.isStadiumConcertUnlocked()) { //TODO: FIXER DEN NU!
                venueLogic.stadiumConcert(myBand, rivalBand);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 5 && isVenueUnlocked(myBand, 2)) {
                venueLogic.festivalSmallStage(myBand, rivalBand);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 6 && isVenueUnlocked(myBand, 3)) {
                venueLogic.festivalMediumStage(myBand, rivalBand);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 7 && isVenueUnlocked(myBand, 4)) {
                venueLogic.festivalLargeStage(myBand, rivalBand);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 8 && isVenueUnlocked(myBand, 5)) {
                venueLogic.festivalMainStage(myBand, rivalBand);
                gamePrinter.printSingleConcert(myBand, venueLogic);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 9 && shop.isStatATourUnlocked()) { //TODO: SHOP LOGIC MISSING!
                venueLogic.showTourMenu(myBand, rivalBand, gamePrinter, venueLogic, keyboardInput);
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
