package Iteration4;

import java.util.Random;
import java.util.Scanner;

public class VenueLogic {
    private Random random = new Random();
    private int venueCapacity;
    private int attendance;
    private double concertEarnMoney;
    private int concertGainFans;
    private int concertAddXP;
    private String concertTurnout;
    private double attendancePercentage;
    private String venueName;

    //Booleans
    private boolean showTourMenuRunning = true;
    boolean pickTourAmountRunning = true;

    public void concertOutcomeLogic() {
        attendancePercentage = (double) attendance / venueCapacity * 100;
        if (attendancePercentage >= 80) {
            concertTurnout = "Great concert!";
            concertEarnMoney = attendance * 2.8;
            concertGainFans = (int)(attendance * 1.5);
            concertAddXP = attendance;
        } else if (attendancePercentage >= 50) {
            concertTurnout = "Decent concert";
            concertEarnMoney = attendance * 2.2;
            concertGainFans = (int)(attendance * 1.2);
            concertAddXP = (int) (attendance * 0.8);
        } else if (attendancePercentage >= 30) {
            concertTurnout = "Okay concert...";
            concertEarnMoney = attendance * 1.8;
            concertGainFans = (int)(attendance * 0.8);
            concertAddXP = (int) (attendance * 0.5);
        } else {
            concertTurnout = "Disaster!";
            concertEarnMoney = attendance * 1.5;
            concertGainFans = (int)(attendance * -0.8);
            concertAddXP = (int) (attendance * 0.3);

        }
    }

    public void concertVariableLogic(Band band, Shop shop) {
        //Variables for attendance and venue capacity
        attendance = random.nextInt(101) + (venueCapacity - 100);
        //Call of concertOutcomeLogic method
        concertOutcomeLogic();
        //Add values to band variables
        band.earnMoney(concertEarnMoney * shop.getEquipmentBonus());
        band.gainFans((concertGainFans * (int) shop.getSpeakersBonus()));
        band.addXP(attendance);
        //Check if band is active after concert
        //band.isActive(); //Not needed after adding this to "RandomEventLogic"
    }

    public void smallVenue(Band myBand, Band rivalBand, Shop shop) {
        venueName = "Small venue";
        venueCapacity = 350;
        concertVariableLogic(myBand, shop);
        concertVariableLogic(rivalBand, shop);
    }

    public void mediumVenue(Band myBand, Band rivalBand, Shop shop) {
        venueName = "Medium venue";
        venueCapacity = 475;
        concertVariableLogic(myBand, shop);
        concertVariableLogic(rivalBand, shop);
    }

    public void largeVenue(Band myBand, Band rivalBand, Shop shop) {
        venueName = "Large venue";
        venueCapacity = 650;
        concertVariableLogic(myBand, shop);
        concertVariableLogic(rivalBand, shop);
    }

    public void stadiumConcert(Band myBand, Band rivalBand, Shop shop) {
        venueName = "Stadium concert";
        venueCapacity = 1000;
        concertVariableLogic(myBand, shop);
        concertVariableLogic(rivalBand, shop);
    }

    public void festivalSmallStage(Band myBand, Band rivalBand, Shop shop) {
        venueName = "Festival small stage";
        venueCapacity = 400;
        concertVariableLogic(myBand, shop);
        concertVariableLogic(rivalBand, shop);
    }

    public void festivalMediumStage(Band myBand, Band rivalBand, Shop shop) {
        venueName = "Festival medium stage";
        venueCapacity = 525;
        concertVariableLogic(myBand, shop);
        concertVariableLogic(rivalBand, shop);
    }

    public void festivalLargeStage(Band myBand, Band rivalBand, Shop shop) {
        venueName = "Festival large stage";
        venueCapacity = 750;
        concertVariableLogic(myBand, shop);
        concertVariableLogic(rivalBand, shop);
    }

    public void festivalMainStage(Band myBand, Band rivalBand, Shop shop) {
        venueName = "Festival main stage";
        venueCapacity = 1500;
        concertVariableLogic(myBand, shop);
        concertVariableLogic(rivalBand, shop);
    }

    public void showTourMenu(Band myBand, Band rivalBand, GamePrinter gamePrinter, VenueLogic venueLogic,
                             Scanner keyboardInput, Shop shop) {
        showTourMenuRunning = true;
        while (showTourMenuRunning) {
            gamePrinter.printTourMenu();
            int tourMenuChoice = keyboardInput.nextInt();
            switch (tourMenuChoice) {
                case 1 -> pickTourAmount(myBand, rivalBand, gamePrinter, venueLogic, keyboardInput, shop);
                case 0 -> showTourMenuRunning = false;
                default -> gamePrinter.printInvalidCommandText();
            }
        }
    }

    public void pickTourAmount(Band myBand, Band rivalBand, GamePrinter gamePrinter,VenueLogic venueLogic,
                               Scanner keyboardInput, Shop shop) {
        pickTourAmountRunning = true;
        while (pickTourAmountRunning) {
            gamePrinter.printTourAmountQuestion();
            int tourAmountChoice = keyboardInput.nextInt();
            switch (tourAmountChoice) {
                case 1, 2, 3, 4, 5 -> tourLogic(tourAmountChoice, myBand, rivalBand, gamePrinter, venueLogic, shop);
                case 0 -> pickTourAmountRunning = false;
                default -> gamePrinter.printInvalidCommandText();
            }
        }
    }

    public void tourLogic(int amountOfConcerts, Band myBand, Band rivalBand, GamePrinter gamePrinter,
                          VenueLogic venueLogic, Shop shop) {
        gamePrinter.printTourStagesHeader();
        for (int i = 0; i < amountOfConcerts; i++) {
            smallVenue(myBand, rivalBand, shop);
            gamePrinter.printTourStages(venueLogic, myBand);
        }
        pickTourAmountRunning = false;
        showTourMenuRunning = false;
    }

    //Getters needed to provide to "GamePrinter" class
    public String getVenueName() {
        return venueName;
    }

    public int getVenueCapacity() {
        return venueCapacity;
    }

    public int getAttendance() {
        return attendance;
    }

    public double getAttendancePercentage() {
        return attendancePercentage;
    }

    public String getConcertTurnout() {
        return concertTurnout;
    }

    public int getConcertGainFans() {
        return concertGainFans;
    }

    public double getConcertEarnMoney() {
        return concertEarnMoney;
    }

    public int getConcertAddXP() {
        return concertAddXP;
    }
}
