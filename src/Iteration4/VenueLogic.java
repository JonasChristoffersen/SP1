package Iteration4;

import java.util.Random;

public class VenueLogic {
    Random random = new Random();
    int venueCapacity;
    int attendance;
    double localEarnMoney;
    int localGainFans;
    int localAddXP;
    String concertTurnout;
    double attendancePercentage;
    String venueName;


    public void concertOutcomeLogic() {
        attendancePercentage = (double) attendance / venueCapacity * 100;
        if (attendancePercentage >= 80) {
            concertTurnout = "Great concert!";
            localEarnMoney = attendance * 2.8;
            localGainFans = (int)(attendance * 1.5);
            localAddXP = attendance;
        } else if (attendancePercentage >= 50) {
            concertTurnout = "Decent concert";
            localEarnMoney = attendance * 2.2;
            localGainFans = (int)(attendance * 1.2);
            localAddXP = (int) (attendance * 0.8);
        } else if (attendancePercentage >= 30) {
            concertTurnout = "Okay concert...";
            localEarnMoney = attendance * 1.8;
            localGainFans = (int)(attendance * 0.8);
            localAddXP = (int) (attendance * 0.5);
        } else {
            concertTurnout = "Disaster!";
            localEarnMoney = attendance * 1.5;
            localGainFans = (int)(attendance * -0.8);
            localAddXP = (int) (attendance * 0.3);

        }
    }

    public void printSingleConcert(Band band) {
        //Print of result
        System.out.println("\n" + "====== " + venueName + " ======"
                + "\n" + "Playing at venue (capacity: " + venueCapacity + ")"
                + "\n" + "Attendance: " + attendance + " (" + attendancePercentage + "%)"
                + "\n" + "Turnout: " + concertTurnout
                + "\n" + "Fans: " + (band.getBandCurrentFans() - localGainFans) + " -> " + band.getBandCurrentFans()
                + "\n" + "Money: " + (band.getBandCurrentBalance() - localEarnMoney) + " -> " + band.getBandCurrentBalance()
                + "\n" + "XP: " + (band.getBandXP() - localAddXP) + " -> " + band.getBandXP()
                + "\n" + "Fame level: " + band.getBandFameLevel()
        );
    }

    public void concertVariableLogic(Band band, int venueCap) {
        //Variables for attendance and venue capacity
        attendance = random.nextInt(101) + (venueCap - 100);
        venueCapacity = venueCap;
        //Call of concertOutcomeLogic method
        concertOutcomeLogic();
        //Add values to band variables:
        band.earnMoney(localEarnMoney);
        band.gainFans(localGainFans);
        band.addXP(attendance);
        //Check if band is active after concert
        band.isActive();
    }

    public void smallVenue(Band myBand, Band rivalBand) {
        venueName = "Small venue";
        concertVariableLogic(myBand, 350);
        concertVariableLogic(rivalBand, 350);
    }

    public void mediumVenue(Band myBand, Band rivalBand) {
        venueName = "Medium venue";
        concertVariableLogic(myBand, 475);
        concertVariableLogic(rivalBand, 475);
    }

    public void largeVenue(Band myBand, Band rivalBand) {
        venueName = "Large venue";
        concertVariableLogic(myBand, 650);
        concertVariableLogic(rivalBand, 650);
    }

    public void stadiumConcert(Band myBand, Band rivalBand) {
        venueName = "Stadium concert";
        concertVariableLogic(myBand, 1000);
        concertVariableLogic(rivalBand, 1000);
    }

    public void festivalSmallStage(Band myBand, Band rivalBand) {
        venueName = "Festival small stage";
        concertVariableLogic(myBand, 400);
        concertVariableLogic(rivalBand, 400);
    }

    public void festivalMediumStage(Band myBand, Band rivalBand) {
        venueName = "Festival medium stage";
        concertVariableLogic(myBand, 525);
        concertVariableLogic(rivalBand, 525);
    }

    public void festivalLargeStage(Band myBand, Band rivalBand) {
        venueName = "Festival large stage";
        concertVariableLogic(myBand, 750);
        concertVariableLogic(rivalBand, 750);
    }

    public void festivalMainStage(Band myBand, Band rivalBand) {
        venueName = "Festival main stage";
        concertVariableLogic(myBand, 1500);
        concertVariableLogic(rivalBand, 1500);
    }

    public void startTour(Band myBand, Band rivalBand) {
    }
}
