package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try {
            throw new Exception("Not supported code");
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}
        /*char ch = '!';
        double d = 3.14;
        float f = 15.14f;
        int i = 360;
        long l = 1544878745L;
        short s = 99;
        byte b = 8;
        boolean log = true;
        LOG.debug("char is : {}, double is : {}, float is : {}, int is : {}",
                ch, d, f, i);
        LOG.debug("long is : {}, short is : {}, byte is : {}, boolean is : {},",
                l, s, b, log);*/
        /*  LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");*/



