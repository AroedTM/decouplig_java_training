package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {

    Logger my_logger;
    String my_class;

    public ContextualLogger(String my_class, Logger my_logger) {
        this.my_logger = my_logger;
        this.my_class = my_class;
    }

    @Override
    public void log(String message){
        this.my_logger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " " + this.my_class + " " + message);
    }
}
