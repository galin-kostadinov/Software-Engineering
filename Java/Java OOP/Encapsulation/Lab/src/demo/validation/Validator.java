package demo.validation;

public class Validator {
    public static void ensureContains(String value, String part) {
        if (!value.contains(part)) {
            reportError(String.format("%s is not contained in %s", part, value));
        }
    }

    public static void ensureLengthBetween(String value, int min, int max) {
        int length = value.length();
        if (length < min || length > max) {
            reportError("Length cannot be less than " + min + " symbols");
        }
    }

    public static void ensureMinLength(String value, int min) {
        ensureLengthBetween(value, min, Integer.MAX_VALUE);
    }

    public static void ensureMaxLength(String value, int max) {
        ensureLengthBetween(value, 0, max);
    }

    public static void ensureMinNumber(int value, int min) {
        if (value <= min) {
            reportError("Age cannot be zero or negative integer");
        }
    }

    public static void ensureMinNumber(double value, double min) {
        if (value <= min) {
            reportError("Age cannot be zero or negative integer");
        }
    }

    public static void ensureValidAge(int age) {
        ensureMinNumber(age, 0);
    }

    private static void reportError(String massage) {
        throw new IllegalArgumentException(massage);
    }
}
