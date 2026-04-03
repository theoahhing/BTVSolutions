/*
    Directory utilities class encapsulates/wraps a directory (dir) path and provides convenient methods for performing
    dir-related operations such as creating dirs, listing contents, and recursive deletion.
*/

package main.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utility wrapper for dir-related operations.
 */
public class DirectoryUtil {

    private final Path path;

    /**
     * Creates a DirectoryUtil from a string path.
     */
    public DirectoryUtil(String dirPath) {
        this.path = Path.of(dirPath);
    }

    /**
     * Creates a DirectoryUtil from a Path.
     */
    public DirectoryUtil(Path path) {
        this.path = path;
    }

    /**
     * Returns the dir path.
     */
    public Path getPath() {
        return path;
    }

    /**
     * Returns the dir name, or empty string if unavailable.
     */
    public String getName() {
        return PathUtil.getName(path);
    }

    /**
     * Returns true if the dir exists.
     */
    public boolean exists() {
        return Files.exists(path) && Files.isDirectory(path);
    }

    /**
     * Creates the dir if it does not exist.
     */
    public void create() throws IOException {
        if (Files.notExists(path)) {
            Files.createDirectory(path);
        }
    }

    /**
     * Creates the dir and any missing parent dirs.
     */
    public void createDirectories() throws IOException {
        if (Files.notExists(path)) {
            Files.createDirectories(path);
        }
    }

    /**
     * Returns true if the dir is empty.
     */
    public boolean isEmpty() throws IOException {
        try (Stream<Path> stream = Files.list(path)) {
            return stream.findFirst().isEmpty();
        }
    }

    /**
     * Lists all entries in the dir.
     */
    public List<Path> list() throws IOException {
        try (Stream<Path> stream = Files.list(path)) {
            return stream.collect(Collectors.toList());
        }
    }

    /**
     * Lists all files in the dir.
     */
    public List<Path> listFiles() throws IOException {
        try (Stream<Path> stream = Files.list(path)) {
            return stream
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
    }

    /**
     * Lists all sub-dirs in the dir.
     */
    public List<Path> listDirectories() throws IOException {
        try (Stream<Path> stream = Files.list(path)) {
            return stream
                    .filter(Files::isDirectory)
                    .collect(Collectors.toList());
        }
    }

    /**
     * Deletes the dir if it exists.
     */
    public boolean delete() throws IOException {
        return Files.deleteIfExists(path);
    }

    /**
     * Recursively deletes the dir and all its contents.
     *
     * Deletes children first to avoid dir-not-empty errors.
     */
    public boolean deleteRecursively() throws IOException {
        if (Files.notExists(path)) {
            return false;
        }

        try (Stream<Path> stream = Files.walk(path)) {
            List<Path> paths = stream
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

            for (Path currentPath : paths) {
                Files.deleteIfExists(currentPath);
            }
        }

        return true;
    }
}