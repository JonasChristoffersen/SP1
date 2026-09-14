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
            localGainFans = 200;
            localAddXP = attendance;
            band.earnMoney(localEarnMoney);
            band.gainFans(localGainFans);
            band.addXP(attendance);
        } else if (attendancePercentage >= 50) {
            concertTurnout = "Decent concert";
            localEarnMoney = attendance * 2.2;
            localGainFans = 100;
            localAddXP = (int) (attendance * 0.8);
            band.earnMoney(localEarnMoney);
            band.gainFans(localGainFans);
            band.addXP(attendance);
        } else if (attendancePercentage >= 30) {
            concertTurnout = "Okay concert...";
            localEarnMoney = attendance * 1.8;
            localGainFans = 50;
            localAddXP = (int) (attendance * 0.5);
            band.earnMoney(localEarnMoney);
            band.gainFans(localGainFans);
            band.addXP(attendance);
        } else {
            concertTurnout = "Disaster!";
            localEarnMoney = attendance * 1.5;
            localGainFans = 100;
            localAddXP = (int) (attendance * 0.3);
            band.earnMoney(localEarnMoney);
            band.gainFans(localGainFans);
            band.addXP(attendance);
        }
    }

    //band.setBandXP(band.getBandXP() + 123);
    public void smallVenue(Band band) {
        int attendance = random.nextInt(201) + 150;
        int venueCapacity = 350;
        concertOutcomeLogic(band);

        //ADD print of the concert!


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
}
