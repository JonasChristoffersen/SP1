package Iteration4;

import java.util.Scanner;

public class GameLoop {
    //Creation of a scanner class
    Scanner keyboardInput = new Scanner(System.in);

    //GameLogic class
    GameLogic gameLogic = new GameLogic();

    //Invalid command text method
    public void invalidCommandText() {
        System.out.println("\n" + "Invalid command!" + "\n");
    }

    public void welcomeMessage(Band band) {
        //First ever print user will see after running the program
        System.out.println("""
                
                ╻ ╻┏━╸╻  ┏━╸┏━┓┏┳┓┏━╸   ╺┳╸┏━┓   ┏┓ ┏━┓┏┓╻╺┳┓   ┏━┓╻┏┳┓╻\s
                ┃╻┃┣╸ ┃  ┃  ┃ ┃┃┃┃┣╸     ┃ ┃ ┃   ┣┻┓┣━┫┃┗┫ ┃┃   ┗━┓┃┃┃┃╹\s
                ┗┻┛┗━╸┗━╸┗━╸┗━┛╹ ╹┗━╸    ╹ ┗━┛   ┗━┛╹ ╹╹ ╹╺┻┛   ┗━┛╹╹ ╹╹\s
                ╺━╸╺━╸╺━╸╺━╸╺━╸╺━╸╺━╸╺━╸╺━╸╺━╸╺━╸╺━╸╺━╸╺━╸╺━╸╺━╸╺━╸╺━╸╺━
                """
        );

        //Read input from user + logic regarding users choice
        while (true) {
            //First choice user is presented with
            System.out.println("Do you wish to choose the name of your band, or roll with a default option?"
                            + "\n" + "(Y = Yes, i want to choose my own name) (N = No, just roll the default name)"
            );
            String userAnswer = keyboardInput.nextLine();
            //Logic for renaming the band or not
            if (userAnswer.equalsIgnoreCase("y")) {
                System.out.println("\n" + "What do you want to name your band?");
                String bandRename = keyboardInput.nextLine();
                band.setBandName(bandRename);
                break;
            } else if (userAnswer.equalsIgnoreCase("n")) {
                break;
            } else {
                invalidCommandText();
            }
        }
    }

    public void showMainMenu(Band band) {
        while (true) {
            System.out.println("""
                    
                    ====== MAIN MENU ======
                    What do you wanna do next?
                    (Type the number of an action listed below)
                    1 - Band stats
                    2 - Start game
                    3 - Shop
                    0 - Exit game"""
            );
            int mainMenuChoice = keyboardInput.nextInt();
            if (mainMenuChoice == 1) {
                gameLogic.bandStats(band);
            } else if (mainMenuChoice == 2) {
                gameLogic.startGame(band);
            } else if (mainMenuChoice == 3) {
                gameLogic.shop(band);
            } else if (mainMenuChoice == 0) {
                System.exit(0);
            } else {
                invalidCommandText();
            }
        }
    }


    //GAME OVER text method
    public void gameOver() {
        System.out.println("""
                ┏━╸┏━┓┏┳┓┏━╸   ┏━┓╻ ╻┏━╸┏━┓╻
                ┃╺┓┣━┫┃┃┃┣╸    ┃ ┃┃┏┛┣╸ ┣┳┛╹
                ┗━┛╹ ╹╹ ╹┗━╸   ┗━┛┗┛ ┗━╸╹┗╸╹
                """
        );
        System.exit(0);
    }
}
