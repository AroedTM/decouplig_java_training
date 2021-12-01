package fr.lernejo;

import fr.lernejo.guessgame.HumanPlayer;

import java.security.SecureRandom;

public class Launcher
{
    public static void main(String[] args) {
        HumanPlayer human_player = new HumanPlayer();
        Simulation simulation = new Simulation(human_player);
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100);
        simulation.initialize(randomNumber);
        simulation.loopUntilPlayerSucceed();
    }
}
