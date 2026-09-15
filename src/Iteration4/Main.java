package Iteration4;

public class Main {
    public void main() {
        //Initialization of variables given from "Band" class
        Band band = new Band();
        GameLoop gameLoop = new GameLoop();
        RandomEvents randomEvents = new RandomEvents();

        //Calls of other methods
        gameLoop.welcomeMessage(band);
        gameLoop.showMainMenu(band);

        //RandomEvents class is created and is ready to be used!
        //Im thinking that the class should be executed after a concert or tour (Maybe multiple during a tour)



    }
}
