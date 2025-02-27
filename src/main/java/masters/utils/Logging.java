package masters.utils;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.FileAppender;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Log utility.
 * @author Jacob Stringer
 */
public class Logging {

    private static Logger log;

    static {
        BasicConfigurator.configure();
    }

    public static Logger getLogger(String name) {
        if (log == null) {
            log = Logger.getLogger(name);
            log.setLevel(Level.TRACE);

            // Create file for logger
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MM dd HH mm ss");
            String path = "logs/" + simpleDateFormat.format(new Date()) + " " + name + ".log";
            try {
                log.addAppender(new FileAppender(new SimpleLayout(), path));
            } catch (IOException e) {
                log.error(e);
            }
        }

        return log;
    }
}
