package Iteration3;

public class Main {
    //Global variables
    //Variables for band profile
    String bandName = "Eurythmics";
    int bandFameLevel = 1;
    int bandCurrentFans = 250;
    double bandXP = 0.0;
    double bandCurrentBalance = 500.0;
    boolean isBandActive = true;

    int gigGainedFans;
    double gigGainedMoney;

    //Variables regarding music genres
    char[] allMusicGenres = {'R', 'E', 'P', 'H'}; // R = Rock   E = Electronic   P = Pop   H = Hiphop
    char bandMusicGenre = allMusicGenres[0];

    //String array of songs for band
    String[] bandSongs = {
            "Sweet dreams",
            "Are made of this",
            "Who am i to disagree?",
            "I travel the world",
            "And the seven seas",
    };

    public String header(String headerText){
        return ("\n" + "====== " + headerText + " ======");
    }

    public String getStatusTitle(int fameLevel) {
        if (fameLevel == 1) {
            return "Unknown - Playing in garages"; //Level 1
        } else if (fameLevel == 2) {
            return "Local Hero - Small venues await"; //Level 2
        } else if (fameLevel == 3) {
            return "Rising Star - Festival invitations coming in"; //Level 3
        } else if (fameLevel == 4) {
            return "Mainstream - Arena tours possible"; //Level 4
        } else if (fameLevel == 5) {
            return "Superstar - Stadium glory!"; //Level 5
        } else {
            return "Unknown fame level!";
        }
    }

    public double getFanPercentage() {
        return (double) bandCurrentFans / bandMaxFans() * 100;
    }

    public void printBandProfile() {
        String musicGenreText;

        //Logic for musicGenreText
        if (bandMusicGenre == 'R') {
            musicGenreText = "Rock";
        } else if (bandMusicGenre == 'E') {
            musicGenreText = "Electronic";
        } else if (bandMusicGenre == 'P') {
            musicGenreText = "Pop";
        } else if (bandMusicGenre == 'H') {
            musicGenreText = "Hip hop";
        } else {
            musicGenreText = "Unknown genre!";
        }

        //Print of header + band stats
        System.out.println(header("Band profile")
                + "\n" + "Name: " + bandName
                + "\n" + "Genre: " + bandMusicGenre + " (" + musicGenreText + ")"
                + "\n" + "Fame level: " + bandFameLevel
                + "\n" + "Status: " + getStatusTitle(bandFameLevel)
                + "\n" + "Fans: " + bandCurrentFans + "/" + bandMaxFans() + " (" + getFanPercentage() + "%)"
                + "\n" + "XP: " + bandXP
                + "\n" + "Money: $" + bandCurrentBalance
                + "\n" + "Active: " + isBandActive
        );
    }

    public void printRepertoire() {
        //Logic + print
        System.out.println(header("Repertoire (" + bandSongs.length + " songs)"));
        for (int i = 0; i <= (bandSongs.length - 1); i++) {
            System.out.println("- " + bandSongs[i]);
        }
    }

    public boolean isActive() {
        if (bandCurrentFans <= 0) {
            isBandActive = false;
            System.out.println(header("BREAKING NEWS")
                    + "\n" + bandName + " has broken up..."
                    + "\n" + "GAME OVER!"
            );
            System.exit(0);
        }
        return isBandActive;
    }

    public void playSingleGig(int venueCapacity, int attendance) {
        double attendancePercentage = (double) attendance / venueCapacity * 100;
        double gigGainedXP;
        String concertTurnout;

        if (attendancePercentage >= 80) {
            concertTurnout = "Great concert!";
            earnMoney(attendance * 2.8);
            gainFans(200);
            gigGainedXP = attendance;
            bandXP += gigGainedXP;
        } else if (attendancePercentage >= 30) {
            concertTurnout = "Decent concert...";
            earnMoney(attendance * 2.2);
            gainFans(50);
            gigGainedXP = attendance * 0.8;
            bandXP += gigGainedXP;
        } else {
            concertTurnout = "Disaster!";
            earnMoney(attendance * 1.5);
            loseFans(100);
            gigGainedXP = attendance * 0.3;
            bandXP += gigGainedXP;
        }

        System.out.println("\n" + "====== GIG NIGHT ======"
                + "\n" + "Playing at venue (capacity: " + venueCapacity + ")"
                + "\n" + "Attendance: " + attendance + " (" + attendancePercentage + "%)"
                + "\n" + "Turnout: " + concertTurnout
                + "\n" + "Fans: " + (bandCurrentFans - gigGainedFans) + " -> " + bandCurrentFans
                + "\n" + "Money: " + (bandCurrentBalance - gigGainedMoney) + " -> " + bandCurrentBalance
                + "\n" + "XP: " + (bandXP - gigGainedXP) + " -> " + bandXP
        );
    }

    public int bandMaxFans() {
        int bandMaxFans;
        //Logic for max fans in perspective to what fame level band is
        if (bandFameLevel == 1) {
            return bandMaxFans = 5000;
        } else if (bandFameLevel == 2) {
            return bandMaxFans = 15000;
        } else if (bandFameLevel == 3) {
            return bandMaxFans = 50000;
        } else if (bandFameLevel == 4) {
            return bandMaxFans = 200000;
        } else if (bandFameLevel == 5) {
            return bandMaxFans = 1000000;
        } else {
            return bandMaxFans = 0;
        }
    }

    public void gainFans(int amount) {
        if (bandCurrentFans <= bandMaxFans()) {
            if ((bandCurrentFans + amount) <= bandMaxFans()) {
                bandCurrentFans += amount;
                gigGainedFans = amount;
            } else {
                int fanMaxDifference = (bandCurrentFans + amount) - bandMaxFans();
                System.out.println();
                System.out.println(header("GAINED FANS")
                        + "\n" + "INFO: Max fan limit reached!"
                        + "\n" + "Fans gained: " + amount
                        + "\n" + "Total fans: " + bandCurrentFans + " -> " + bandMaxFans()
                        + " (" + fanMaxDifference + " lost due to fan limit)"
                );
                bandCurrentFans = bandMaxFans();
            }
        }
    }

    public void loseFans(int amount) {
        if ((bandCurrentFans - amount) > 0) {
            bandCurrentFans -= amount;
            gigGainedFans = amount * -1;
        } else {
            bandCurrentFans -= amount;
            isActive();
        }
    }

    public double earnMoney(double amount) {
        gigGainedMoney = amount;
        return bandCurrentBalance += amount;
    }

    public boolean spendMoney(double amount) {
        if (bandCurrentBalance > amount) {
            bandCurrentBalance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void main() {
        printBandProfile();
        printRepertoire();

        if (spendMoney(20000.0)) {
            System.out.println(header("PURCHASE")
                    + "\n" + "Bought new equipment!");
        } else {
            System.out.println(header("PURCHASE")
                    + "\n" +"Not enough money!");
        }

        gainFans(100);
        loseFans(0);
        spendMoney(500);
        isActive();
        playSingleGig(500, 50);
    }
}