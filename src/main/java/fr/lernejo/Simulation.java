package fr.lernejo;

import fr.lernejo.guessgame.HumanPlayer;
import fr.lernejo.guessgame.Player;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
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

    public void loopUntilPlayerSucceed(long max) {
        //TODO implement me
        long time = System.currentTimeMillis();
        boolean my_bool = false;
        long number = 0;
        while(number != max && !my_bool)
        {
            my_bool = nextRound();
            number++;
        }
        if(my_bool)
            logger.log("Le joueur a trouvé la solution avant la limite d'itération");
        else{
            logger.log("Le joueur n'a pas trouvé la solution avant la limite d'itération");
        }
        long now_time = System.currentTimeMillis() - time;

        Date date = new Date(now_time);
        DateFormat format = new SimpleDateFormat("mm:ss.SSS",
            Locale.FRANCE);
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String chrono = format.format(date);
        logger.log(chrono);
    }
}
