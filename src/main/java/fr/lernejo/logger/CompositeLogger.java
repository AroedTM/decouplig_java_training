package fr.lernejo.logger;

public class CompositeLogger implements Logger {

    Logger my_logger1;
    Logger my_logger2;

    public CompositeLogger(Logger my_logger1, Logger my_logger2) {
        this.my_logger1 = my_logger1;
        this.my_logger2 = my_logger2;
    }

    @Override
    public void log(String message) {
        this.my_logger1.log(message);
        this.my_logger2.log(message);
    }
}
