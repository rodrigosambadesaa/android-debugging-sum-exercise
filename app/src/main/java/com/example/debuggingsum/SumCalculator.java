package com.example.debuggingsum;

public final class SumCalculator {
    private SumCalculator() {}

    public static long parseOrZero(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0L;
        }
        return Long.parseLong(value.trim());
    }

    public static long add(String first, String second) {
        return Math.addExact(parseOrZero(first), parseOrZero(second));
    }
}
