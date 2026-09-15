package Iteration4;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class GameLogic {
    //Creation of a scanner class
    Scanner keyboardInput = new Scanner(System.in);

    //Needed class
    VenueLogic venueLogic = new VenueLogic();

    //This class is thought to serve logics like if statements and so on regarding the game!

    //Band stats
    public void bandStats(Band band) {
        System.out.println("\n" + "====== 📝 Band profile 📝 ======"
                + "\n" + "Name: " + band.getBandName()
                + "\n" + "Genre: " + band.getBandMusicGenreChar() + " (" + band.getBandMusicGenre() + ")"
                + "\n" + "Fame level: " + band.getBandFameLevel()
                + "\n" + "Status: " + band.getStatusTitle(band.getBandFameLevel())
                + "\n" + "Fans: " + band.getBandCurrentFans() + "/" + band.bandMaxFans(band.getBandFameLevel())
                + " (" + band.getFanPercentage() + "%)"
                + "\n" + "Fan base: " + band.getFanPercentage() + "% of venue capacity"
                + "\n" + "XP: " + band.getBandXP()
                + "\n" + "Money: $" + band.getBandCurrentBalance()
                + "\n" + "Active: " + band.isBandActive()
        );
    }

    public void startGame(Band band) {
        while (true) {
            if (isFirstTimer()) {
                firstTimerMessage();
            } else {
                standardGameMenu();
            }

            int userGameChoice = keyboardInput.nextInt();
            if (userGameChoice == 1) {
                bandStats(band);
            } else if (userGameChoice == 2) {
                playConcert(band);
            } else if (userGameChoice == 3) {
                shop(band);
            } else if (userGameChoice == 0) {
                exitConfirmationLoop();
            } else {
                System.out.println("Invalid command!");
            }
        }
    }

    int count = 0;
    //Implement logic for text that will be displayed first time you open the game!
    //It could be done with a local count variable, that got count++;
    //The method could be created as boolean
    public boolean isFirstTimer() {
        if (count == 0) {
            count++;
            return true;
        } else {
            return false;
        }
    }

    public void firstTimerMessage() {
        System.out.println("""
                    
                    ====== 🚀 BAND SIM 🚀 ======
                    Your journey to becoming a legendary band starts here!
                    Build your reputation, grow your fanbase, earn money and gain experience by 
                    playing concerts and upgrading your equipment.
                    Keep an eye on your Fame Level — the more famous you become, the bigger 
                    opportunities will become available.
                    (Type the number of an action listed below)
                    1 - 📝 Band stats
                    2 - 🎸 Play a concert/tour
                    3 - 🛒 Shop
                    0 - ❌ Exit game"""
        );
    }

    public void standardGameMenu() {
        System.out.println("""
                    
                    ====== 🎵 BAND SIM 🎵 ======
                    (Type the number of an action listed below)
                    1 - 📝 Band stats
                    2 - 🎸 Play a concert/tour
                    3 - 🛒 Shop
                    0 - ❌ Exit game"""
        );
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

    public void playConcert(Band band) {
        while (true) {
            //Print of options
            System.out.println("====== 🎸 PLAY A CONCERT/TOUR 🎸 ======"
                    + "\n" + band.getBandName() + " is setting up arrangements..."
                    + "\n" + "What kind of event should they be looking for?"
                    + "\n" + "(Type the number of an action listed below)"
                    + "\n" + "1 - Small venue (Unlocked ✅ - Fame level 1)"
                    + "\n" + "2 - Medium Venue (" + getVenueStatus(isVenueUnlocked(band, 2)) + " - Fame level 2)"
                    + "\n" + "3 - Large Venue (" + getVenueStatus(isVenueUnlocked(band, 3)) + " - Fame level 3)"
                    + "\n" + "4 - Stadium concert (" + "Locked 🔒" + " - Visit the shop)"
                    + "\n" + "5 - Festival small stage (" + getVenueStatus(isVenueUnlocked(band, 3)) + " - Fame level 2)"
                    + "\n" + "6 - Festival medium stage (" + getVenueStatus(isVenueUnlocked(band, 4)) + " - Fame level 3)"
                    + "\n" + "7 - Festival Large Stage (" + getVenueStatus(isVenueUnlocked(band, 4)) +" - Fame level 4)"
                    + "\n" + "8 - Festival main stage (" + getVenueStatus(isVenueUnlocked(band, 5)) + " - Fame level 5)"
                    + "\n" + "9 - Start a tour (" + "Locked 🔒" + " - Visit the shop)"
                    + "\n" + "0 - Cancel, go back to main menu"
            );

            //BE AWARE THAT LOGIC FOR LOCKED CONCERTS THAT NEEDS TO BE BOUGHT IN SHOP IS NOT CREATED/IMPLEMENTED YET!
            int concertUserChoice = keyboardInput.nextInt();
            if (concertUserChoice == 1 && isVenueUnlocked(band, 1)) {
                venueLogic.smallVenue(band);
            } else if (concertUserChoice == 2 && isVenueUnlocked(band, 2)) {
                venueLogic.mediumVenue(band);
            } else if (concertUserChoice == 3 && isVenueUnlocked(band, 3)) {
                venueLogic.largeVenue(band);
            } else if (concertUserChoice == 4 && isVenueUnlocked(band, 1000)) { //SHOP LOGIC MISSING!
                venueLogic.stadiumConcert(band);
            } else if (concertUserChoice == 5 && isVenueUnlocked(band, 2)) {
                venueLogic.festivalSmallStage(band);
            } else if (concertUserChoice == 6 && isVenueUnlocked(band, 3)) {
                venueLogic.festivalMediumStage(band);
            } else if (concertUserChoice == 7 && isVenueUnlocked(band, 4)) {
                venueLogic.festivalLargeStage(band);
            } else if (concertUserChoice == 8 && isVenueUnlocked(band, 5)) {
                venueLogic.festivalMainStage(band);
            } else if (concertUserChoice == 9 && isVenueUnlocked(band, 1000)) { //SHOP LOGIC MISSING!
                venueLogic.startTour(band);
            } else if (concertUserChoice == 0) {
                break;
            } else {
                System.out.println("\n" + "Invalid command!");
            }
        }

    }

    public String getVenueStatus(boolean isVenueUnlocked) {
        if (isVenueUnlocked) {
            return "Unlocked ✅";
        } else {
            return "Locked 🔒";
        }
    }

    public boolean isVenueUnlocked(Band band, int requiredFameLevel) {
        return band.getBandFameLevel() >= requiredFameLevel;
    }

    public void shop(Band band) {
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
