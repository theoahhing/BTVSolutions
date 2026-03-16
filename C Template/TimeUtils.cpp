#include "DateTime.h"

DateTime::DateTime(void)
	:time(__TIME__), date(__DATE__), stopTime(true), recordingTime("00:00:00"), startTime("00:00:00"),
	hrPass(0), minPass(0), secPass(0)
{
	
}

std::string DateTime::getTime(void) {
	return __TIME__;
}

std::string DateTime::getDate(void) {
	return __DATE__;
}

std::string DateTime::getTimeElapsed(void) {
	return this->recordingTime;
}

void DateTime::startRecording(void) {
	this->stopTime = false;
	this->startTime = __TIME__;
	this->hrPass = 0;
	this->minPass = 0;
	this->secPass = 0;
	startTimer();
}

void DateTime::startTimer(void) {

	auto start = std::chrono::seconds();
	std::this_thread::sleep_for(std::chrono::seconds(1));
	auto end = std::chrono::seconds();

	if (this->secPass < 59) {
		this->secPass++;
		this->recordingTime = std::to_string(this->minPass) + ":" + std::to_string(this->secPass);
	}
	else {
		this->secPass = 0; this->minPass++;
		this->recordingTime = std::to_string(this->minPass) + ":" + std::to_string(this->secPass);
	}
	
	std::cout << this->recordingTime << std::endl;

	if (!this->stopTime)
		this->startTimer();
}

void DateTime::stopTimer(void) {
	this->stopTime = true;
}

DateTime::~DateTime(void){
	
}