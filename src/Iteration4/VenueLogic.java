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

    public void concertVariableLogic(Band band) {
        //Variables for attendance and venue capacity
        attendance = random.nextInt(101) + (venueCapacity - 100);
        //Call of concertOutcomeLogic method
        concertOutcomeLogic();
        //Add values to band variables
        band.earnMoney(concertEarnMoney);
        band.gainFans(concertGainFans);
        band.addXP(attendance);
        //Check if band is active after concert
        //band.isActive(); //Not needed after adding this to "RandomEventLogic"
    }

    public void smallVenue(Band myBand, Band rivalBand) {
        venueName = "Small venue";
        venueCapacity = 350;
        concertVariableLogic(myBand);
        concertVariableLogic(rivalBand);
    }

    public void mediumVenue(Band myBand, Band rivalBand) {
        venueName = "Medium venue";
        venueCapacity = 475;
        concertVariableLogic(myBand);
        concertVariableLogic(rivalBand);
    }

    public void largeVenue(Band myBand, Band rivalBand) {
        venueName = "Large venue";
        venueCapacity = 650;
        concertVariableLogic(myBand);
        concertVariableLogic(rivalBand);
    }

    public void stadiumConcert(Band myBand, Band rivalBand) {
        venueName = "Stadium concert";
        venueCapacity = 1000;
        concertVariableLogic(myBand);
        concertVariableLogic(rivalBand);
    }

    public void festivalSmallStage(Band myBand, Band rivalBand) {
        venueName = "Festival small stage";
        venueCapacity = 400;
        concertVariableLogic(myBand);
        concertVariableLogic(rivalBand);
    }

    public void festivalMediumStage(Band myBand, Band rivalBand) {
        venueName = "Festival medium stage";
        venueCapacity = 525;
        concertVariableLogic(myBand);
        concertVariableLogic(rivalBand);
    }

    public void festivalLargeStage(Band myBand, Band rivalBand) {
        venueName = "Festival large stage";
        venueCapacity = 750;
        concertVariableLogic(myBand);
        concertVariableLogic(rivalBand);
    }

    public void festivalMainStage(Band myBand, Band rivalBand) {
        venueName = "Festival main stage";
        venueCapacity = 1500;
        concertVariableLogic(myBand);
        concertVariableLogic(rivalBand);
    }

    public void showTourMenu(Band myBand, Band rivalBand, GamePrinter gamePrinter, VenueLogic venueLogic, Scanner keyboardInput) {
        showTourMenuRunning = true;
        while (showTourMenuRunning) {
            gamePrinter.printTourMenu();
            int tourMenuChoice = keyboardInput.nextInt();
            switch (tourMenuChoice) {
                case 1 -> pickTourAmount(myBand, rivalBand, gamePrinter, venueLogic, keyboardInput);
                case 0 -> showTourMenuRunning = false;
                default -> gamePrinter.printInvalidCommandText();
            }
        }
    }

    public void pickTourAmount(Band myBand, Band rivalBand, GamePrinter gamePrinter,VenueLogic venueLogic,
                               Scanner keyboardInput) {
        pickTourAmountRunning = true;
        while (pickTourAmountRunning) {
            gamePrinter.printTourAmountQuestion();
            int tourAmountChoice = keyboardInput.nextInt();
            switch (tourAmountChoice) {
                case 1, 2, 3, 4, 5 -> tourLogic(tourAmountChoice, myBand, rivalBand, gamePrinter, venueLogic);
                case 0 -> pickTourAmountRunning = false;
                default -> gamePrinter.printInvalidCommandText();
            }
        }
    }

    public void tourLogic(int amountOfConcerts, Band myBand, Band rivalBand, GamePrinter gamePrinter, VenueLogic venueLogic) {
        gamePrinter.printTourStagesHeader();
        for (int i = 0; i < amountOfConcerts; i++) {
            smallVenue(myBand, rivalBand);
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
