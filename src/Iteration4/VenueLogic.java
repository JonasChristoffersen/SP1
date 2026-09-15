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
    double attendancePercentage = (double) attendance / venueCapacity * 100;


    public void concertOutcomeLogic(Band band) {
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
            localGainFans = 100;
            localAddXP = (int) (attendance * 0.3);

        }
    }

    public void smallVenue(Band band) {
        //Variables for attendance and venue capacity
        attendance = random.nextInt(201) + 150;
        venueCapacity = 350;
        //Call of concertOutcomeLogic method
        concertOutcomeLogic(band);
        //Add values to band variables:
        band.earnMoney(localEarnMoney);
        band.gainFans(localGainFans);
        band.addXP(attendance);
        //Print of result
        System.out.println("\n" + "====== GIG NIGHT ======"
                + "\n" + "Playing at venue (capacity: " + venueCapacity + ")"
                + "\n" + "Attendance: " + attendance + " (" + attendancePercentage + "%)"
                + "\n" + "Turnout: " + concertTurnout
                + "\n" + "Fans: " + (band.getBandCurrentFans() - localGainFans) + " -> " + band.getBandCurrentFans()
                + "\n" + "Money: " + (band.getBandCurrentBalance() - localEarnMoney) + " -> " + band.getBandCurrentBalance()
                + "\n" + "XP: " + (band.getBandXP() - localAddXP) + " -> " + band.getBandXP()
        );
        //Check if band is active after concert
        band.isActive();
    }

    public void mediumVenue(Band band) {
    }

    public void largeVenue(Band band) {
    }

    public void stadiumConcert(Band band) {
    }

    public void festivalSmallStage(Band band) {
    }

    public void festivalMediumStage(Band band) {
    }

    public void festivalLargeStage(Band band) {
    }

    public void festivalMainStage(Band band) {
    }

    public void startTour(Band band) {
    }
}
