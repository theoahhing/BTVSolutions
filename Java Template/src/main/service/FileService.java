/*
     File Service class provides higher-level operations by combining file utilities with application logic such as
     validation, defaults, and error handling.
*/

package main.service;

import main.util.FileUtil;
import main.util.StringUtil;

import java.io.IOException;
import java.util.List;

/**
 * Service layer for file-related operations.
 * Provides higher-level logic built on top of FileUtil.
 */
public class FileService {

    /**
     * Reads the file content, returning null if the file does not exist.
     */
    public String read(String filePath) {
        FileUtil file = new FileUtil(filePath);

        if (!file.exists()) {
            return null;
        }

        try {
            return file.read();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Reads the file content, returning a default value if the file is missing or empty.
     */
    public String readOrDefault(String filePath, String defaultValue) {
        String content = read(filePath);

        return StringUtil.isBlank(content) ? defaultValue : content;
    }

    /**
     * Reads all lines from a file, or returns an empty list if the file does not exist.
     */
    public List<String> readLines(String filePath) {
        FileUtil file = new FileUtil(filePath);

        if (!file.exists()) {
            return List.of();
        }

        try {
            return file.readLines();
        } catch (IOException e) {
            return List.of();
        }
    }

    /**
     * Writes content to a file, replacing existing content.
     */
    public boolean write(String filePath, String content) {
        FileUtil file = new FileUtil(filePath);

        try {
            file.write(content);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Appends content to a file.
     */
    public boolean append(String filePath, String content) {
        FileUtil file = new FileUtil(filePath);

        try {
            file.append(content);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Creates a file if it does not already exist.
     */
    public boolean create(String filePath) {
        FileUtil file = new FileUtil(filePath);

        try {
            file.create();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Deletes a file if it exists.
     */
    public boolean delete(String filePath) {
        FileUtil file = new FileUtil(filePath);

        try {
            return file.delete();
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Returns true if the file exists.
     */
    public boolean exists(String filePath) {
        return new FileUtil(filePath).exists();
    }

    /**
     * Returns the file size in bytes, or -1 if the file does not exist or fails.
     */
    public long size(String filePath) {
        FileUtil file = new FileUtil(filePath);

        if (!file.exists()) {
            return -1;
        }

        try {
            return file.size();
        } catch (IOException e) {
            return -1;
        }
    }
}