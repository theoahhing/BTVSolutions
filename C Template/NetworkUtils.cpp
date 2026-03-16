#include "NetworkUtils.h"

#ifdef _WIN32
    #include <winsock2.h>
    #include <ws2tcpip.h>
    #pragma comment(lib, "ws2_32.lib")
#else
    #include <unistd.h>
    #include <arpa/inet.h>
    #include <sys/socket.h>
    #include <netinet/in.h>
    #include <fcntl.h>
#endif

namespace NetworkUtils
{
    bool initialiseSockets(void)
    {
        #ifdef _WIN32
            WSADATA wsaData;
            return (WSAStartup(MAKEWORD(2, 2), &wsaData) == 0);
        #else
            return true;
        #endif
    }

    void cleanupSockets(void)
    {
        #ifdef _WIN32
            WSACleanup();
        #endif
    }

    bool isValidIPv4(const std::string& ipAddress)
    {
        sockaddr_in sa;
        return (inet_pton(AF_INET, ipAddress.c_str(), &(sa.sin_addr)) == 1);
    }

    bool testTcpConnection(const std::string& ipAddress, unsigned short port, int timeoutMs = 3000)
    {
        if (!isValidIPv4(ipAddress))
            return false;

        int sockfd = socket(AF_INET, SOCK_STREAM, 0);
        if (sockfd < 0)
            return false;

        sockaddr_in serverAddr;
        std::memset(&serverAddr, 0, sizeof(serverAddr));
        serverAddr.sin_family = AF_INET;
        serverAddr.sin_port = htons(port);

        if (inet_pton(AF_INET, ipAddress.c_str(), &serverAddr.sin_addr) <= 0)
        {
            #ifdef _WIN32
                closesocket(sockfd);
            #else
                close(sockfd);
            #endif
                return false;
        }

        #ifdef _WIN32
            u_long mode = 1;
            ioctlsocket(sockfd, FIONBIO, &mode);
        #else
            int flags = fcntl(sockfd, F_GETFL, 0);
            fcntl(sockfd, F_SETFL, flags | O_NONBLOCK);
        #endif

            int result = connect(sockfd, reinterpret_cast<sockaddr*>(&serverAddr), sizeof(serverAddr));

        #ifdef _WIN32
            if (result == SOCKET_ERROR && WSAGetLastError() != WSAEWOULDBLOCK)
            {
                closesocket(sockfd);
                return false;
            }
        #else
            if (result < 0 && errno != EINPROGRESS)
            {
                close(sockfd);
                return false;
            }
        #endif

        fd_set writeSet;
        FD_ZERO(&writeSet);
        FD_SET(sockfd, &writeSet);

        timeval timeout;
        timeout.tv_sec = timeoutMs / 1000;
        timeout.tv_usec = (timeoutMs % 1000) * 1000;

        result = select(sockfd + 1, nullptr, &writeSet, nullptr, &timeout);

        bool connected = false;

        if (result > 0 && FD_ISSET(sockfd, &writeSet))
        {
            int socketError = 0;
            #ifdef _WIN32
                    int len = sizeof(socketError);
                    getsockopt(sockfd, SOL_SOCKET, SO_ERROR, reinterpret_cast<char*>(&socketError), &len);
            #else
                    socklen_t len = sizeof(socketError);
                    getsockopt(sockfd, SOL_SOCKET, SO_ERROR, &socketError, &len);
            #endif
                    connected = (socketError == 0);
        }

        #ifdef _WIN32
            closesocket(sockfd);
        #else
            close(sockfd);
        #endif

        return connected;
    }
}