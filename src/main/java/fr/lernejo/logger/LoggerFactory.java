package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {

    public static Logger getLogger(String name)
    {
        return new CompositeLogger(
            new FilteredLogger(
                new ContextualLogger(
                    name,
                    new FileLogger("./target/logs.txt")
                ),
                message -> name.contains("simulation")
            ),
            new ContextualLogger(
                name,
                new ConsoleLogger()
            )
        );
    }
}
