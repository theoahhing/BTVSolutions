/*
     Directory Service class provides higher-level operations by combining directory utilities with application logic
     such as validation, defaults, and error handling.
*/

package main.service;

import main.util.DirectoryUtil;
import main.util.PathUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Service layer for dir-related operations.
 * Provides higher-level logic built on top of DirectoryUtil.
 */
public class DirectoryService {

    /**
     * Returns true if the dir exists.
     */
    public boolean exists(String dirPath) {
        return new DirectoryUtil(dirPath).exists();
    }

    /**
     * Creates the dir if it does not already exist.
     */
    public boolean create(String dirPath) {
        DirectoryUtil dir = new DirectoryUtil(dirPath);

        try {
            dir.create();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Creates the dir and any missing parent dirs.
     */
    public boolean createDirectories(String dirPath) {
        DirectoryUtil dir = new DirectoryUtil(dirPath);

        try {
            dir.createDirectories();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Creates the dir only if it does not already exist.
     */
    public boolean createIfMissing(String dirPath) {
        DirectoryUtil dir = new DirectoryUtil(dirPath);

        if (dir.exists()) {
            return true;
        }

        try {
            dir.createDirectories();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Returns true if the dir is empty.
     */
    public boolean isEmpty(String dirPath) {
        DirectoryUtil dir = new DirectoryUtil(dirPath);

        if (!dir.exists()) {
            return false;
        }

        try {
            return dir.isEmpty();
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Lists all entries in the dir, or returns an empty list if the dir does not exist.
     */
    public List<Path> list(String dirPath) {
        DirectoryUtil dir = new DirectoryUtil(dirPath);

        if (!dir.exists()) {
            return List.of();
        }

        try {
            return dir.list();
        } catch (IOException e) {
            return List.of();
        }
    }

    /**
     * Lists all files in the dir, or returns an empty list if the dir does not exist.
     */
    public List<Path> listFiles(String dirPath) {
        DirectoryUtil dir = new DirectoryUtil(dirPath);

        if (!dir.exists()) {
            return List.of();
        }

        try {
            return dir.listFiles();
        } catch (IOException e) {
            return List.of();
        }
    }

    /**
     * Lists all sub-dirs in the dir, or returns an empty list if the dir does not exist.
     */
    public List<Path> listDirectories(String dirPath) {
        DirectoryUtil dir = new DirectoryUtil(dirPath);

        if (!dir.exists()) {
            return List.of();
        }

        try {
            return dir.listDirectories();
        } catch (IOException e) {
            return List.of();
        }
    }

    /**
     * Deletes the dir if it exists.
     */
    public boolean delete(String dirPath) {
        DirectoryUtil dir = new DirectoryUtil(dirPath);

        try {
            return dir.delete();
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Recursively deletes the dir and all its contents.
     */
    public boolean deleteRecursively(String dirPath) {
        DirectoryUtil dir = new DirectoryUtil(dirPath);

        try {
            return dir.deleteRecursively();
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Returns the dir path as a Path object.
     */
    public Path getPath(String dirPath) {
        return new DirectoryUtil(dirPath).getPath();
    }

    /**
     * Returns the dir name, or empty string if unavailable.
     */
    public String getName(String dirPath) {
        return new DirectoryUtil(dirPath).getName();
    }

    /**
     * Resolves a child path against the given dir path.
     */
    public Path resolve(String dirPath, String childName) {
        return PathUtil.resolve(dirPath, childName);
    }

    /**
     * Returns the parent dir path, or null if unavailable.
     */
    public String getParent(String dirPath) {
        return PathUtil.getParent(dirPath);
    }

    /**
     * Returns a normalized version of the dir path.
     */
    public Path normalize(String dirPath) {
        return PathUtil.normalize(dirPath);
    }
}