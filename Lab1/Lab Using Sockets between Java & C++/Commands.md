# C++ Java Sockets Lab (Commands + Brief Description)

## Brief description
This lab compares **TCP stream sockets** across C++ and Java:
1. **C++ Server + C++ Client**: Works normally (same language/encoding).
2. **C++ Server + Java Client (Object serialization)**: Fails because C++ cannot decode Java serialized objects.
3. **C++ Server + Java Client (plain text)**: Works when the Java client **flushes** output and the C++ server replies with a newline so Java `readLine()` can complete.

## C++ build/run (Visual Studio projects)

### Build (Developer PowerShell or Visual Studio)
```powershell
# From this folder
cd "c:\Users\oksan\Distributed_computing_labs\Lab1\Lab Using Sockets between Java & C++"

# Build server
msbuild .\ConsoleApplication1\ConsoleApplication1.vcxproj /p:Configuration=Debug /p:Platform=x64

# Build client
msbuild .\ConsoleApplication4\ConsoleApplication4.vcxproj /p:Configuration=Debug /p:Platform=x64
```

### Run (two terminals)
```powershell
# Terminal 1 - C++ Server
.\ConsoleApplication1\x64\Debug\ConsoleApplication1.exe

# Terminal 2 - C++ Client
.\ConsoleApplication4\x64\Debug\ConsoleApplication4.exe
```

Expected:
- Server prints the received message and sends back "Hello, client!\n".
- Client prints the received message from the server.

## Java client tests (replace the C++ client)

### Compile Java clients
```powershell
cd "c:\Users\oksan\Distributed_computing_labs\Lab1\Lab Using Sockets between Java & C++"

javac JavaClientObject.java
javac JavaClientText.java
```

### Run Java client (Object serialization)
```powershell
# Terminal 1: Start C++ Server first
.\ConsoleApplication1\x64\Debug\ConsoleApplication1.exe

# Terminal 2: Run Java serialization client
java JavaClientObject
```
Outcome:
- Connection succeeds, but C++ server **cannot understand** Java serialized bytes.

### Run Java client (Plain text with flush)
```powershell
# Terminal 1: Start C++ Server first
.\ConsoleApplication1\x64\Debug\ConsoleApplication1.exe

# Terminal 2: Run Java text client
java JavaClientText
```
Outcome:
- C++ server receives "hello, server".
- Java client receives the server response because the server sends a newline.

## Notes
- **Flush is required** on Java output (`PrintWriter` with `autoFlush=true`) so the C++ server receives data.
- **Java `readLine()` blocks** until a line terminator is received. The C++ server must send `"\n"` at the end of its response.
- Encoding must match on both sides. ASCII/UTF-8/ISO-8859-1 typically work, UTF-16 does not unless both sides agree.
