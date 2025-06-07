package org.lld.structuralPattern.decorator;
interface Logger {
    void log(String message);
}

class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

abstract class LoggerDecorator implements Logger {
    protected Logger logger;
    public LoggerDecorator(Logger logger) {
        this.logger = logger;
    }
}

class TimestampLogger extends LoggerDecorator {
    public TimestampLogger(Logger logger) {
        super(logger);
    }
    public void log(String message) {
        logger.log("[Time: " + System.currentTimeMillis() + "] " + message);
    }
}

class ErrorLevelLogger extends LoggerDecorator {
    public ErrorLevelLogger(Logger logger) {
        super(logger);
    }
    public void log(String message) {
        logger.log("[ERROR] " + message);
    }
}

// Main
public class LoggerMaker {
    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
//        logger.log("Null pointer exception");
        logger = new TimestampLogger(logger);
//        logger.log("Null pointer exception");
        logger = new ErrorLevelLogger(logger);

        logger.log("Null pointer exception");
        // Output: Log: [ERROR] [Time: 1680000000000] Null pointer exception
    }
}


