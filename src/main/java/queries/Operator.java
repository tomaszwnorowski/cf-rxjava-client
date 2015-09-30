package queries;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Operator {
    EQ() {
        @Override
        public String format(String key, Object... arguments) {
            return String.format("%s:%s", key, arguments[0].toString());
        }
    },
    GT() {
        @Override
        public String format(String key, Object... arguments) {
            return String.format("%s>%s", key, arguments[0].toString());
        }
    },
    GT_EQ() {
        @Override
        public String format(String key, Object... arguments) {
            return String.format("%s>=%s", key, arguments[0].toString());
        }
    },
    LT() {
        @Override
        public String format(String key, Object... arguments) {
            return String.format("%s<%s", key, arguments[0].toString());
        }
    },
    LT_EQ() {
        @Override
        public String format(String key, Object... arguments) {
            return String.format("%s<=%s", key, arguments[0].toString());
        }
    },
    IN() {
        @Override
        public String format(String key, Object... arguments) {
            return String.format("%s IN %s", key, Arrays.asList(arguments).stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(",")));
        }
    };

    public abstract String format(String key, Object... arguments);
}
