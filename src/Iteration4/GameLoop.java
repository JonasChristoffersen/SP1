package Iteration4;

import java.util.Scanner;

public class GameLoop {
    //Classes
    private final Scanner keyboardInput;
    private final GameLogic gameLogic;
    private final Band myBand;
    private final Band rivalBand;
    private final GamePrinter gamePrinter;
    private final VenueLogic venueLogic;
    private final Shop shop;
    private final RandomEvents randomEvents;


    public GameLoop(Scanner keyboardInput, GameLogic gameLogic, GamePrinter gamePrinter, VenueLogic venueLogic,
                    Shop shop, RandomEvents randomEvents, Band myBand, Band rivalBand) {
        this.keyboardInput = keyboardInput;
        this.gameLogic = gameLogic;
        this.gamePrinter = gamePrinter;
        this.venueLogic = venueLogic;
        this.shop = shop;
        this.randomEvents = randomEvents;
        this.myBand = myBand;
        this.rivalBand = rivalBand;
    }

    public void welcomeMessage() {
        //First ever print user will see after running the program
        gamePrinter.printWelcomeMessage();
        //Read input from user + logic regarding users choice
        while (true) {
            //First choice user is presented with
            gamePrinter.printDoUserWantToRenameBand();
            String userAnswer = keyboardInput.nextLine();
            //Logic for renaming the band or not
            if (userAnswer.equalsIgnoreCase("y")) {
                gamePrinter.printRenameBandQuestion();
                String bandRename = keyboardInput.nextLine();
                myBand.setBandName(bandRename);
                bandGenreChoice();
                break;
            } else if (userAnswer.equalsIgnoreCase("n")) {
                rivalBand.setBandName("Dire Straits");
                break;
            } else {
                gamePrinter.printInvalidCommandText();
            }
        }
    }

    public void bandGenreChoice() {
        while (true) {
            //User gets choose band using the scanner object
            gamePrinter.printGenreBandQuestion();
            String bandGenreChoice = keyboardInput.nextLine();
            if (bandGenreChoice.equalsIgnoreCase("rock")
                    || bandGenreChoice.equalsIgnoreCase("electronic")
                    || bandGenreChoice.equalsIgnoreCase("pop")
                    || bandGenreChoice.equalsIgnoreCase("hiphop")) {
                myBand.setBandMusicGenre(bandGenreChoice);
                break;
            } else {
                gamePrinter.printInvalidCommandText();
            }
        }
    }

    public void showStartMenu() {
        while (true) {
            gamePrinter.printStartMenu();
            int mainMenuChoice = keyboardInput.nextInt();
            if (mainMenuChoice == 1) {
                startGame();
            } else if (mainMenuChoice == 2) {
                gamePrinter.printHelpAndInfo();
            } else if (mainMenuChoice == 0) {
                System.exit(0);
            } else {
                gamePrinter.printInvalidCommandText();
            }
        }
    }

    public void startGame() {
        while (true) {
            gameLogic.gameMenuMessages(gamePrinter);
            int userGameChoice = keyboardInput.nextInt();
            if (userGameChoice  == 1) {
                gamePrinter.printBandStats(myBand);
            } else if (userGameChoice  == 2) {
                gameLogic.concertMenu(myBand, rivalBand, venueLogic, randomEvents, gamePrinter,
                        gameLogic, keyboardInput, shop);
            } else if (userGameChoice  == 3) {
                shop.shopMenu(myBand, gamePrinter, keyboardInput, shop);
            } else if (userGameChoice == 4) {
                gamePrinter.printCompareBandStats(myBand, rivalBand);
            } else if (userGameChoice == 5) {
                gamePrinter.printHelpAndInfo();
            } else if (userGameChoice  == 0) {
                gameLogic.exitConfirmationLoop(gamePrinter, keyboardInput);
            } else {
                gamePrinter.printInvalidCommandText();
            }
        }
    }
}
