package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player {

    Logger logger = LoggerFactory.getLogger("player");
    Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        logger.log("Entrer un nombre :");
        long my_long = scanner.nextLong();
        scanner.nextLine();
        return my_long;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater)
            logger.log("C'est plus petit");
        else{
            logger.log("C'est plus grand");
        }
    }
}
