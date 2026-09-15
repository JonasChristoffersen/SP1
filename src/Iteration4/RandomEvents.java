package Iteration4;

import java.util.Random;

public class RandomEvents {
    String eventMessage;
    int randomEventFanValue;

    public void randomEventLogic(Band band) {
        int[] eventType = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int randomEventPicker = new Random().nextInt(eventType.length);
        if (eventType[randomEventPicker] == 1) {
            eventMessage = "Great review! (+500 fans)";
            randomEventFanValue = 500;
            band.gainFans(randomEventFanValue);
        } else if (eventType[randomEventPicker] == 2) {
            eventMessage = "Quiet week. Nothing happens.";
            randomEventFanValue = 0;
        } else if (eventType[randomEventPicker] == 3) {
            eventMessage = "Scandal! Some private photos of " + band.getBandName() + " have been leaked! (-500 fans)";
            randomEventFanValue = -500;
            band.gainFans(randomEventFanValue);
        } else if (eventType[randomEventPicker] == 4) {
            eventMessage = "Newsletter mentioned " + band.getBandName() + " positively (+50 fans)";
            randomEventFanValue = 50;
            band.gainFans(randomEventFanValue);
        } else if (eventType[randomEventPicker] == 5) {
            eventMessage = "Multiple fans given autographs on the street (+15 fans)";
            randomEventFanValue = 15;
            band.gainFans(randomEventFanValue);
        } else if (eventType[randomEventPicker] == 6) {
            eventMessage = "Nasty roumers are roaming about " + band.getBandName() + " (-300 fans)";
            randomEventFanValue = -300;
            band.loseFans(randomEventFanValue);
        } else if (eventType[randomEventPicker] == 7) {
            eventMessage = "Social media post went well (+150 fans)";
            randomEventFanValue = 150;
            band.gainFans(randomEventFanValue);
        } else if (eventType[randomEventPicker] == 8) {
            eventMessage = "Your song was featured on a popular playlist! (+400 fans)";
            randomEventFanValue = 400;
            band.gainFans(randomEventFanValue);
        } else if (eventType[randomEventPicker] == 9) {
            eventMessage = "Bad performance at a local event. Word is spreading... (-200 fans)";
            randomEventFanValue = -200;
            band.gainFans(randomEventFanValue);
        } else if (eventType[randomEventPicker] == 10) {
            eventMessage = "A famous artist mentioned " + band.getBandName() + " on social media! (+750 fans)";
            randomEventFanValue = 750;
            band.gainFans(randomEventFanValue);
        } else {
            eventMessage = "Event type is not implemented correctly!";
        }
    }

    public void randomEventPrint(Band band) {
        randomEventLogic(band);
        System.out.println("\n" + "====== RANDOM EVENT ======"
                + "\n" + eventMessage
                + "\n" + (band.getBandCurrentFans() - randomEventFanValue) + " -> " + band.getBandCurrentFans()
        );
    }
}

