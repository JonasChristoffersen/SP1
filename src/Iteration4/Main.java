package Iteration4;

import java.util.Scanner;

public class Main {
    public void main() {
        //Initialization of variables given from "Band" class
        Scanner keyboardInput = new Scanner(System.in);
        Band myBand = new Band();
        Band rivalBand = new Band();
        GameLogic gameLogic = new GameLogic();
        GamePrinter gamePrinter = new GamePrinter();
        VenueLogic venueLogic = new VenueLogic();
        Shop shop = new Shop();
        RandomEvents randomEvents = new RandomEvents();

        GameLoop gameLoop = new GameLoop(keyboardInput, gameLogic, gamePrinter, venueLogic, shop, randomEvents,
                myBand, rivalBand);

        //Calls of other methods
        gameLoop.welcomeMessage();
        gameLoop.showStartMenu();
    }
}
//---------------------------------------------------------------------------------------------------------------------
//Maybe add "Admin" user settings if user inputs admin as band name when starting the game
//---------------------------------------------------------------------------------------------------------------------
//Known issues:
//When playing the game, its possible to reach above level 5! + Max fans is not shown currently! + Fan procent is bugged!
//T
//====== 📝 Band profile 📝 ======
//Name: Eurythmics
//Genre: R (Rock)
//Fame level: 13
//Status: Unknown fame level!
//Fans: 109329/0 (Infinity%)
//Fan base: Infinity% of venue capacity
//XP: 0.0
//Money: $236479.40000000002
//Active: true

//When playing a gig, and leveling up, the XP is shown incorrectly! + Max fans seems to be stuck when reaching 109329!
//====== GIG NIGHT ======
//Playing at venue (capacity: 1500)
//Attendance: 1450 (96.66666666666667%)
//Turnout: Great concert!
//Fans: 107154 -> 109329
//Money: 232419.40000000002 -> 236479.40000000002
//XP: -1450.0 -> 0.0

//When band loose, it is not displayed what went wrong! only "GameOver" message is shown to user!

//When reaching max fans, it is not displayed anywhere!

//XP system seems to be broken when playing concerts!

//If user don't choose a band name, the band name is the same as rival band!
