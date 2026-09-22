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
//TODO: Optimize Band class and so on with switch statement and so on to compress the code length!
//TODO: Add shop logic regarding upgrades of equipment
//---------------------------------------------------------------------------------------------------------------------
//Known issues:
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

//When reaching level 5 - Max xp is still displayed as such: XP: 105622.0/30000
