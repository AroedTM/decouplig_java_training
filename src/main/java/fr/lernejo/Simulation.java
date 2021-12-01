package fr.lernejo;

import fr.lernejo.guessgame.HumanPlayer;
import fr.lernejo.guessgame.Player;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final HumanPlayer player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = new HumanPlayer();
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long num = player.askNextGuess();
        if(num == this.numberToGuess) {
            logger.log("Nombre proposé identique");
            return true;
        }
        else{
            if(num < this.numberToGuess) {
                player.respond(false);
                logger.log("Nombre proposé trop petit");
            }
            else{
                player.respond(true);
                logger.log("Nombre proposé trop grand");
            }
            return false;
        }
    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me
        boolean my_bool = false;
        while(!my_bool)
        {
            my_bool = nextRound();
        }
    }
}
