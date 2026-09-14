package Iteration4;

public class GameLogic {
    //This class is thought to serve logics like if statements and so on regarding the game!

    //Band stats
    public void bandStats(Band band) {
        System.out.println("\n" + "====== Band profile ======"
                + "\n" + "Name: " + band.getBandName()
                + "\n" + "Genre: " + band.getBandMusicGenreChar() + " (" + band.getBandMusicGenre() + ")"
                + "\n" + "Fame level: " + band.getBandFameLevel()
                + "\n" + "Status: " + band.getStatusTitle(band.getBandFameLevel())
                + "\n" + "Fans: " + band.getBandCurrentFans() + "/" + band.bandMaxFans(band.getBandFameLevel()) + " (" + band.getFanPercentage() + "%)"
                + "\n" + "Fan base: " + band.getFanPercentage() + "% of venue capacity"
                + "\n" + "XP: " + band.getBandXP()
                + "\n" + "Money: $" + band.getBandCurrentBalance()
                + "\n" + "Active: " + band.isBandActive()
        );
    }

    //Check the "band.getBandMusicGenreChar()" method!
    //The method returns nothing!

    public void startGame(Band band) {
        System.out.println();
    }

    public void shop(Band band) {
        System.out.println();
    }
}
