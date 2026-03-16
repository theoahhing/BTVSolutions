#include "FileUtils.h"

namespace FileUtils
{
    bool fileExists(const std::string& path)
    {
        std::ifstream file(path);
        return file.good();
    }

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

}