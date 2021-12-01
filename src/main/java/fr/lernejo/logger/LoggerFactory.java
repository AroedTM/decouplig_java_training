package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {

    public static Logger getLogger(String name)
    {
        return new CompositeLogger(
            new FilteredLogger(
                new ContextualLogger(
                    new FileLogger("C://Users/engue/OneDrive/4A/S7/Architecture logiciel/TP Interfaces/logs.txt"),
                    name
                ),
                message -> name.contains("simulation")
            ),
            new ContextualLogger(
                new ConsoleLogger(),
                name
            )
        );
    }
}
