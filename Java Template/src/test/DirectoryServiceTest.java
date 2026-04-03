package test;

import main.service.DirectoryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

/*
    Unit tests for DirectoryService. The implement order to follow:
        1. shouldCreateDirectory
        2. shouldCheckDirectoryExists
        2. create methods.
        3. listing methods.
        4. deletion methods.
 */

public class DirectoryServiceTest {

    // Create instance of DirectoryService

    // Define test directory paths:
    // - base test directory (e.g. "test-data-dir")
    // - sub directory (e.g. "test-data-dir/sub")
    // - nested directory (e.g. "test-data-dir/sub/nested")

    /**
     * Setup method:
     * - Create base test directory before each test
     * - Ensure clean starting state
     */
    @BeforeEach
    void setup() {
        // Create base directory using Files.createDirectories(...)
    }

    /**
     * Cleanup method:
     * - Remove test directories after each test
     * - Use recursive deletion (Files.walk or service method)
     */
    @AfterEach
    void cleanup() {
        // Delete test directory recursively
    }

    /**
     * Test: exists()
     * - Verify false when directory does not exist
     * - Create directory
     * - Verify true after creation
     */
    @Test
    void shouldCheckDirectoryExists() {
        // assertFalse for non-existing dir
        // create dir
        // assertTrue after creation
    }

    /**
     * Test: create()
     * - Call create()
     * - Verify directory exists
     * - Verify method returns true
     */
    @Test
    void shouldCreateDirectory() {
        // call create()
        // assertTrue(result)
        // assertTrue(exists)
    }

    /**
     * Test: createDirectories()
     * - Create nested directory path
     * - Verify all parent directories are created
     */
    @Test
    void shouldCreateNestedDirectories() {
        // call createDirectories() with nested path
        // assertTrue exists for nested path
    }

    /**
     * Test: createIfMissing()
     * - Call on non-existing directory → should create
     * - Call again → should not fail
     */
    @Test
    void shouldCreateIfMissing() {
        // call createIfMissing first time
        // assertTrue exists
        // call again
        // assertTrue (should still succeed)
    }

    /**
     * Test: isEmpty()
     * - New directory should be empty
     * - Add file or subdirectory
     * - Verify it is no longer empty
     */
    @Test
    void shouldCheckIfDirectoryIsEmpty() {
        // assertTrue for empty dir
        // create file or subdir
        // assertFalse
    }

    /**
     * Test: list()
     * - Add files and directories
     * - Verify list contains all entries
     */
    @Test
    void shouldListDirectoryContents() {
        // create files + subdirs
        // call list()
        // assert size and contents
    }

    /**
     * Test: listFiles()
     * - Add files and directories
     * - Verify only files are returned
     */
    @Test
    void shouldListOnlyFiles() {
        // create files + dirs
        // call listFiles()
        // assert only files returned
    }

    /**
     * Test: listDirectories()
     * - Add files and directories
     * - Verify only directories are returned
     */
    @Test
    void shouldListOnlyDirectories() {
        // create files + dirs
        // call listDirectories()
        // assert only dirs returned
    }

    /**
     * Test: delete()
     * - Create directory
     * - Delete it
     * - Verify it no longer exists
     */
    @Test
    void shouldDeleteDirectory() {
        // create dir
        // delete
        // assertFalse exists
    }

    /**
     * Test: deleteRecursively()
     * - Create nested structure with files
     * - Delete recursively
     * - Verify everything is removed
     */
    @Test
    void shouldDeleteDirectoryRecursively() {
        // create nested dirs + files
        // deleteRecursively
        // assertFalse exists
    }

    /**
     * Test: getPath()
     * - Verify returned Path matches input
     */
    @Test
    void shouldReturnPathObject() {
        // call getPath()
        // assertEquals with expected Path
    }

    /**
     * Test: getName()
     * - Verify directory name is extracted correctly
     */
    @Test
    void shouldReturnDirectoryName() {
        // call getName()
        // assert expected name
    }

    /**
     * Test: resolve()
     * - Combine base path and child name
     * - Verify resolved path is correct
     */
    @Test
    void shouldResolveChildPath() {
        // call resolve()
        // assertEquals expected path
    }

    /**
     * Test: getParent()
     * - Verify parent directory is returned correctly
     */
    @Test
    void shouldReturnParentPath() {
        // call getParent()
        // assertEquals expected parent
    }

    /**
     * Test: normalize()
     * - Provide path with ".." or redundant separators
     * - Verify normalized path is correct
     */
    @Test
    void shouldNormalizePath() {
        // call normalize()
        // assert normalized result
    }
}