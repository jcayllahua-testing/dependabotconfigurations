package com.jcayllahua.dependabotconfigurations.utils;

import java.util.regex.Pattern;

public final class LogSanitizer {
    private static final Pattern CONTROL_CHARS =
            Pattern.compile("[\\r\\n\\t\\f\\x0B\\p{Cntrl}]");

    private static final String NULL_REPLACEMENT = "null";

    private LogSanitizer() {
    }

    public static String sanitize(String value) {
        if (value == null) {
            return NULL_REPLACEMENT;
        }
        return value.replaceAll("[\\r\\n\\t\\f\\x0B\\p{Cntrl}]", "_");
    }
}
