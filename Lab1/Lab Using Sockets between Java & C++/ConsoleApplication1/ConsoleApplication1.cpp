#include <winsock2.h>
#include <iostream>

#pragma comment(lib, "Ws2_32.lib")

int main() {
    std::cout << "Server";
        WSADATA wsaData;
    int iResult = WSAStartup(MAKEWORD(2, 2), &wsaData);
    if (iResult != 0) {
        std::cout << "WSAStartup failed: " << iResult << std::endl;
        return 1;
    }

    SOCKET ListenSocket = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
    if (ListenSocket == INVALID_SOCKET) {
        std::cout << "socket failed: " << WSAGetLastError() << std::endl;
        WSACleanup();
        return 1;
    }

    sockaddr_in service;
    service.sin_family = AF_INET;
    service.sin_addr.s_addr = INADDR_ANY;
    service.sin_port = htons(4444);

    if (bind(ListenSocket, (SOCKADDR*)&service, sizeof(service)) == SOCKET_ERROR) {
        std::cout << "bind failed: " << WSAGetLastError() << std::endl;
        closesocket(ListenSocket);
        WSACleanup();
        return 1;
    }

    if (listen(ListenSocket, SOMAXCONN) == SOCKET_ERROR) {
        std::cout << "listen failed: " << WSAGetLastError() << std::endl;
        closesocket(ListenSocket);
        WSACleanup();
        return 1;
    }

    SOCKET AcceptSocket = accept(ListenSocket, NULL, NULL);
    if (AcceptSocket == INVALID_SOCKET) {
        std::cout << "accept failed: " << WSAGetLastError() << std::endl;
        closesocket(ListenSocket);
        WSACleanup();
        return 1;
    }

    char recvbuf[512];
    int recvbuflen = 512;
    int iSendResult;

    do {
        iResult = recv(AcceptSocket, recvbuf, recvbuflen, 0);
        if (iResult > 0) {
            std::cout << "Received from client: " << recvbuf << std::endl;

            // Send a string to the client
            std::string str = "Hello, client!\n";
            iSendResult = send(AcceptSocket, str.c_str(), str.length(), 0);
            if (iSendResult == SOCKET_ERROR) {
                std::cout << "send failed: " << WSAGetLastError() << std::endl;
                closesocket(AcceptSocket);
                WSACleanup();
                return 1;
            }
        }
        else if (iResult == 0) {
            std::cout << "Connection closing..." << std::endl;
        }
        else {
            std::cout << "recv failed: " << WSAGetLastError() << std::endl;
            closesocket(AcceptSocket);
            WSACleanup();
            return 1;
        }
    } while (iResult > 0);

    closesocket(AcceptSocket);
    WSACleanup();

    return 0;
}
