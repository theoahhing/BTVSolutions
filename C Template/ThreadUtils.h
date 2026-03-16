#pragma once

#ifndef _THREADUTILS_H
#define _THREADUTILS_H

#include "CommonIncludes.h"

namespace ThreadUtils
{
    void sleepMs(unsigned int milliseconds);

    void sleepSeconds(unsigned int seconds);

    unsigned int getHardwareThreadCount();

    template<typename Callable, typename... Args>
    std::thread runAsync(Callable&& func, Args&&... args)
    {
        return std::thread(std::forward<Callable>(func), std::forward<Args>(args)...);
    }

    void safeJoin(std::thread& worker);

    bool isJoinable(std::thread& worker);
}

#endif