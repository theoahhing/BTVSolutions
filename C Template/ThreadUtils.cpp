#include "ThreadUtils.h"

namespace ThreadUtils
{

void sleepMs(unsigned int milliseconds)
{
    std::this_thread::sleep_for(std::chrono::milliseconds(milliseconds));
}

void sleepSeconds(unsigned int seconds)
{
    std::this_thread::sleep_for(std::chrono::seconds(seconds));
}

unsigned int getHardwareThreadCount()
{
    unsigned int count = std::thread::hardware_concurrency();
    return (count == 0) ? 1 : count;
}

void safeJoin(std::thread& worker)
{
    if (worker.joinable())
    {
        worker.join();
    }
}

bool isJoinable(std::thread& worker)
{
    return worker.joinable();
}

}