package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import jdk.jfr.Unsigned;

public class ComputerPlayer implements Player {

    Logger logger = LoggerFactory.getLogger("computer");
    long born_sup = Long.MAX_VALUE;
    long born_inf = 0;
    long nbr = (born_inf + born_sup) / 2;
    boolean bool = true;

    @Override
    public long askNextGuess() {
        if(!bool)
            born_sup = nbr;
        else{
            born_inf = nbr;
        }
        nbr = (born_inf + born_sup) / 2;
        logger.log("Nombre de l'ordinateur :" + nbr);
        return nbr;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        bool = lowerOrGreater;
    }
}
