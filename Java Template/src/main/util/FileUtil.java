/*
    File utilities class encapsulates/wraps a filepath (fp) and provides convenient methods for performing file-related
    operations such as reading, writing, appending, and deleting files.

    NOTE: The IDE may suggest converting the class to a record class; the template structure follows an object-oriented
          wrappers around filesystem concepts.
*/

package main.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Utility wrapper for file-related operations.
 */
public class FileUtil {

    private final Path path;

    /**
     * Creates a FileUtil from a string path.
     */
    public FileUtil(String fp) {
        this.path = Path.of(fp);
    }

    /**
     * Creates a FileUtil from a Path.
     */
    public FileUtil(Path path) {
        this.path = path;
    }

    /**
     * Returns the filepath.
     */
    public Path getPath() {
        return path;
    }

    /**
     * Returns the file name, or empty string if unavailable.
     */
    public String getName() {
        return PathUtil.getName(path);
    }

    /**
     * Returns the file name without its extension.
     */
    public String getBaseName() {
        return PathUtil.getBaseName(path);
    }

    /**
     * Returns the file extension, or empty string if none exists.
     */
    public String getExtension() {
        return PathUtil.getExtension(path);
    }

    /**
     * Returns true if the file exists.
     */
    public boolean exists() {
        return Files.exists(path) && Files.isRegularFile(path);
    }

    /**
     * Creates the file if it does not exist.
     */
    public void create() throws IOException {
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
    }

    /**
     * Reads all lines from the file.
     */
    public List<String> readLines() throws IOException {
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    /**
     * Reads the entire file as a string.
     */
    public String read() throws IOException {
        return Files.readString(path, StandardCharsets.UTF_8);
    }

    /**
     * Returns the size of the file in bytes.
     */
    public long size() throws IOException {
        return Files.size(path);
    }

    /**
     * Writes content to the file, replacing existing content.
     */
    public void write(String content) throws IOException {
        Files.writeString(
                path,
                content,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE
        );
    }

    /**
     * Appends content to the file.
     */
    public void append(String content) throws IOException {
        Files.writeString(
                path,
                content,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }

    /**
     * Deletes the file if it exists.
     */
    public boolean delete() throws IOException {
        return Files.deleteIfExists(path);
    }
}