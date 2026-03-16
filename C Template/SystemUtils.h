#pragma once

#ifndef _SYSTEMUTILS_H
#define _SYSTEMUTILS_H

#include "CommonIncludes.h"

namespace SystemUtils
{
    std::string getCurrentWorkingDirectory(void);

    std::string getEnvironmentVariable(const std::string& name);

    std::string getUsername(void);

    std::string getHostname(void);

    unsigned int getCPUCount(void);
}

#endif