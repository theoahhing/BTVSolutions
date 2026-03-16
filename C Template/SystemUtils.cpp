#include "SystemUtils.h"

#ifdef _WIN32
    #include <windows.h>
    #include <Lmcons.h>
#else
    #include <unistd.h>
    #include <limits.h>
#endif

namespace SystemUtils
{
    std::string getCurrentWorkingDirectory(void)
    {
        char buffer[1024] = { 0 };
        
        #ifdef _WIN32
            if (_getcwd(buffer, sizeof(buffer)) != nullptr)
        #else
            if (getcwd(buffer, sizeof(buffer)) != nullptr)
        #endif
        {
            return std::string(buffer);
        }

        return "";
    }

    std::string getEnvironmentVariable(const std::string& name)
    {
        const char* value = std::getenv(name.c_str());
        return (value != nullptr) ? std::string(value) : "";
    }

    std::string getUsername(void)
    {
        #ifdef _WIN32
            char username[UNLEN + 1] = { 0 };
            dblword usernameLength = UNLEN + 1;

            if (GetUserNameA(username, &usernameLength))
            {
                return std::string(username);
            }
        #else
            const char* username = std::getenv("USER");
            if (username != nullptr)
            {
                return std::string(username);
            }
        #endif

        return "";
    }

    std::string getHostname(void)
    {
        char hostname[256] = { 0 };

        #ifdef _WIN32
            DWORD size = sizeof(hostname);
            if (GetComputerNameA(hostname, &size))
            {
                return std::string(hostname);
            }
        #else
            if (gethostname(hostname, sizeof(hostname)) == 0)
            {
                return std::string(hostname);
            }
        #endif

        return "";
    }

    unsigned int getCPUCount(void)
    {
        unsigned int count = std::thread::hardware_concurrency();
        return (count == 0) ? 1 : count;
    }
}