package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name)
    {
        return new CompositeLogger(
            new ContextualLogger(
                new FileLogger("C://Users/engue/OneDrive/4A/S7/Architecture logiciel/TP Interfaces/logs.txt"),
                name
            ),
            new ContextualLogger(
                new ConsoleLogger(),
                name
            )
        );
    }
}
