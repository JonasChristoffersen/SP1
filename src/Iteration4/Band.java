package Iteration4;

public class Band {
    private int bandFameLevel = 1;
    private String bandName = "Eurythmics";
    private int bandCurrentFans = 250;
    private double bandXP = 0.0;
    private double bandCurrentBalance = 500.0;
    private boolean isBandActive = true;
    char[] allMusicGenres = {'R', 'E', 'P', 'H'}; // R = Rock   E = Electronic   P = Pop   H = Hiphop
    private String bandMusicGenre = "Rock";
    private char bandMusicGenreChar = allMusicGenres[0];

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
    public void setBandMusicGenre(String bandMusicGenre) {
        if (bandMusicGenre.equalsIgnoreCase("Rock")) {
            this.bandMusicGenre = "Rock";
            this.bandMusicGenreChar = allMusicGenres[0]; //R
        } else if (bandMusicGenre.equalsIgnoreCase("Electronic")) {
            this.bandMusicGenre = "Electronic";
            this.bandMusicGenreChar = allMusicGenres[1]; //E
        } else if (bandMusicGenre.equalsIgnoreCase("Pop")) {
            this.bandMusicGenre = "Pop";
            this.bandMusicGenreChar = allMusicGenres[2]; //P
        } else if (bandMusicGenre.equalsIgnoreCase("Hiphop")) {
            this.bandMusicGenre = "Hiphop";
            this.bandMusicGenreChar = allMusicGenres[3]; //H
        }
    }
    //getBandMusicGenreChar
    public char getBandMusicGenreChar() {
        return bandMusicGenreChar;
    }


    public String getStatusTitle(int fameLevel) {
        if (fameLevel == 1) {
            return "Unknown - Playing in garages";
        } else if (fameLevel == 2) {
            return "Local Hero - Small venues await";
        } else if (fameLevel == 3) {
            return "Rising Star - Festival invitations coming in";
        } else if (fameLevel == 4) {
            return "Mainstream - Arena tours possible";
        } else if (fameLevel == 5) {
            return "Superstar - Stadium glory!";
        } else {
            return "Unknown fame level!";
        }
    }

    public int bandMaxFans(int fameLevel) {
        //Logic for max fans in perspective to what fame level band is
        if (fameLevel == 1) {
            return 5000;
        } else if (fameLevel == 2) {
            return 15000;
        } else if (fameLevel == 3) {
            return 50000;
        } else if (fameLevel == 4) {
            return 200000;
        } else if (fameLevel == 5) {
            return 1000000;
        } else {
            return 0;
        }
    }

    public double getFanPercentage() {
        return (double) bandCurrentFans / bandMaxFans(getBandFameLevel()) * 100;
    }

    public void gainFans(int amount) {
        if (bandCurrentFans <= bandMaxFans(bandFameLevel)) {
            if ((bandCurrentFans + amount) <= bandMaxFans(bandFameLevel)) {
                bandCurrentFans += amount;
            } else {
                bandCurrentFans = bandMaxFans(bandFameLevel);
            }
        }
    }

    public void loseFans(int amount) {
        if ((bandCurrentFans - amount) > 0) {
            bandCurrentFans -= amount;
        } else {
            bandCurrentFans -= amount;
            isActive();
        }
    }

    public boolean isActive() {
        if (bandCurrentFans <= 0) {
            isBandActive = false;
            System.out.println("""
                [1;31m
                ┏━╸┏━┓┏┳┓┏━╸   ┏━┓╻ ╻┏━╸┏━┓╻
                ┃╺┓┣━┫┃┃┃┣╸    ┃ ┃┃┏┛┣╸ ┣┳┛╹
                ┗━┛╹ ╹╹ ╹┗━╸   ┗━┛┗┛ ┗━╸╹┗╸╹
                [0m"""
            );
            System.exit(0);
        }
        return isBandActive;
    }

    public double earnMoney(double amount) {
        return bandCurrentBalance += amount;
    }

    public void addXP(int amount) {
        bandXP += amount;
        levelUp();
    }

    public void levelUp() {
        if (bandXP >= xpThreshold()) {
            bandFameLevel++;
            bandXP = 0;
        }
    }

    public int xpThreshold() {
        if (bandFameLevel == 1) {
            return 10000;
        } else if (bandFameLevel == 2) {
            return 25000;
        } else if (bandFameLevel == 3) {
            return 50000;
        } else if (bandFameLevel == 4) {
            return 100000;
        } else if (bandFameLevel == 5) {
            return 250000;
        } else {
            return 0;
        }
    }
}
