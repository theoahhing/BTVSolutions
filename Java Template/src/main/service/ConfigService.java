/*
     Config Service class provides higher-level operations for loading, reading, and saving application configuration
     values using a properties file.
*/

package main.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * Service layer for config-related operations.
 * Provides higher-level logic for working with application properties files.
 */
public class ConfigService {

    private final Path configPath;
    private final Properties properties;

    /**
     * Creates a ConfigService from a string path.
     */
    public ConfigService(String filePath) {
        this.configPath = Path.of(filePath);
        this.properties = new Properties();
    }

    /**
     * Returns true if the config file exists.
     */
    public boolean exists() {
        return Files.exists(configPath) && Files.isRegularFile(configPath);
    }

    /**
     * Loads config values from the file if it exists.
     */
    public boolean load() {
        if (!exists()) {
            return false;
        }

        properties.clear();

        try (InputStream inputStream = Files.newInputStream(configPath)) {
            properties.load(inputStream);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Saves the current config values to the file.
     */
    public boolean save() {
        try {
            Path parent = configPath.getParent();

            if (parent != null && Files.notExists(parent)) {
                Files.createDirectories(parent);
            }

            try (OutputStream outputStream = Files.newOutputStream(configPath)) {
                properties.store(outputStream, "Application Configuration");
            }

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Returns the config file path.
     */
    public Path getPath() {
        return configPath;
    }

    /**
     * Returns the string value for the given key, or null if not found.
     */
    public String getString(String key) {
        return properties.getProperty(key);
    }

    /**
     * Returns the string value for the given key, or the default value if not found.
     */
    public String getString(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Returns the int value for the given key, or the default value if missing or invalid.
     */
    public int getInt(String key, int defaultValue) {
        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * Returns the boolean value for the given key, or the default value if missing.
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            return defaultValue;
        }

        return Boolean.parseBoolean(value.trim());
    }

    /**
     * Returns the double value for the given key, or the default value if missing or invalid.
     */
    public double getDouble(String key, double defaultValue) {
        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            return defaultValue;
        }

        try {
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * Sets a string config value.
     */
    public void set(String key, String value) {
        properties.setProperty(key, value);
    }

    /**
     * Sets an int config value.
     */
    public void set(String key, int value) {
        properties.setProperty(key, String.valueOf(value));
    }

    /**
     * Sets a boolean config value.
     */
    public void set(String key, boolean value) {
        properties.setProperty(key, String.valueOf(value));
    }

    /**
     * Sets a double config value.
     */
    public void set(String key, double value) {
        properties.setProperty(key, String.valueOf(value));
    }

    /**
     * Returns true if the config contains the given key.
     */
    public boolean containsKey(String key) {
        return properties.containsKey(key);
    }

    /**
     * Removes the given key from the config.
     */
    public void remove(String key) {
        properties.remove(key);
    }

    /**
     * Clears all config values.
     */
    public void clear() {
        properties.clear();
    }
}