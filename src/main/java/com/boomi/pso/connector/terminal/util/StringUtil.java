package com.boomi.pso.connector.terminal.util;

/**
 * Contains helpful methods when working with Strings
 */

public class StringUtil {
    /**
     * @param values Collection of String values to concatenate together
     * @return Returns the result of all String values being concatenated together
     */
    public static String concat(String... values) {
        StringBuilder builder = new StringBuilder();
        for (String s : values) {
            builder.append(s);
        }
        return builder.toString();
    }

    /**
     * @param value Value to check
     * @return Returns whether provided value was null or empty
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.equals("");
    }
}
