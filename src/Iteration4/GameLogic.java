package Iteration4;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    //Creation of a scanner class
    Scanner keyboardInput = new Scanner(System.in);

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

    public void exitConfirmationLoop(GamePrinter gamePrinter) {
        //Flush of keyboardInput
        keyboardInput.nextLine();

        while (true) {
            gamePrinter.printExitConfirmationText();
            String userExitInput = keyboardInput.nextLine();
            if (userExitInput.equalsIgnoreCase("y")) {
                System.out.println("Thanks for playing! See you soon.");
                System.exit(0);
            } else if (userExitInput.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Invalid command!");
            }
        }
    }

    public void playConcert(Band myBand, Band rivalBand, VenueLogic venueLogic, RandomEvents randomEvents,
                            GamePrinter gamePrinter, GameLogic gameLogic) {
        while (true) {
            //Print of options
            gamePrinter.printConcertMenu(myBand, gameLogic);

            //BE AWARE THAT LOGIC FOR LOCKED CONCERTS THAT NEEDS TO BE BOUGHT IN SHOP IS NOT CREATED/IMPLEMENTED YET!
            int concertUserChoice = keyboardInput.nextInt();
            if (concertUserChoice == 1 && isVenueUnlocked(myBand, 1)) {
                venueLogic.smallVenue(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 2 && isVenueUnlocked(myBand, 2)) {
                venueLogic.mediumVenue(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 3 && isVenueUnlocked(myBand, 3)) {
                venueLogic.largeVenue(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 4 && isVenueUnlocked(myBand, 1000)) { //SHOP LOGIC MISSING!
                venueLogic.stadiumConcert(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 5 && isVenueUnlocked(myBand, 2)) {
                venueLogic.festivalSmallStage(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 6 && isVenueUnlocked(myBand, 3)) {
                venueLogic.festivalMediumStage(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 7 && isVenueUnlocked(myBand, 4)) {
                venueLogic.festivalLargeStage(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 8 && isVenueUnlocked(myBand, 5)) {
                venueLogic.festivalMainStage(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 9 && isVenueUnlocked(myBand, 1000)) { //SHOP LOGIC MISSING!
                venueLogic.startTour(myBand, rivalBand);
                executeRandomEvent(myBand, rivalBand, randomEvents, gamePrinter);
            } else if (concertUserChoice == 0) {
                break;
            } else {
                System.out.println("\n" + "Not unlocked yet or Invalid command!");
            }
        }
    }

    public void executeRandomEvent(Band myBand, Band rivalBand, RandomEvents randomEvents, GamePrinter gamePrinter) {
        randomEvents.randomEventLogic(rivalBand);
        gamePrinter.printRandomEvent(myBand, randomEvents);
    }

    public String getVenueStatus(boolean isVenueUnlocked) {
        if (isVenueUnlocked) {
            return "Unlocked ✅";
        } else {
            return "Locked 🔒";
        }
    }

    public boolean isVenueUnlocked(Band myBand, int requiredFameLevel) {
        return myBand.getBandFameLevel() >= requiredFameLevel;
    }
}
