/*
    Path utilities class provides helper methods for manipulating and analyzing file system paths, including retrieving
    names, extensions, and resolving/normalizing paths, without interacting with the file system.
*/

package main.util;

import java.nio.file.Path;
import java.util.Objects;

/**
 * Utility methods for working with file system paths.
 */
public final class PathUtil {

    private PathUtil() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Converts a string to a Path.
     */
    public static Path of(String path) {
        return Path.of(path);
    }

    /**
     * Joins path parts into a single Path.
     */
    public static Path join(String first, String... more) {
        return Path.of(first, more);
    }

    /**
     * Returns the file or directory name from the path, or an empty string if unavailable.
     */
    public static String getName(Path path) {
        if (path == null) {
            return "";
        }

        Path fileName = path.getFileName();
        return fileName != null ? fileName.toString() : "";
    }

    /**
     * Returns the file or directory name from the path string, or an empty string if unavailable.
     */
    public static String getName(String path) {
        if (path == null) {
            return "";
        }

        return getName(Path.of(path));
    }

    /**
     * Returns the file name without its extension.
     */
    public static String getBaseName(Path path) {
        String name = getName(path);
        int dotIndex = name.lastIndexOf('.');

        if (dotIndex <= 0) {
            return name;
        }

        return name.substring(0, dotIndex);
    }

    /**
     * Returns the file name without its extension.
     */
    public static String getBaseName(String path) {
        if (path == null) {
            return "";
        }

        return getBaseName(Path.of(path));
    }

    /**
     * Returns the file extension, or an empty string if none exists.
     */
    public static String getExtension(Path path) {
        String name = getName(path);
        int dotIndex = name.lastIndexOf('.');

        if (dotIndex <= 0 || dotIndex == name.length() - 1) {
            return "";
        }

        return name.substring(dotIndex + 1);
    }

    /**
     * Returns the file extension, or an empty string if none exists.
     */
    public static String getExtension(String path) {
        if (path == null) {
            return "";
        }

        return getExtension(Path.of(path));
    }

    /**
     * Returns true if the path has an extension.
     */
    public static boolean hasExtension(Path path) {
        return !getExtension(path).isEmpty();
    }

    /**
     * Returns true if the path has an extension.
     */
    public static boolean hasExtension(String path) {
        if (path == null) {
            return false;
        }

        return hasExtension(Path.of(path));
    }

    /**
     * Returns true if the path has the given extension, ignoring case.
     */
    public static boolean hasExtension(Path path, String extension) {
        if (extension == null) {
            return false;
        }

        return getExtension(path).equalsIgnoreCase(extension);
    }

    /**
     * Returns true if the path has the given extension, ignoring case.
     */
    public static boolean hasExtension(String path, String extension) {
        if (path == null) {
            return false;
        }

        return hasExtension(Path.of(path), extension);
    }

    /**
     * Returns the parent path, or null if no parent exists.
     */
    public static Path getParent(Path path) {
        return path == null ? null : path.getParent();
    }

    /**
     * Returns the parent path as a string, or null if no parent exists.
     */
    public static String getParent(String path) {
        if (path == null) {
            return null;
        }

        Path parent = Path.of(path).getParent();
        return parent != null ? parent.toString() : null;
    }

    /**
     * Returns a normalized version of the path.
     */
    public static Path normalize(Path path) {
        return path == null ? null : path.normalize();
    }

    /**
     * Returns a normalized version of the path.
     */
    public static Path normalize(String path) {
        return path == null ? null : Path.of(path).normalize();
    }

    /**
     * Returns true if the path is absolute.
     */
    public static boolean isAbsolute(Path path) {
        return path != null && path.isAbsolute();
    }

    /**
     * Returns true if the path is absolute.
     */
    public static boolean isAbsolute(String path) {
        return path != null && Path.of(path).isAbsolute();
    }

    /**
     * Returns true if the path is relative.
     */
    public static boolean isRelative(Path path) {
        return path != null && !path.isAbsolute();
    }

    /**
     * Returns true if the path is relative.
     */
    public static boolean isRelative(String path) {
        return path != null && !Path.of(path).isAbsolute();
    }

    /**
     * Resolves one path against another.
     */
    public static Path resolve(Path basePath, String other) {
        if (basePath == null || other == null) {
            return null;
        }

        return basePath.resolve(other);
    }

    /**
     * Resolves one path against another.
     */
    public static Path resolve(String basePath, String other) {
        if (basePath == null || other == null) {
            return null;
        }

        return Path.of(basePath).resolve(other);
    }

    /**
     * Returns the relative path from one path to another.
     */
    public static Path relativize(Path basePath, Path targetPath) {
        if (basePath == null || targetPath == null) {
            return null;
        }

        return basePath.relativize(targetPath);
    }

    /**
     * Returns true if both paths are equal after normalization.
     */
    public static boolean equalsNormalized(Path first, Path second) {
        if (first == null || second == null) {
            return first == second;
        }

        return first.normalize().equals(second.normalize());
    }

    /**
     * Returns true if both paths are equal after normalization.
     */
    public static boolean equalsNormalized(String first, String second) {
        if (first == null || second == null) {
            return Objects.equals(first, second);
        }

        return equalsNormalized(Path.of(first), Path.of(second));
    }
}
