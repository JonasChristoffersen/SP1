package Iteration1;

public class Main {
    //My band stats
    String bandName = "The Static Waves";
    int currentFans = 8500;
    int maxFans = 15000;
    int fameLevel = 2;
    int experiencePoints = 3200;
    double currentBalance = 4750.50;

    //repertoire (sange)
    String[] bandSongs = {
            "Sweet dreams",
            "Are made of this",
            "Who am i to disagree?",
            "I travel the world",
            "And the seven seas",
    };

    //Generic stats
    boolean isActive = true;
    char[] musicGenre = {'R', 'E', 'P', 'H'}; // R = Rock   E = Electronic   P = Pop   H = Hiphop

    // Rival band stats (NOT USED YET)
    String rivalBandName = "The Evil demons";
    int rivalCurrentFans = 8700;
    int rivalMaxFans = 15000;
    int rivalFameLevel = 2;
    int rivalExperiencePoints = 3400;
    double rivalCurrentBalance = 4980.80;

    //Rival repertoire (sange)
    String[] rivalBandSongs = {
            "You put a spell on me",
            "I don't know what to do",
            "It's an ability",
            "That draws me closer to you",
            "Your magic",
    };

    public void main() {
        //My band header
        System.out.println("\u001B[1;97m====== My band profile ======\u001B[0m");

        //Displayed band stats
        System.out.println("Name: " + bandName);
        System.out.println("Genre: " + musicGenre[0]);
        System.out.println("Fame level:  " + fameLevel);
        System.out.println("Fans: " + currentFans + "/" + maxFans);
        System.out.println("XP: " + experiencePoints);
        System.out.println("Money: $" + currentBalance);
        System.out.println("Active: " + isActive);

        //Separator between band stats and repertoire
        System.out.println();

        //Displayed repertoire header
        System.out.println("Repertoire (" + bandSongs.length + " songs)");

        //Displayed repertoire (sange)
        System.out.println("- " + bandSongs[0]);
        System.out.println("- " + bandSongs[1]);
        System.out.println("- " + bandSongs[2]);
        System.out.println("- " + bandSongs[3]);
        System.out.println("- " + bandSongs[4]);

        //Separator between repertoire and rival band
        System.out.println();

        //Rival band header
        System.out.println("\u001B[1;91m====== Rival band profile ======\u001B[0m");

        //Displayed rival band stats
        System.out.println("Name: " + rivalBandName);
        System.out.println("Genre: " + musicGenre[2]);
        System.out.println("Fame level: " + rivalFameLevel);
        System.out.println("Fans: " + rivalCurrentFans + "/" + rivalMaxFans);
        System.out.println("XP: " + rivalExperiencePoints);
        System.out.println("Money: $" + rivalCurrentBalance);
        System.out.println("Active: " + isActive);

        //Separator between band stats and repertoire
        System.out.println();

        //Displayed repertoire header
        System.out.println("Repertoire (" + rivalBandSongs.length + " songs)");

        //Displayed repertoire (sange)
        System.out.println("- " + rivalBandSongs[0]);
        System.out.println("- " + rivalBandSongs[1]);
        System.out.println("- " + rivalBandSongs[2]);
        System.out.println("- " + rivalBandSongs[3]);
        System.out.println("- " + rivalBandSongs[4]);
    }
}