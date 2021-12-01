package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name)
    {
        return new ContextualLogger(new FileLogger("C://Users/engue/OneDrive/4A/S7/Architecture logiciel/TP Interfaces/logs.txt"), name);
    }
}
