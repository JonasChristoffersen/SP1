package Iteration4;

public class GameLogic {
    //This class is thought to serve logics like if statements and so on regarding the game!

    //Band stats
    public void bandStats(Band band) {
        System.out.println("Band profile"
                + "\n" + "Name: " + band.getBandName()
                + "\n" + "Genre: " + band.getBandMusicGenreChar() + " (" + band.getBandMusicGenre() + ")"
                + "\n" + "Fame level: " + band.getBandFameLevel()
                //+ "\n" + "Status: " + getStatusTitle(band.getBandFameLevel())
                //+ "\n" + "Fans: " + band.getBandCurrentFans() + "/" + bandMaxFans() + " (" + getFanPercentage() + "%)"
                //+ "\n" + "Fan base: " + getFanPercentage() + "% of venue capacity"
                + "\n" + "XP: " + band.getBandXP()
                + "\n" + "Money: $" + band.getBandCurrentBalance()
                + "\n" + "Active: " + band.isBandActive()
        );
    }

    public void startGame(Band band) {
        System.out.println();
    }

    public void shop(Band band) {
        System.out.println();
    }
}
