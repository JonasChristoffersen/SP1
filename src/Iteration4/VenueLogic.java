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


    public void concertOutcomeLogic(Band band) {
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
        concertOutcomeLogic(band);
        //Add values to band variables:
        band.earnMoney(localEarnMoney);
        band.gainFans(localGainFans);
        band.addXP(attendance);
        //Check if band is active after concert
        band.isActive();
    }

    public void smallVenue(Band band) {
        venueName = "Small venue";
        concertVariableLogic(band, 350);
    }

    public void mediumVenue(Band band) {
        venueName = "Medium venue";
        concertVariableLogic(band, 475);
    }

    public void largeVenue(Band band) {
        venueName = "Large venue";
        concertVariableLogic(band, 650);
    }

    public void stadiumConcert(Band band) {
        venueName = "Stadium concert";
        concertVariableLogic(band, 1000);
    }

    public void festivalSmallStage(Band band) {
        venueName = "Festival small stage";
        concertVariableLogic(band, 400);
    }

    public void festivalMediumStage(Band band) {
        venueName = "Festival medium stage";
        concertVariableLogic(band, 525);
    }

    public void festivalLargeStage(Band band) {
        venueName = "Festival large stage";
        concertVariableLogic(band, 750);
    }

    public void festivalMainStage(Band band) {
        venueName = "Festival main stage";
        concertVariableLogic(band, 1500);
    }

    public void startTour(Band band) {
    }
}
