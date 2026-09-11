package Iteration2;

import java.util.Random;

public class Main {
    public void main() {
        //Generic stats
        char[] musicGenres = {'R', 'E', 'P', 'H'}; // R = Rock   E = Electronic   P = Pop   H = Hiphop
        double fanWarningLevel = 0.25;
        String[] fameLevelNames = {
                "Level 1 (Unknown - Playing in garages)",
                "Level 2 (Local Hero - Small venues await)",
                "Level 3 (Rising Star - Festival invitations coming in)",
                "Level 4 (Mainstream - Arena tours possible)",
                "Level 5 (Superstar - Stadium glory!)",
        };

        //My band stats
        String myBandName = "Eurythmics";
        int myCurrentFans = 8500; //8500
        int myMaxFans = 15000;
        int myFameLevel = 2;
        int myExperiencePoints = 3200; //3200
        int myXpThreshold = myFameLevel * 2000;
        double myCurrentBalance = 4750.50;
        char myMusicGenre = musicGenres[0];
        String myMusicGenreText;
        boolean isMyBandActive = true;

        //repertoire (sange)
        String[] myBandSongs = {
                "Sweet dreams",
                "Are made of this",
                "Who am i to disagree?",
                "I travel the world",
                "And the seven seas",
        };

        //Udskriv forskellige beskeder baseret på genre (‘R’, ‘E’, ‘H’, ‘P’)
        switch (myMusicGenre) {
            case 'R':
                myMusicGenreText = "Rock";
                break;
            case 'E':
                myMusicGenreText = "Electronic";
                break;
            case 'P':
                myMusicGenreText = "Pop";
                break;
            case 'H':
                myMusicGenreText = "Hip hop";
                break;
            default:
                myMusicGenreText = "Ukendt genre!";
        }

        //Hvis bandet har 0 eller færre fans, sæt isActive til false og udskriv “The band has broken up…”
        if (myCurrentFans <= 0) {
            isMyBandActive = false;
            System.out.println("====== BREAKING NEWS ======"
                    + "\n" + myBandName + " has broken up...");
            System.exit(0);
        }

        //My band header + displayed band stats
        System.out.println("\n" + "====== My band profile ======"
                + "\n" + "Name: " + myBandName
                + "\n" + "Genre: " + myMusicGenre + " (" + myMusicGenreText + ")"
                + "\n" + "Fame level: " + myFameLevel
                + "\n" + "Fans: " + myCurrentFans + "/" + myMaxFans
                + "\n" + "XP: " + myExperiencePoints
                + "\n" + "Money: $" + myCurrentBalance
                + "\n" + "Active: " + isMyBandActive
                + "\n" + "Status: " + fameLevelNames[myFameLevel - 1]
        );

        //Displayed repertoire header + displayed repertoire (sange)
        System.out.println("\n" + "Repertoire (" + myBandSongs.length + " songs)");
        for (int i = 0; i <= (myBandSongs.length - 1); i++) {
            System.out.println("- " + myBandSongs[i]);
        }

        //Displayed "Status check" hvis xp threshold er true eller hvis fanWarningLevel er true!
        if ((myExperiencePoints >= myXpThreshold)) {
            System.out.println("\n" + "====== STATUS CHECK ======" +
                    "\n" + "Ready to level up!");
            if (myCurrentFans <= (myMaxFans * fanWarningLevel)) {
                System.out.println("WARNING: Losing relevance! Consider a comeback strategy.");
            }
        } else if (myCurrentFans <= (myMaxFans * fanWarningLevel)) {
            System.out.println("\n" + "====== STATUS CHECK ======" +
                    "\n" + "WARNING: Losing relevance! Consider a comeback strategy.");
        }

        //Gig variabler
        int venueCapacity = 500;
        int attendance = 420;
        int gainedFans = 0;
        double concertPayment = 0;
        String concertTurnout;

        //Attendance procent + logik
        double attendancePercentage = (double) attendance / venueCapacity * 100;
        if (attendancePercentage >= 80) {
            gainedFans = 200;
            concertTurnout = "Great concert!";
            concertPayment = attendance * 2.8;
        } else {
            concertTurnout = "Decent concert... But it could have been better!";
            concertPayment = attendance * 2.2;
            gainedFans = 50;
        }

        if (attendancePercentage >= 80) {
            myCurrentFans += gainedFans;
            myCurrentBalance += concertPayment;
        } else {
            myCurrentFans += gainedFans;
            myCurrentBalance += concertPayment;
        }

        //Displayed gig night header + gig night stats
        System.out.println("\n" + "====== GIG NIGHT ======"
                + "\n" + "Playing at venue (capacity: " + venueCapacity + ")"
                + "\n" + "Attendance: " + attendance + " (" + attendancePercentage + "%)"
                + "\n" + "Turnout: " + concertTurnout
                + "\n" + "Fans: " + (myCurrentFans - gainedFans) + " -> " + myCurrentFans
                + "\n" + "Money: " + (myCurrentBalance - concertPayment) + " -> " + myCurrentBalance
        );

        //Random event logic
        int[] eventType = {1, 2, 3};
        int randomEventPicker = new Random().nextInt(eventType.length);
        String eventMessage;
        if (eventType[randomEventPicker] == 1) {
            eventMessage = "Great review! (+500 fans)";
            gainedFans = 500;
            myCurrentFans += gainedFans;
        } else if (eventType[randomEventPicker] == 2) {
            eventMessage = "Quiet week. Nothing happens.";
            gainedFans = 0;
        } else if (eventType[randomEventPicker] == 3) {
            eventMessage = "Scandal! (-300 fans)";
            gainedFans = -300;
            myCurrentFans += gainedFans;
        } else {
            eventMessage = "Event type is not implemented correctly!";
        }

        //Random event header + print
        System.out.println("\n" + "====== RANDOM EVENT ======"
                + "\n" + eventMessage
                + "\n" + (myCurrentFans - gainedFans) + " -> " + myCurrentFans
        );

        //Tour simulation variabler
        int[] tourConcertOutcomes = {1, 2, 3, 4, 5};
        int randomTourVariabel = 1;
        String stageSize = "";
        int totalAttendance = 0;
        int totalCapacity = 0;
        int totalFansGained = 0;
        double totalMoneyGained = 0.0;

        //Tour simulation header
        System.out.println("\n" + "====== TOUR SIMULATION ======");

        //Tour simulation logik + print
        while (randomTourVariabel <= 5) {
            int randomTourPicker = new Random().nextInt(tourConcertOutcomes.length);
            switch (tourConcertOutcomes[randomTourPicker]) {
                case 1:
                    stageSize = "Smallest stage";
                    venueCapacity = 50;
                    attendance = 42;
                    break;
                case 2:
                    stageSize = "Medium stage";
                    venueCapacity = 260;
                    attendance = 259;
                    break;
                case 3:
                    stageSize = "Small stage";
                    venueCapacity = 100;
                    attendance = 12;
                    break;
                case 4:
                    stageSize = "Bigest stage";
                    venueCapacity = 550;
                    attendance = 395;
                    break;
                case 5:
                    stageSize = "Large stage";
                    venueCapacity = 400;
                    attendance = 384;
                    break;
            }
            attendancePercentage = (double) attendance / venueCapacity * 100;
            if (attendancePercentage >= 80) {
                gainedFans = 200;
                concertTurnout = "Great concert!";
                concertPayment = attendance * 2.8;
            } else if (attendancePercentage >= 40) {
                concertTurnout = "Decent concert...";
                concertPayment = attendance * 2.2;
                gainedFans = 50;
            } else {
                concertTurnout = "Disaster!";
                concertPayment = attendance * 1.5;
                gainedFans = -100;
            }
            totalAttendance += attendance;
            totalCapacity += venueCapacity;
            totalFansGained += gainedFans;
            totalMoneyGained += concertPayment;
            System.out.println("Stage size: " + stageSize
                    + " | " + "Payment: $" + (int) concertPayment
                    + " | " + "Attendance: " + attendance
                    + " | " + "Venue capacity: " + venueCapacity
                    + " | " + "Gained fans: " + gainedFans
                    + " | " + "Turnout: " + concertTurnout
                    + " | " + "Attendance percentage: " + attendancePercentage + "%"
            );
            randomTourVariabel++;
        }

        //Tour simulation summary print
        System.out.println("\n" + "====== TOUR SUMMARY ======"
                + "\n" + "Total attendance: " + totalAttendance
                + "\n" + "Total venue capacity: " + totalCapacity
                + "\n" + "Money gained: " + totalMoneyGained
                + "\n" + "Total fans gained: " + totalFansGained
        );
    }
}