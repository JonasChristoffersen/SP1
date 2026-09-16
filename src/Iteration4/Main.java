package Iteration4;

public class Main {
    public void main() {
        //Initialization of variables given from "Band" class
        Band band = new Band();
        Band rivalBand = new Band();
        GameLoop gameLoop = new GameLoop();

        //Calls of other methods
        gameLoop.welcomeMessage(band);
        gameLoop.showMainMenu(band);
    }
}
//---------------------------------------------------------------------------------------------------------------------
//Things that needs to be added before project is done:
//RandomEvents class is created and is ready to be used!
//Im thinking that the class should be executed after a concert or tour (Maybe multiple during a tour)
//Rival band to compare stats and so on...
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

//When reaching max fans, it is not displayed anywhere +
