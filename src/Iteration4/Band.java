package Iteration4;

public class Band {
    private int bandFameLevel = 1;
    private String bandName = "Eurythmics";
    private int bandCurrentFans = 250;
    private double bandXP = 0.0;
    private double bandCurrentBalance = 500.0;
    private boolean isBandActive = true;
    private String bandMusicGenre = "Rock";
    private char bandMusicGenreChar;

    //bandFameLevel
    public void setBandFameLevel(int bandFameLevel) {
        this.bandFameLevel = bandFameLevel;
    }
    public int getBandFameLevel() {
        return bandFameLevel;
    }

    //bandName
    public String getBandName() {
        return bandName;
    }
    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    //bandCurrentFans
    public int getBandCurrentFans() {
        return bandCurrentFans;
    }
    public void setBandCurrentFans(int bandCurrentFans) {
        this.bandCurrentFans = bandCurrentFans;
    }

    //bandXP
    public double getBandXP() {
        return bandXP;
    }
    public void setBandXP(double bandXP) {
        this.bandXP = bandXP;
    }

    //bandCurrentBalance
    public double getBandCurrentBalance() {
        return bandCurrentBalance;
    }
    public void setBandCurrentBalance(double bandCurrentBalance) {
        this.bandCurrentBalance = bandCurrentBalance;
    }

    //isBandActive
    public boolean isBandActive() {
        return isBandActive;
    }
    public void setBandActive(boolean bandActive) {
        isBandActive = bandActive;
    }

    //bandMusicGenre
    public String getBandMusicGenre() {
        return bandMusicGenre;
    }
    public char getBandMusicGenreChar() {
        return bandMusicGenreChar;
    }
    public void setBandMusicGenre(String bandMusicGenre) {
        if (bandMusicGenre.equalsIgnoreCase("rock")) {
            this.bandMusicGenre = bandMusicGenre;
            bandMusicGenreChar = 'R';
        } else if (bandMusicGenre.equalsIgnoreCase("electronic")) {
            this.bandMusicGenre = bandMusicGenre;
            bandMusicGenreChar = 'E';
        } else if (bandMusicGenre.equalsIgnoreCase("pop")) {
            this.bandMusicGenre = bandMusicGenre;
            bandMusicGenreChar = 'P';
        } else if (bandMusicGenre.equalsIgnoreCase("hiphop")) {
            this.bandMusicGenre = bandMusicGenre;
            bandMusicGenreChar = 'H';
        }
    }
}
