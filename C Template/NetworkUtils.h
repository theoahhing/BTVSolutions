#pragma once

#ifndef _NETWORKUTILS_H
#define _NETWORKUTILS_H

#include "CommonIncludes.h"

namespace NetworkUtils
{
    bool initialiseSockets(void);

    void cleanupSockets(void);

    bool isValidIPv4(const std::string& ipAddress);

    bool testTcpConnection(const std::string& ipAddress, unsigned short port, int timeoutMs = 3000);
}

#endif