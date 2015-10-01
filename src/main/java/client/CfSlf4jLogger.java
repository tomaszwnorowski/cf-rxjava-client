package client;

import feign.slf4j.Slf4jLogger;

public class CfSlf4jLogger extends Slf4jLogger {
    private static final String PRIVATE_DATA = "[PRIVATE DATA HIDDEN]";

    public CfSlf4jLogger() {
        super(CfSlf4jLogger.class);
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
