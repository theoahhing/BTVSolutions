#include "FileUtils.h"

namespace FileUtils
{

    std::vector<std::string> readLines(const std::string& path)
    {
        std::vector<std::string> lines;
        std::ifstream file(path);

        if(!file.is_open())
            return lines;

        std::string line;
        while(std::getline(file, line))
        {
            lines.push_back(line);
        }

        return lines;
    }

    std::string readAllText(const std::string& path)
    {
        std::ifstream file(path);
        if(!file.is_open())
            return "";

        std::ostringstream buffer;
        buffer << file.rdbuf();

        return buffer.str();
    }

    std::size_t getFileSize(const std::string& path)
    {
        std::ifstream file(path, std::ios::binary | std::ios::ate);
        if(!file.is_open())
            return 0;

        return static_cast<std::size_t>(file.tellg());
    }

    bool fileExists(const std::string& path)
    {
        std::ifstream file(path);
        return file.good();
    }
    
    bool writeAllText(const std::string& path, const std::string& content)
    {
        std::ofstream file(path);
        if(!file.is_open())
            return false;

        file << content;
        return true;
    }

    bool appendText(const std::string& path, const std::string& content)
    {
        std::ofstream file(path, std::ios::app);
        if(!file.is_open())
            return false;

        file << content;
        return true;
    }

    bool deleteFile(const std::string& path)
    {
        return (std::remove(path.c_str()) == 0);
    }

}