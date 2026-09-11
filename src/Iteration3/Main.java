package Iteration3;

public class Main {
    //Global variables
    //Variables for band profile
    String bandName = "Eurythmics";
    int bandFameLevel = 1;
    int bandCurrentFans = 1200;
    int bandMaxFans = 5000;
    int bandXP = 0;
    double bandCurrentBalance = 500.0;
    boolean isBandActive = true;

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
        return (double) bandCurrentFans / bandMaxFans * 100;
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
                + "\n" + "Fans: " + bandCurrentFans + "/" + bandMaxFans + " (" + getFanPercentage() + "%)"
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

    public void playGig(int venueCapacity, int attendance) {

    }

    public void main() {
        printBandProfile();
        printRepertoire();
        isActive();
    }
}