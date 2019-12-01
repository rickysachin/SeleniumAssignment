package com.bdd.Util;

import org.apache.log4j.Logger;


public class Log {

// Initialize Log4j logs

    private static Logger Log = Logger.getLogger(Log.class.getName());

    public static void startLogging() {
        Log.info("XXXXXXXXXXXXXXXXXXXXXXX" + "-S---T---A---R---T-" + "XXXXXXXXXXXXXXXXXXXXXX");
    }

    public static void Logging(Object sDescription) {
        Log.info(sDescription);
    }

    public static void endLogging() {

        Log.info("XXXXXXXXXXXXXXXXXXXXXXX" + "-E---N---D-" + "XXXXXXXXXXXXXXXXXXXXXX");
    }

    public static void info(String message) {

        Log.info(message);

    }

    public static void warn(String message) {

        Log.warn(message);

    }

    public static void error(String message) {

        Log.error(message);

    }

    public static void fatal(String message) {

        Log.fatal(message);

    }

    public static void debug(String message) {

        Log.debug(message);

    }

}
