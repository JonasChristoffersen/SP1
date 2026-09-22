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

    private String textStartGame() {
        return "\n" + "1 - 🚀 Start game";
    }

    private String textBandStats() {
        return "\n" + "1 - 📝 Band stats";
    }

    private String textPlayConcert() {
        return "\n" + "2 - 🎸 Play a concert/tour";
    }

    private String textShop() {
        return "\n" + "3 - 🛒 Shop";
    }

    private String textCompareStats() {
        return "\n" + "4 - 🆚 Compare your band to rival";
    }

    private String textHelpInfo() {
        return "\n" + "5 - 🙋🏼‍♂️ Help/Info";
    }

    private String textExitGame() {
        return "\n" + "0 - ❌ Exit game";
    }

    private String textAdminMenu(){
        return "\n" + "9 - 🧩 Admin menu";
    }

    private String textTypeNumberAction() {
        return "\n" + "(Type the number of an action listed below)";
    }


    public void printStartMenu() {
        System.out.println("\n" + "====== 🔶 MAIN MENU 🔶 ======"
                + "\n" + "Are you ready to start your journey?"
                + textTypeNumberAction()
                + textStartGame()
                + textHelpInfo()
                + textExitGame()
        );
    }

    public void printFirstTimerMainMenu() {
        System.out.println("\n" + "====== 🚀 BAND SIM 🚀 ======"
                + "\n" + "Your journey to becoming a legendary band starts here!"
                + "\n" + "Build your reputation, grow your fan base, earn money and gain experience by"
                + "\n" + "playing concerts and upgrading your equipment."
                + "\n" + "Keep an eye on your Fame Level — the more famous you become, the bigger"
                + "\n" + "opportunities will become available."
                + textTypeNumberAction()
                + textBandStats()
                + textPlayConcert()
                + textShop()
                + textCompareStats()
                + textHelpInfo()
                + textExitGame()
        );
    }

    public void printMainMenu() {
        System.out.println("\n" + "====== 🎤 BAND SIM 🎤 ======"
                + textTypeNumberAction()
                + textBandStats()
                + textPlayConcert()
                + textShop()
                + textCompareStats()
                + textHelpInfo()
                + textExitGame()
        );
    }

    public void printAdminMainMenu() {
        System.out.println("\n" + "====== ❗❗❗ ADMIN - MAIN MENU ❗❗❗ ======"
                + textTypeNumberAction()
                + textBandStats()
                + textPlayConcert()
                + textShop()
                + textCompareStats()
                + textHelpInfo()
                + textAdminMenu()
                + textExitGame()
        );
    }

    public void printAdminSetValueQuestion() {
        System.out.println("What do you want to set the value to?");
    }

    public void printAdminValuesIsChanged(String value) {
        System.out.println("Value has been set to: " + value);
    }

    public void printAdminSetterMenu(Band myBand) {
        System.out.println("\n" + "====== ❗❗❗ ADMIN - SETTER MENU ❗❗❗ ======"
                + "\n" + "Current band values:"
                + "\n" + "Band name: " + myBand.getBandName()
                + "\n" + "Fame level: " + myBand.getBandFameLevel()
                + "\n" + "Fans: " + myBand.getBandCurrentFans()
                + "\n" + "XP: " + myBand.getBandXP()
                + "\n" + "Money: $" + myBand.getBandCurrentBalance()
                + "\n"
                + "\n" + "Set values for band:"
                + textTypeNumberAction()
                + "\n" + "1 - myBand.setBandName(String \"Name\")"
                + "\n" + "2 - myBand.setBandFameLevel(int fameLevel (1-5))"
                + "\n" + "3 - myBand.setBandCurrentFans(int amount)"
                + "\n" + "4 - myBand.setBandXP(int amount)"
                + "\n" + "5 - myBand.setBandCurrentBalance(double amount)"
                + "\n" + "0 - Back to main menu"
        );
    }

    public void printBandStats(Band band, Shop shop) {
        System.out.println("\n" + "====== 📝 Band profile 📝 ======"
                //+ "\n" + "(Press any key when you are ready to go back)"
                + "\n" + "Name: " + band.getBandName()
                + "\n" + "Genre: " + band.getBandMusicGenreChar() + " (" + band.getBandMusicGenre() + ")"
                + "\n" + "Fame level: " + band.getBandFameLevel()
                + "\n" + "Status: " + band.getStatusTitle(band.getBandFameLevel())
                + "\n" + "Fans: " + band.getBandCurrentFans() + "/" + band.bandMaxFans(band.getBandFameLevel())
                + " (" + band.getFanPercentage() + "%)"
                + "\n" + "XP: " + band.getBandXP() + "/" + band.xpThreshold()
                + "\n" + "Money: $" + band.getBandCurrentBalance()
                + "\n" + "Active: " + band.isBandActive()
                + "\n" + "Equipment level: " + shop.getEquipmentShopLevel() + "/5"
                + " (" + (int) Math.round((shop.getEquipmentBonus() - 1) * 100) + "% extra money gained from concerts)"
                + "\n" + "Speaker level: " + shop.getSpeakersShopLevel() + "/5"
                + " (" + (int) Math.round((shop.getSpeakersBonus() - 1) * 100) + "% extra fans gained from concerts)"
        );
    }

    public void printCompareBandStats(Band myBand, Band rivalBand) {
        System.out.println("====== ⚔️ " + myBand.getBandName() + " VS " + rivalBand.getBandName() + " ⚔️ ======"
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

    public void printConcertMenu(Band myBand, GameLogic gameLogic, Shop shop) {
        System.out.println("\n" + "====== 🎸 PLAY A CONCERT/TOUR 🎸 ======"
                + "\n" + myBand.getBandName() + " is setting up arrangements..."
                + "\n" + "What kind of event should they be looking for?"
                + "\n" + "(Type the number of an action listed below)"
                + "\n" + "1 - Small venue (Unlocked ✅ - Fame level 1)"
                + "\n" + "2 - Medium Venue (" + gameLogic.getVenueStatus(gameLogic.isVenueUnlocked(myBand, 2)) + " - Fame level 2)"
                + "\n" + "3 - Large Venue (" + gameLogic.getVenueStatus(gameLogic.isVenueUnlocked(myBand, 3)) + " - Fame level 3)"
                + "\n" + "4 - Stadium concert " + gameLogic.getStadiumStatus(shop)
                + "\n" + "5 - Festival small stage (" + gameLogic.getVenueStatus(gameLogic.isVenueUnlocked(myBand, 3)) + " - Fame level 2)"
                + "\n" + "6 - Festival medium stage (" + gameLogic.getVenueStatus(gameLogic.isVenueUnlocked(myBand, 4)) + " - Fame level 3)"
                + "\n" + "7 - Festival Large Stage (" + gameLogic.getVenueStatus(gameLogic.isVenueUnlocked(myBand, 4)) +" - Fame level 4)"
                + "\n" + "8 - Festival main stage (" + gameLogic.getVenueStatus(gameLogic.isVenueUnlocked(myBand, 5)) + " - Fame level 5)"
                + "\n" + "9 - Start a tour " + gameLogic.getStartATourStatus(shop)
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
        System.out.println("\n" + "====== 🕺🏼 " + venueLogic.getVenueName() + " 🕺🏼 ======"
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

    public void printShopMenu(Shop shop) {
        System.out.println("\n" + "====== 🛒 SHOP 🛒 ======"
                + "\n" + "This is the shop - Here you can buy/upgrade equipment"
                + "\n" + "(Type the number of an item listed below, to show more details)"
                + "\n" + "1 - Speakers " + shop.speakersPriceText() + " (Level " + shop.getSpeakersShopLevel() + "/5)"
                + "\n" + "2 - Equipment " + shop.equipmentPriceText() + " (Level " + shop.getEquipmentShopLevel() + "/5)"
                + "\n" + "3 - Stadium concert unlock " + shop.stadiumUnlockShopText()
                + "\n" + "4 - Start a tour unlock " + shop.startATourShopText()
                + "\n" + "0 - Back to main menu"
        );
    }

    public void printStadiumConcertUnlocked() {
        System.out.println("""
                
                Stadium concert is now unlocked!""");
    }

    public void printStartATourUnlocked() {
        System.out.println("""
                
                Tours are now unlocked!""");
    }

    public void printNotEnoughFounds() {
        System.out.println("""
                
                You do not have sufficient funds for this unlock!""");
    }

    public void printAlreadyUnlocked() {
        System.out.println("""
                
                This item is already unlocked!""");
    }

    public void printTourMenu() {
        System.out.println("""
                
                ====== 💃 START A TOUR 💃 ======
                (Type the number of an action listed below)
                1 - Start a tour (1-5 concerts)
                0 - Go back"""
        );
    }

    public void printTourAmountQuestion() {
        System.out.println("""
                
                How many concert do you want the tour to consist of? (Choose between 1-5)
                All tours that will be played, will be chosen random from unlocked venues!
                (Press 0 to cancel!)""");
    }

    public void printTourStagesHeader() {
        System.out.println("\n" + "====== 💫 TOUR SUMMARY 💫 ======");
    }

    public void printTourStages(VenueLogic venueLogic, Band myBand) {
        System.out.println(myBand.getBandName() + "Stage size: " + venueLogic.getVenueName()
                + " | " + "Payment: $" + venueLogic.getConcertEarnMoney()
                + " | " + "Attendance: " + venueLogic.getAttendance()
                + " | " + "Venue capacity: " + venueLogic.getVenueCapacity()
                + " | " + "Gained fans: " + venueLogic.getConcertGainFans()
                + " | " + "Turnout: " + venueLogic.getConcertTurnout()
                + " | " + "Attendance percentage: " + venueLogic.getAttendancePercentage() + "%"
        );
    }

    public void printHelpAndInfo() {
        System.out.println("""
                
                ╔══════════════════════════════════════════════════════════════════╗
                ║ HELP / INFO                                                      ║
                ║                                                                  ║
                ║ Welcome to Band Sim!                                             ║
                ║ Your goal is to grow your band from an unknown band into a       ║
                ║ legendary superstar. Build your fan base, earn money, gain XP    ║
                ║ and increase your Fame Level to unlock new opportunities.        ║
                ║                                                                  ║
                ║ ══ PLAYING CONCERTS ════════════════════════════════════════════ ║
                ║ Play concerts at different venues to grow your band. As your     ║
                ║ Fame Level increases, bigger venues and festivals become         ║
                ║ available.                                                       ║
                ║                                                                  ║
                ║ ══ CONCERT PERFORMANCE ═════════════════════════════════════════ ║
                ║ Your performance determines how successful your concert is.      ║
                ║ A successful concert can help your band gain fans, money and XP. ║
                ║                                                                  ║
                ║ ══ RANDOM EVENTS ═══════════════════════════════════════════════ ║
                ║ After concerts, unexpected random events can occur. These        ║
                ║ events can either help or hurt your band, so be prepared!        ║
                ║                                                                  ║
                ║ ══ SHOP ════════════════════════════════════════════════════════ ║
                ║ Use your money in the shop to unlock new opportunities and       ║
                ║ improve your band's career.                                      ║
                ║                                                                  ║
                ║ ══ TOURS ═══════════════════════════════════════════════════════ ║
                ║ Once unlocked, you can take your band on a tour consisting of    ║
                ║ multiple concerts. Choose how many concerts you want to play     ║
                ║ and let the tour begin!                                          ║
                ║                                                                  ║
                ║ ══ BECOME A LEGEND ═════════════════════════════════════════════ ║
                ║ Grow your fan base, increase your Fame Level, unlock new         ║
                ║ opportunities and become the biggest band in the game!           ║
                ║                                                                  ║
                ╚══════════════════════════════════════════════════════════════════╝""");
    }

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
