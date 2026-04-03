package test;

import main.service.FileService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for FileService.
 */
public class FileServiceTest {

    private final FileService fileService = new FileService();
    private final String testDirectory = "test-data";
    private final String testFilePath = "test-data/test.txt";

    /**
     * Creates the test-data dir before each test.
     */
    @BeforeEach
    void setup() {
        try {
            Files.createDirectories(Path.of(testDirectory));
        } catch (Exception e) {
            fail("Failed to create test directory");
        }
    }

    /**
     * Cleans up test files after each test.
     */
    @AfterEach
    void cleanup() {
        try {
            Files.deleteIfExists(Path.of(testFilePath));
        } catch (Exception ignored) {
        }
    }

    /**
     * Tests writing and reading a file.
     */
    @Test
    void shouldWriteAndReadFile() {
        boolean written = fileService.write(testFilePath, "Hello World");
        assertTrue(written);

        String content = fileService.read(testFilePath);
        assertEquals("Hello World", content);
    }

    /**
     * Tests reading a missing file returns null.
     */
    @Test
    void shouldReturnNullWhenFileMissing() {
        String content = fileService.read("test-data/missing.txt");
        assertNull(content);
    }

    /**
     * Tests default value when file is missing.
     */
    @Test
    void shouldReturnDefaultValueWhenFileMissing() {
        String content = fileService.readOrDefault("test-data/missing.txt", "Default");
        assertEquals("Default", content);
    }

    /**
     * Tests appending content to a file.
     */
    @Test
    void shouldAppendToFile() {
        assertTrue(fileService.write(testFilePath, "Hello"));
        assertTrue(fileService.append(testFilePath, " World"));

        String content = fileService.read(testFilePath);
        assertEquals("Hello World", content);
    }

    /**
     * Tests file deletion.
     */
    @Test
    void shouldDeleteFile() {
        assertTrue(fileService.write(testFilePath, "temp"));

        boolean deleted = fileService.delete(testFilePath);
        assertTrue(deleted);
        assertFalse(fileService.exists(testFilePath));
    }

    /**
     * Tests file size.
     */
    @Test
    void shouldReturnFileSize() {
        assertTrue(fileService.write(testFilePath, "12345"));

        long size = fileService.size(testFilePath);
        assertEquals(5, size);
    }

    /**
     * Tests size for missing file.
     */
    @Test
    void shouldReturnMinusOneForMissingFileSize() {
        long size = fileService.size("test-data/missing.txt");
        assertEquals(-1, size);
    }
}