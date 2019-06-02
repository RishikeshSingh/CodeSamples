package Design.Logging;

/*
functionality:
>>  any class can use Logging and logging should e of format log(LogType, Message) where logType can be WARN, ERROR, GENERAL
>>  One should be abe to register multiple log sinks at runtime. For e.g. having ERROR logs to be sent to FileLogSink, while
    GENERAL AND ERROR logs both to be sent to ConsoleLogSink. Each Log SinK will have a different implementation
>>  the log processing shouldn't interfere with normal flow process
>>  eg: Logger logger = new Logger(this.class);
        logger.register(LogType.WARN, new FileSink(fileName.txt));
        logger.register(LogType.ERROR, new ConsoleSink());
        ...
        logger.warn("Foo");
        logger.error("Bar");
        logger.close();

*/

public class Logger {


}
