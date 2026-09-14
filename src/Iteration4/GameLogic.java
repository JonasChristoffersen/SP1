package Iteration4;

import java.util.Scanner;

public class GameLogic {
    //Creation of a scanner class
    Scanner keyboardInput = new Scanner(System.in);

    //This class is thought to serve logics like if statements and so on regarding the game!

    //Band stats
    public void bandStats(Band band) {
        System.out.println("\n" + "====== Band profile ======"
                + "\n" + "Name: " + band.getBandName()
                + "\n" + "Genre: " + band.getBandMusicGenreChar() + " (" + band.getBandMusicGenre() + ")"
                + "\n" + "Fame level: " + band.getBandFameLevel()
                + "\n" + "Status: " + band.getStatusTitle(band.getBandFameLevel())
                + "\n" + "Fans: " + band.getBandCurrentFans() + "/" + band.bandMaxFans(band.getBandFameLevel()) + " (" + band.getFanPercentage() + "%)"
                + "\n" + "Fan base: " + band.getFanPercentage() + "% of venue capacity"
                + "\n" + "XP: " + band.getBandXP()
                + "\n" + "Money: $" + band.getBandCurrentBalance()
                + "\n" + "Active: " + band.isBandActive()
        );
    }

    public void startGame(Band band) {
        while (true) {
            System.out.println("""
                    
                    ====== BAND SIM ======
                    Great! Lets begin your journey to become a legend in the music industry!
                    (Type the number of an action listed below)
                    1 - Band stats
                    2 - Play a concert/tour
                    3 - Shop
                    0 - Exit game"""
            );
            int userGameChoice = keyboardInput.nextInt();
            if (userGameChoice == 1) {
                bandStats(band);
            } else if (userGameChoice == 2) {
                startConcert(band);
            } else if (userGameChoice == 3) {
                shop(band);
            } else if (userGameChoice == 0) {
                exitConfirmationLoop();
            } else {
                System.out.println("Invalid command!");
            }
        }
    }

    public void exitConfirmationLoop() {
        //Flush of keyboardInput
        keyboardInput.nextLine();
        while (true) {
            System.out.println("\n" + "Are you sure you want to exit the game?"
                    + "\n" + "(Y = Yes, exit the game) (N = No, i want to keep playing)"
            );
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


    public void startConcert(Band band) {
        System.out.println("\n" + band.getBandName() + " is setting up arrangements..."
                + "\n " + "What kind of event should they be looking for?"
                + "\n" + "1 - Small venue "
        );
    }

    public void venueUnlocked(Band band) {
        int[]


    }




    public void smallVenue(Band band) {
    }

    public void mediumVenue(Band band) {
    }

    public void largeVenue(Band band) {
    }

    public void festivalSmallStage(Band band) {
    }

    public void festivalMediumStage(Band band) {
    }

    public void festivalMainStage(Band band) {
    }

    public void shop(Band band) {
        while (true) {
            System.out.println("\n" + "====== SHOP ======"
                    + "\n" + "This is the shop - Here you can buy/upgrade equipment"
                    + "\n" + "(Type the number of an item listed below, to show more details)"
                    + "\n" + "1 - Speakers " + "(Level 0)"
                    + "\n" + "2 - Equipment " + "(Level 0)"
                    + "\n" + "0 - Back to main menu"
            );
            int userShopChoice = keyboardInput.nextInt();
            if (userShopChoice == 1) {
                shopSpeakers();
            } else if (userShopChoice == 2) {
                shopEquipment();
            } else if (userShopChoice == 0) {
                break;
            } else {
                System.out.println("\n" + "Invalid command!");
            }
        }

    }

    public void shopSpeakers() {
    }

    public void shopEquipment() {

    }
}
