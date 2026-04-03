/*
    Date and Time Utilities class provides helper methods for working with dates and times, including formatting,
    parsing, comparison, and basic date-time calculations.
*/

package main.util;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Utility methods for working with dates and times.
 */
public final class DateTimeUtil {
    private DateTimeUtil() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Returns the current LocalDateTime.
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * Returns the current LocalDate.
     */
    public static LocalDate today() {
        return LocalDate.now();
    }

    /**
     * Returns the current LocalTime.
     */
    public static LocalTime timeNow() {
        return LocalTime.now();
    }

    /**
     * Returns the current Instant (UTC timestamp).
     */
    public static Instant nowUtc() {
        return Instant.now();
    }

    /**
     * Formats a LocalDateTime using the given pattern.
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        if (dateTime == null || pattern == null) {
            return null;
        }

        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Formats a LocalDate using the given pattern.
     */
    public static String format(LocalDate date, String pattern) {
        if (date == null || pattern == null) {
            return null;
        }

        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Parses a string into a LocalDateTime using the given pattern.
     */
    public static LocalDateTime parseDateTime(String value, String pattern) {
        if (value == null || pattern == null) {
            return null;
        }

        return LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Parses a string into a LocalDate using the given pattern.
     */
    public static LocalDate parseDate(String value, String pattern) {
        if (value == null || pattern == null) {
            return null;
        }

        return LocalDate.parse(value, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Adds days to a LocalDateTime.
     */
    public static LocalDateTime addDays(LocalDateTime dateTime, long days) {
        return dateTime == null ? null : dateTime.plusDays(days);
    }

    /**
     * Adds hours to a LocalDateTime.
     */
    public static LocalDateTime addHours(LocalDateTime dateTime, long hours) {
        return dateTime == null ? null : dateTime.plusHours(hours);
    }

    /**
     * Adds minutes to a LocalDateTime.
     */
    public static LocalDateTime addMinutes(LocalDateTime dateTime, long minutes) {
        return dateTime == null ? null : dateTime.plusMinutes(minutes);
    }

    /**
     * Returns the number of days between two LocalDate values.
     */
    public static long daysBetween(LocalDate start, LocalDate end) {
        if (start == null || end == null) {
            return 0;
        }

        return Duration.between(start.atStartOfDay(), end.atStartOfDay()).toDays();
    }

    /**
     * Returns the number of seconds between two LocalDateTime values.
     */
    public static long secondsBetween(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) {
            return 0;
        }

        return Duration.between(start, end).getSeconds();
    }

    /**
     * Returns true if the given date is before the current date.
     */
    public static boolean isPast(LocalDateTime dateTime) {
        return dateTime != null && dateTime.isBefore(LocalDateTime.now());
    }

    /**
     * Returns true if the given date is after the current date.
     */
    public static boolean isFuture(LocalDateTime dateTime) {
        return dateTime != null && dateTime.isAfter(LocalDateTime.now());
    }

    /**
     * Converts a LocalDateTime to an Instant using the system default zone.
     */
    public static Instant toInstant(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }

        return dateTime.atZone(ZoneId.systemDefault()).toInstant();
    }

    /**
     * Converts an Instant to LocalDateTime using the system default zone.
     */
    public static LocalDateTime fromInstant(Instant instant) {
        if (instant == null) {
            return null;
        }

        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}