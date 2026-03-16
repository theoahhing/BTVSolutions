#pragma once

#ifndef _FILEUTILS_H
#define _FILEUTILS_H

#include "CommonIncludes.h"

namespace FileUtils
{
    bool fileExists(const std::string& path);
    std::vector<std::string> readLines(const std::string& path);
    std::string readAllText(const std::string& path);
    bool writeAllText(const std::string& path, const std::string& content);
    bool appendText(const std::string& path, const std::string& content);
}

#endif