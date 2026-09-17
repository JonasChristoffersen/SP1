package Iteration4;

import java.util.Scanner;

public class GameLogic {
    //Creation of a scanner class
    Scanner keyboardInput = new Scanner(System.in);

    //Needed classes
    VenueLogic venueLogic = new VenueLogic();
    Shop shop = new Shop();

    //This class is thought to serve logics like if statements and so on regarding the game!

    //Band stats
    public void bandStats(Band band) {
        System.out.println("\n" + "====== 📝 Band profile 📝 ======"
                    //+ "\n" + "(Press any key when you are ready to go back)"
                    + "\n" + "Name: " + band.getBandName()
                    + "\n" + "Genre: " + band.getBandMusicGenreChar() + " (" + band.getBandMusicGenre() + ")"
                    + "\n" + "Fame level: " + band.getBandFameLevel()
                    + "\n" + "Status: " + band.getStatusTitle(band.getBandFameLevel())
                    + "\n" + "Fans: " + band.getBandCurrentFans() + "/" + band.bandMaxFans(band.getBandFameLevel())
                    + " (" + band.getFanPercentage() + "%)"
                    + "\n" + "XP: " + band.getBandXP()
                    + "\n" + "Money: $" + band.getBandCurrentBalance()
                    + "\n" + "Active: " + band.isBandActive()
            );
    }


    public void startGame(Band myBand, Band rivalBand) {
        while (true) {
            gameMenuMessages();
            int userGameChoice = keyboardInput.nextInt();
            if (userGameChoice  == 1) {
                bandStats(myBand);
            } else if (userGameChoice  == 2) {
                playConcert(myBand, rivalBand);
            } else if (userGameChoice  == 3) {
                shop.shopMenu(myBand);
            } else if (userGameChoice == 4) {
                bandStats(myBand);
                bandStats(rivalBand);
            } else if (userGameChoice  == 0) {
                exitConfirmationLoop();
            } else {
                System.out.println("Invalid command!");
            }
        }
    }

    int count = 0;
    public boolean isFirstTimer() {
        if (count == 0) {
            count++;
            return true;
        } else {
            return false;
        }
    }


    public void gameMenuMessages() {
        if (isFirstTimer()) {
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
                    4 - 🆚 Compare your band to rival (NOT CREATED)
                    0 - ❌ Exit game"""
            );
        } else {
            System.out.println("""
                    
                    ====== 🎤 BAND SIM 🎤 ======
                    (Type the number of an action listed below)
                    1 - 📝 Band stats
                    2 - 🎸 Play a concert/tour
                    3 - 🛒 Shop
                    4 - 🆚 Compare your band to rival (NOT CREATED)
                    0 - ❌ Exit game"""
            );
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

    public void playConcert(Band myBand, Band rivalBand) {
        while (true) {
            //Print of options
            System.out.println("\n" + "====== 🎸 PLAY A CONCERT/TOUR 🎸 ======"
                    + "\n" + myBand.getBandName() + " is setting up arrangements..."
                    + "\n" + "What kind of event should they be looking for?"
                    + "\n" + "(Type the number of an action listed below)"
                    + "\n" + "1 - Small venue (Unlocked ✅ - Fame level 1)"
                    + "\n" + "2 - Medium Venue (" + getVenueStatus(isVenueUnlocked(myBand, 2)) + " - Fame level 2)"
                    + "\n" + "3 - Large Venue (" + getVenueStatus(isVenueUnlocked(myBand, 3)) + " - Fame level 3)"
                    + "\n" + "4 - Stadium concert (" + "Locked 🔒" + " - Visit the shop)"
                    + "\n" + "5 - Festival small stage (" + getVenueStatus(isVenueUnlocked(myBand, 3)) + " - Fame level 2)"
                    + "\n" + "6 - Festival medium stage (" + getVenueStatus(isVenueUnlocked(myBand, 4)) + " - Fame level 3)"
                    + "\n" + "7 - Festival Large Stage (" + getVenueStatus(isVenueUnlocked(myBand, 4)) +" - Fame level 4)"
                    + "\n" + "8 - Festival main stage (" + getVenueStatus(isVenueUnlocked(myBand, 5)) + " - Fame level 5)"
                    + "\n" + "9 - Start a tour (" + "Locked 🔒" + " - Visit the shop)"
                    + "\n" + "0 - Cancel, go back to main menu"
            );

            //BE AWARE THAT LOGIC FOR LOCKED CONCERTS THAT NEEDS TO BE BOUGHT IN SHOP IS NOT CREATED/IMPLEMENTED YET!
            int concertUserChoice = keyboardInput.nextInt();
            if (concertUserChoice == 1 && isVenueUnlocked(myBand, 1)) {
                venueLogic.smallVenue(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
            } else if (concertUserChoice == 2 && isVenueUnlocked(myBand, 2)) {
                venueLogic.mediumVenue(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
            } else if (concertUserChoice == 3 && isVenueUnlocked(myBand, 3)) {
                venueLogic.largeVenue(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
            } else if (concertUserChoice == 4 && isVenueUnlocked(myBand, 1000)) { //SHOP LOGIC MISSING!
                venueLogic.stadiumConcert(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
            } else if (concertUserChoice == 5 && isVenueUnlocked(myBand, 2)) {
                venueLogic.festivalSmallStage(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
            } else if (concertUserChoice == 6 && isVenueUnlocked(myBand, 3)) {
                venueLogic.festivalMediumStage(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
            } else if (concertUserChoice == 7 && isVenueUnlocked(myBand, 4)) {
                venueLogic.festivalLargeStage(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
            } else if (concertUserChoice == 8 && isVenueUnlocked(myBand, 5)) {
                venueLogic.festivalMainStage(myBand, rivalBand);
                venueLogic.printSingleConcert(myBand);
            } else if (concertUserChoice == 9 && isVenueUnlocked(myBand, 1000)) { //SHOP LOGIC MISSING!
                venueLogic.startTour(myBand, rivalBand);
            } else if (concertUserChoice == 0) {
                break;
            } else {
                System.out.println("\n" + "Not unlocked yet or Invalid command!");
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

    public boolean isVenueUnlocked(Band myBand, int requiredFameLevel) {
        return myBand.getBandFameLevel() >= requiredFameLevel;
    }
}
