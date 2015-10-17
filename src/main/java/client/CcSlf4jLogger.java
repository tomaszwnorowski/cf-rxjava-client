package client;

import feign.slf4j.Slf4jLogger;

public class CcSlf4jLogger extends Slf4jLogger {
    private static final String PRIVATE_DATA = "[PRIVATE DATA HIDDEN]";

    public CcSlf4jLogger() {
        super(CcSlf4jLogger.class);
    }

    public CcSlf4jLogger(Class<?> clazz) {
        super(clazz);
    }

    @Override
    protected void log(String configKey, String format, Object... args) {
        if ((args != null) && (args.length == 2)) {
            if ("Authorization".equals(args[0].toString())) {
                args[1] = PRIVATE_DATA;
            }
        }

        super.log(configKey, format, args);
    }
}
