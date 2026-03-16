#pragma once

#ifndef _TIMEUTILS_H
#define _TIMEUTILS_H

#include "CommonIncludes.h"

class TimeUtils {

private:

	std::string time, date, recordingTime, startTime;
	int hrPass, minPass, secPass;
	bool stopTime;

public:

	TimeUtils(void);

	std::string getTime(void);
    std::string getDate(void);
	std::string getTimeElapsed(void);

	void startRecording(void);
	void startTimer(void);
	void stopTimer(void);

	~TimeUtils(void);

};

#endif