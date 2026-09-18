package Iteration4;

public class GamePrinter {
    public void printWelcomeMessage() {
        System.out.println("""
                [1;35m
                ╻ ╻┏━╸╻  ┏━╸┏━┓┏┳┓┏━╸   ╺┳╸┏━┓   ┏┓ ┏━┓┏┓╻╺┳┓   ┏━┓╻┏┳┓╻\s
                ┃╻┃┣╸ ┃  ┃  ┃ ┃┃┃┃┣╸     ┃ ┃ ┃   ┣┻┓┣━┫┃┗┫ ┃┃   ┗━┓┃┃┃┃╹\s
                ┗┻┛┗━╸┗━╸┗━╸┗━┛╹ ╹┗━╸    ╹ ┗━┛   ┗━┛╹ ╹╹ ╹╺┻┛   ┗━┛╹╹ ╹╹\s
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━[0m
                """
        );
    }

    public void printDoUserWantToRenameBand() {
        System.out.println("""
                Do you wish to create your own band, or roll with a default option?
                (Y = Yes, i want to create my own band) (N = No, just roll the default option)"""
        );
    }

    public void printRenameBandQuestion() {
        System.out.println("""
                
                What do you want to name your band?"""
        );
    }

    public void printGenreBandQuestion() {
        System.out.println("""
                
                What do genre should your band play?
                You can choose between: Rock, Electronic, Pop and Hiphop"""
        );
    }

    public void printStartMenu() {
        System.out.println("""
                    
                    ====== 🔶 MAIN MENU 🔶 ======
                    Are you ready to start your journey?
                    (Type the number of an action listed below)
                    1 - 🚀 Start game
                    2 - 🟡 Help/Info (NOT CREATED YET)
                    0 - ❌ Exit game"""
        );
    }

