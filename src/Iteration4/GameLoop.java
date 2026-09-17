package Iteration4;

import java.util.Scanner;

public class GameLoop {
    //Creation of a scanner class
    private Scanner keyboardInput;

    //Needed classes
    private GameLogic gameLogic;
    private Band myBand;
    private Band rivalBand;
    private GamePrinter gamePrinter;

    public GameLoop(Scanner keyboardInput, GameLogic gameLogic, GamePrinter gamePrinter, Band myBand, Band rivalBand) {
        this.keyboardInput = keyboardInput;
        this.gameLogic = gameLogic;
        this.myBand = myBand;
        this.rivalBand = rivalBand;
        this.gamePrinter = gamePrinter;
    }

    //Invalid command text method
    public void invalidCommandText() {
        System.out.println("\n" + "Invalid command!");
    }

    public void welcomeMessage() {
        //First ever print user will see after running the program
        gamePrinter.printWelcomeMessage();

        //Read input from user + logic regarding users choice
        while (true) {
            //First choice user is presented with
            System.out.println("Do you wish to create your own band, or roll with a default option?"
                            + "\n" + "(Y = Yes, i want to create my own band) (N = No, just roll the default option)"
            );
            String userAnswer = keyboardInput.nextLine();
            //Logic for renaming the band or not
            if (userAnswer.equalsIgnoreCase("y")) {
                System.out.println("\n" + "What do you want to name your band?");
                String bandRename = keyboardInput.nextLine();
                myBand.setBandName(bandRename);
                bandGenreChoice();
                break;
            } else if (userAnswer.equalsIgnoreCase("n")) {
                break;
            } else {
                invalidCommandText();
            }
        }
    }

    public void bandGenreChoice() {
        while (true) {
            System.out.println("\n" + "What do genre should your band play?"
                    + "\n" + "You can choose between: Rock, Electronic, Pop and Hiphop"
            );
            String bandGenreChoice = keyboardInput.nextLine();
            if (bandGenreChoice.equalsIgnoreCase("rock")
                    || bandGenreChoice.equalsIgnoreCase("electronic")
                    || bandGenreChoice.equalsIgnoreCase("pop")
                    || bandGenreChoice.equalsIgnoreCase("hiphop")) {
                myBand.setBandMusicGenre(bandGenreChoice);
                break;
            } else {
                invalidCommandText();
            }
        }
    }
        //showMainMenu
    public void showMainMenu() {
        while (true) {

            //Exception handling
            //Local variable set to 50, to make sure it won't hit any if statement
            System.out.println("""
                    
                    ====== 🔶 MAIN MENU 🔶 ======
                    Are you ready to start your journey?
                    (Type the number of an action listed below)
                    1 - 🚀 Start game
                    2 - 🟡 Help/Info (NOT CREATED YET)
                    0 - ❌ Exit game"""
            );
            int mainMenuChoice = keyboardInput.nextInt();
            if (mainMenuChoice == 1) {
                gameLogic.startGame(myBand, rivalBand);
            } else if (mainMenuChoice == 0) {
                System.exit(0);
            } else {
                invalidCommandText();
            }
        }
    }
}
