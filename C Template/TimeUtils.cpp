#include "TimeUtils.h"

TimeUtils::TimeUtils(void)
	:   stopTime(true),
        recordingTime("00:00:00"),
        startTime("00:00:00"),
	    hrPass(0),
        minPass(0),
        secPass(0)
{	
}

std::string TimeUtils::getTime(void)
{
    auto now = std::chrono::system_clock::now();
    std::time_t nowTime = std::chrono::system_clock::to_time_t(now);

    std::tm localTime{};

    #ifdef _WIN32
        localtime_s(&localTime, &nowTime);
    #else
        localtime_r(&nowTime, &localTime);
    #endif

    std::ostringstream oss;
    oss << std:put_time(&localTime, "%H:%M:%S");

    time = oss.str();

	return time;
}

std::string TimeUtils::getDate(void)
{
	auto now = std::chrono::system_clock::now();
    std::time_t nowDate = std::chrono::system_clock::to_time_t(now);

    std::tm localDate{};

    #ifdef _WIN32
        localtime_s(&localDate, &nowDate);
    #else
        localtime_r(&nowDate, &localDate);
    #endif

    std::ostringstream oss;
    oss << std::put_time(&localDate, "%Y-%m-%d");

    date = oss.str();
    
    return date;
}

std::string TimeUtils::getTimeElapsed(void)
{
	return recordingTime;
}

void TimeUtils::startRecording(void)
{
	stopTime = false;
	
	hrPass = 0;
	minPass = 0;
	secPass = 0;
	
    recordingTime = "00:00:00";

    startTimer();
}

void TimeUtils::startTimer(void)
{
    while(!stopTime)
    {
        std::this_thread::sleep_for(std::chrono::seconds(1));

        secPass++;

        if(secPass >= 60)
        {
            secPass = 0;
            minPass++;
        }
        if(minPass >= 60)
        {
            minPass = 0;
            hrPass++;
        }

        std::ostringstream oss;
        oss << std::setw(2) << std::setfill('0') << hrPass << ":"
            << std::setw(2) << std::setfill('0') << minPass << ":"
            << std::setw(2) << std::setfill('0') << secPass;
        
        recordingTime = oss.str();

        std::cout << recordingTime << std::endl;
    }
}

void TimeUtils::stopTimer(void)
{
	stopTime = true;
}

TimeUtils::~TimeUtils(void)
{
	
}