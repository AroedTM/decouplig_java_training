package fr.lernejo;

import fr.lernejo.guessgame.ComputerPlayer;
import fr.lernejo.guessgame.HumanPlayer;

import java.security.SecureRandom;

public class Launcher
{
    public static void main(String[] args) {
        if(args.length > 0 && args.length < 3)
        {
            switch(args[0]){
                case "-interactive":
                    if(args.length == 1)
                    {
                        HumanPlayer human_player = new HumanPlayer();
                        Simulation simulation1 = new Simulation(human_player);
                        SecureRandom random1 = new SecureRandom();
                        long randomNumber1 = random1.nextInt(100);
                        simulation1.initialize(randomNumber1);
                        simulation1.loopUntilPlayerSucceed(Long.MAX_VALUE);
                    }
                    else{
                        System.out.println("Pour lancer le programme :");
                        System.out.println(" -interactive");
                        System.out.println(" -auto <nombre>");
                    }
                    break;

                case "-auto":
                    boolean is_long;
                    if(args.length == 2)
                    {
                        try {
                            Long.parseLong(args[1]);
                            is_long = true;
                        } catch (NumberFormatException e) {
                            is_long = false;
                        }
                        if(is_long) {
                            ComputerPlayer computer_player = new ComputerPlayer();
                            Simulation simulation2 = new Simulation(computer_player);
                            simulation2.initialize(Long.parseLong(args[1]));
                            simulation2.loopUntilPlayerSucceed(1000);
                        }else{
                            System.out.println("Pour lancer le programme :");
                            System.out.println(" -interactive");
                            System.out.println(" -auto <nombre>");
                        }
                    }else{
                        System.out.println("Pour lancer le programme :");
                        System.out.println(" -interactive");
                        System.out.println(" -auto <nombre>");
                    }
                    break;

                default:
                    System.out.println("Pour lancer le programme :");
                    System.out.println(" -interactive");
                    System.out.println(" -auto <nombre>");
                    break;
            }
        }
        else{
            System.out.println("Pour lancer le programme :");
            System.out.println(" -interactive");
            System.out.println(" -auto <nombre>");
        }
    }
}