    public void printFirstTimerMainMenu() {
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
                    4 - 🆚 Compare your band to rival
                    0 - ❌ Exit game"""
        );
    }

    public void printMainMenu() {
        System.out.println("""
                    
                    ====== 🎤 BAND SIM 🎤 ======
                    (Type the number of an action listed below)
                    1 - 📝 Band stats
                    2 - 🎸 Play a concert/tour
                    3 - 🛒 Shop
                    4 - 🆚 Compare your band to rival
                    0 - ❌ Exit game"""
        );
    }

    public void printBandStats(Band band) {
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

    public void printCompareBandStats(Band myBand, Band rivalBand) {
        System.out.println("====== " + myBand.getBandName() + " VS " + rivalBand.getBandName() + " ======"
                + "\n" + myBand.getBandName() + " fans: " + myBand.getBandCurrentFans()
                + "\n" + rivalBand.getBandName() + " fans: " + rivalBand.getBandCurrentFans()
                + "\n" + myBand.getBandName() + " fame level: " + myBand.getBandFameLevel()
                + "\n" + rivalBand.getBandName() + " fame level: " + rivalBand.getBandFameLevel()
                + "\n" + myBand.getBandName() + " XP: " + myBand.getBandXP()
                + "\n" + rivalBand.getBandName() + " XP: " + rivalBand.getBandXP()
                + "\n" + myBand.getBandName() + " balance: $" + myBand.getBandCurrentBalance()
                + "\n" + rivalBand.getBandName() + " balance: $" + rivalBand.getBandCurrentBalance()
        );

    }

    public void printConcertMenu(Band myBand, GameLogic gameLogic) {
        System.out.println("\n" + "====== 🎸 PLAY A CONCERT/TOUR 🎸 ======"
                + "\n" + myBand.getBandName() + " is setting up arrangements..."
                + "\n" + "What kind of event should they be looking for?"
                + "\n" + "(Type the number of an action listed below)"
                + "\n" + "1 - Small venue (Unlocked ✅ - Fame level 1)"
                + "\n" + "2 - Medium Venue (" + gameLogic.getVenueStatus(gameLogic.isVenueUnlocked(myBand, 2)) + " - Fame level 2)"
                + "\n" + "3 - Large Venue (" + gameLogic.getVenueStatus(gameLogic.isVenueUnlocked(myBand, 3)) + " - Fame level 3)"
                + "\n" + "4 - Stadium concert (" + "Locked 🔒" + " - Visit the shop)"
                + "\n" + "5 - Festival small stage (" + gameLogic.getVenueStatus(gameLogic.isVenueUnlocked(myBand, 3)) + " - Fame level 2)"
                + "\n" + "6 - Festival medium stage (" + gameLogic.getVenueStatus(gameLogic.isVenueUnlocked(myBand, 4)) + " - Fame level 3)"
                + "\n" + "7 - Festival Large Stage (" + gameLogic.getVenueStatus(gameLogic.isVenueUnlocked(myBand, 4)) +" - Fame level 4)"
                + "\n" + "8 - Festival main stage (" + gameLogic.getVenueStatus(gameLogic.isVenueUnlocked(myBand, 5)) + " - Fame level 5)"
                + "\n" + "9 - Start a tour (" + "Locked 🔒" + " - Visit the shop)"
                + "\n" + "0 - Cancel, go back to main menu"
        );
    }

    public void printRandomEvent(Band band, RandomEvents randomEvents, GamePrinter gamePrinter) {
        randomEvents.randomEventLogic(band, gamePrinter);
        System.out.println("\n" + "====== RANDOM EVENT ======"
                + "\n" + randomEvents.getEventMessage()
                + "\n" + (band.getBandCurrentFans() - randomEvents.getRandomEventFanValue()) + " -> " + band.getBandCurrentFans()
        );
    }

    public void printExitConfirmationText() {
        System.out.println("""
                
                Are you sure you want to exit the game?
                (Y = Yes, exit the game) (N = No, i want to keep playing)"""
        );
    }

    public void printInvalidCommandText() {
        System.out.println("""
                
                Invalid command!""");
    }

    public void printNotUnlockedOrInvalidText() {
        System.out.println("""
                
                Not unlocked yet or invalid command!""");
    }

    public void printSingleConcert(Band band, VenueLogic venueLogic) {
        //Print of result
        System.out.println("\n" + "====== " + venueLogic.getVenueName() + " ======"
                + "\n" + "Playing at venue (capacity: " + venueLogic.getVenueCapacity() + ")"
                + "\n" + "Attendance: " + venueLogic.getAttendance() + " (" + venueLogic.getAttendancePercentage() + "%)"
                + "\n" + "Turnout: " + venueLogic.getConcertTurnout()
                + "\n" + "Fans: " + (band.getBandCurrentFans() - venueLogic.getConcertGainFans()) + " -> " + band.getBandCurrentFans()
                + "\n" + "Money: " + (band.getBandCurrentBalance() - venueLogic.getConcertEarnMoney()) + " -> " + band.getBandCurrentBalance()
                + "\n" + "XP: " + (band.getBandXP() - venueLogic.getConcertAddXP()) + " -> " + band.getBandXP()
                + "\n" + "Fame level: " + band.getBandFameLevel()
        );
    }

    public void printThanksForPlaying() {
        System.out.println("Thanks for playing! See you soon.");
    }

    public void printShopMenu() {
        System.out.println("""
                
                ====== 🛒 SHOP 🛒 ======
                This is the shop - Here you can buy/upgrade equipment
                (Type the number of an item listed below, to show more details)
                1 - Speakers (Level 0)
                2 - Equipment (Level 0)
                ? - Stadium concert unlock(Level ?)
                ? - Start a tour unlock(Level ?)
                0 - Back to main menu"""
        );
    }

    //Not implemented yet/set up correctly
    public void printGameOverText() {
        System.out.println("""
                [1;31m
                ┏━╸┏━┓┏┳┓┏━╸   ┏━┓╻ ╻┏━╸┏━┓╻
                ┃╺┓┣━┫┃┃┃┣╸    ┃ ┃┃┏┛┣╸ ┣┳┛╹
                ┗━┛╹ ╹╹ ╹┗━╸   ┗━┛┗┛ ┗━╸╹┗╸╹
                [0m"""
        );
    }
}
