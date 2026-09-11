package Iteration2;

public class RivalCode {
    public void main() {
        // Rival band stats
        String rivalBandName = "The Evil demons";
        int rivalCurrentFans = 8700;
        int rivalMaxFans = 15000;
        int rivalFameLevel = 2;
        int rivalExperiencePoints = 3400;
        double rivalCurrentBalance = 4980.80;
        //char rivalMusicGenre = musicGenres[2];// R = Rock   E = Electronic   P = Pop   H = Hiphop
        String rivalMusicGenreText;
        boolean isRivalActive = true;

        //Rival repertoire (sange)
        String[] rivalBandSongs = {
                "You put a spell on me",
                "I don't know what to do",
                "It's an ability",
                "That draws me closer to you",
                "Your magic",
        };

        //Separator between repertoire and rival band
        System.out.println();

        //Rival band header
        System.out.println("\u001B[1;91m====== Rival band profile ======\u001B[0m");

        //Displayed rival band stats
        System.out.println("Name: " + rivalBandName);
        //System.out.println("Genre: " + rivalMusicGenre);
        System.out.println("Fame level: " + rivalFameLevel);
        System.out.println("Fans: " + rivalCurrentFans + "/" + rivalMaxFans);
        System.out.println("XP: " + rivalExperiencePoints);
        System.out.println("Money: $" + rivalCurrentBalance);
        System.out.println("Active: " + isRivalActive);

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
