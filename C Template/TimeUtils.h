#pragma once

#ifndef _DATETIME_H
#define _DATETIME_H

#include "CommonIncludes.h"

class DateTime {

private:

	std::string time, date, recordingTime, startTime;
	int hrPass, minPass, secPass;
	bool stopTime;

public:

	DateTime(void);

	std::string getTime(void);

	std::string getTimeElapsed(void);

	void startRecording(void);

	void startTimer(void);

	void stopTimer(void);

	std::string getDate(void);

	~DateTime(void);

};

#endif