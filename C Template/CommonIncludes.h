#pragma once

/*
    Please note that this header file only includes common header files; only add to this
    file if header file for repetitive includes across multiple files. It is suggested to
    locally include header files for one-off includes for optimisation.

    Also, this is just a template so add or remove based on project requirements.
*/

#ifndef _COMMONINCLUDES_H_
#define _COMMONINCLUDES_H_

#include <iostream>
#include <iomanip>
#include <sstream>
#include <fstream>
#include <istream>
#include <string>
#include <cstring>
#include <thread>
#include <chrono>
#include <vector>
#include <memory>
#include <ctime>
#include <numeric>
#include <mutex>
#include <future>
#include <map>
#include <utility>
#include <cerrno>
#include <condition_variable>

// C Libraries
#include <errno.h>
#include <stdlib.h>
#include <stdio.h>
// #include <dirent.h> -> Needs to be downloaded prior to using


// Cross-Platform/Compiler Compatibility
// Linux Platform
#ifdef linux
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/ioctl.h>
#include <linux/rtc.h>
#endif

// Windows Platform
#ifdef _WIN32
#include <direct.h>
#include "windows_specific.h"
#endif

// Unsigned Integer Macros
#define byte		uint8_t
#define leastByte	uint_least8_t
#define fastVyte	uint_fast8_t

#define word		uint16_t
#define leastWord	uint_least16_t
#define fastWord	uint_fast16_t

#define dblword		uint32_t
#define leastDWord	uint_least32_t
#define fastDWord	uint_fast32_t

#define qword		uint64_t
#define leastQWord	uint_least64_t
#define fastQWord	uint_fast64_t

#endif