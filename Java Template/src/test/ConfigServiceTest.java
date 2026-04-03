package test;

import main.service.ConfigService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

/*
    Unit tests for ConfigService. The approach is slightly different from File/Dir tests as we are testing in-memory
    and file persistence. Therefore, the implement order to follow:
        1. shouldSaveConfigToFile
        2. shouldLoadConfigFromFile
        3. getters (getString, getInt, etc.)
        4. key operations (containsKey, remove, clear)
        5. edge cases (invalid int, missing file)
 */

public class ConfigServiceTest {

    // Create instance of ConfigService

    // Define test config file path:
    // e.g. "test-config/app.properties"

    /**
     * Setup method:
     * - Create parent directory for config file
     * - Ensure clean state before each test
     */
    @BeforeEach
    void setup() {
        // Create parent directory using Files.createDirectories(...)
        // Optionally delete existing config file if it exists
    }

    /**
     * Cleanup method:
     * - Delete config file after each test
     * - Optionally remove directory if empty
     */
    @AfterEach
    void cleanup() {
        // Delete config file using Files.deleteIfExists(...)
        // Optionally delete parent directory
    }

    /**
     * Test: exists()
     * - Verify false when config file does not exist
     * - Create file (save or manually create)
     * - Verify true after creation
     */
    @Test
    void shouldCheckIfConfigExists() {
        // assertFalse exists
        // create config (save or Files.createFile)
        // assertTrue exists
    }

    /**
     * Test: save()
     * - Set some values
     * - Call save()
     * - Verify file is created
     * - Verify save returns true
     */
    @Test
    void shouldSaveConfigToFile() {
        // set values
        // call save()
        // assertTrue result
        // assertTrue exists
    }

    /**
     * Test: load()
     * - Save values first
     * - Create new ConfigService instance
     * - Call load()
     * - Verify values are loaded correctly
     */
    @Test
    void shouldLoadConfigFromFile() {
        // set values and save
        // create new instance
        // call load()
        // assertTrue load result
        // assert values match expected
    }

    /**
     * Test: load() when file does not exist
     * - Call load()
     * - Verify it returns false
     */
    @Test
    void shouldReturnFalseWhenLoadingMissingFile() {
        // call load()
        // assertFalse
    }

    /**
     * Test: getString()
     * - Set a string value
     * - Retrieve it
     * - Verify correct value is returned
     */
    @Test
    void shouldGetStringValue() {
        // set string
        // get string
        // assertEquals
    }

    /**
     * Test: getString() with default
     * - Do not set key
     * - Retrieve with default value
     * - Verify default is returned
     */
    @Test
    void shouldReturnDefaultStringValue() {
        // call getString(key, default)
        // assertEquals default
    }

    /**
     * Test: getInt()
     * - Set integer value
     * - Retrieve it
     * - Verify correct value
     */
    @Test
    void shouldGetIntValue() {
        // set int
        // get int
        // assertEquals
    }

    /**
     * Test: getInt() with invalid value
     * - Set non-numeric string
     * - Retrieve int
     * - Verify default is returned
     */
    @Test
    void shouldReturnDefaultForInvalidInt() {
        // set string value (non-numeric)
        // get int with default
        // assertEquals default
    }

    /**
     * Test: getBoolean()
     * - Set boolean value
     * - Retrieve it
     * - Verify correct value
     */
    @Test
    void shouldGetBooleanValue() {
        // set boolean
        // get boolean
        // assertTrue / assertFalse
    }

    /**
     * Test: getDouble()
     * - Set double value
     * - Retrieve it
     * - Verify correct value
     */
    @Test
    void shouldGetDoubleValue() {
        // set double
        // get double
        // assertEquals
    }

    /**
     * Test: containsKey()
     * - Set a key
     * - Verify containsKey returns true
     * - Check missing key returns false
     */
    @Test
    void shouldCheckIfKeyExists() {
        // set key
        // assertTrue containsKey
        // assertFalse for missing key
    }

    /**
     * Test: remove()
     * - Set a key
     * - Remove it
     * - Verify it no longer exists
     */
    @Test
    void shouldRemoveKey() {
        // set key
        // remove key
        // assertFalse containsKey
    }

    /**
     * Test: clear()
     * - Set multiple keys
     * - Clear config
     * - Verify all keys are removed
     */
    @Test
    void shouldClearAllConfigValues() {
        // set multiple keys
        // clear
        // assertFalse containsKey for each
    }

    /**
     * Test: getPath()
     * - Verify returned path matches input path
     */
    @Test
    void shouldReturnConfigPath() {
        // call getPath()
        // assertEquals expected path
    }
}