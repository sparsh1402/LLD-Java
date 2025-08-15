package org.lld.behavioralPattern.chainOfResponsibility.logger;

abstract class Logger{
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    public int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessages(int level, String message){
        if(this.level <= level){
            write(message);
        }
        else if(nextLogger!=null){
            nextLogger.logMessages(level,message);
        }
    }

    protected abstract void write(String message);
}

class InfoLogger extends Logger{
    public InfoLogger(int level){
        this.level = level;
    }
    @Override
    protected void write(String message){
        System.out.println("INFO: " + message);
    }
}

class DebugLogger extends Logger{
    public DebugLogger(int level){
        this.level = level;
    }
    @Override
    protected void write(String message){
        System.out.println("DEBUG: " + message);
    }
}

class ErrorLogger extends Logger{
    public ErrorLogger(int level){
        this.level = level;
    }
    @Override
    protected void write(String message){
        System.out.println("ERROR: " + message);
    }
}




public class ChainPatternDemo {
    private static Logger getChainOfLoggers() {
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger debugLogger = new DebugLogger(Logger.DEBUG);
        Logger infoLogger = new InfoLogger(Logger.INFO);

        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        Logger loggerChain = getChainOfLoggers();

        loggerChain.logMessages(Logger.INFO, "This is an information.");
        loggerChain.logMessages(Logger.DEBUG, "This is a debug level information.");
        loggerChain.logMessages(Logger.ERROR, "This is an error information.");
    }
}
