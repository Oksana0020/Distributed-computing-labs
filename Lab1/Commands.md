# Exercise 1
### Step 1: Compile all Java files
cd c:\Users\oksan\Distributed_computing_labs\Lab1
javac *.java

### Step 2: Start the Receiver
cd c:\Users\oksan\Distributed_computing_labs\Lab1
java Example1Receiver 5000
The receiver will wait on port 5000 for incoming UDP packets.

### Step 3: Send a Message
Open another terminal and execute:
cd c:\Users\oksan\Distributed_computing_labs\Lab1
java Example1Sender localhost 5000 "Hello world"
# Exercise 2
### Step 1: Compile all Java files
cd c:\Users\oksan\Distributed_computing_labs\Lab1
javac *.java

### Step 2: Start ReceiverSender in Terminal 1
cd c:\Users\oksan\Distributed_computing_labs\Lab1
java Example2ReceiverSender
### Step 3: Start SenderReceiver in Terminal 2
cd c:\Users\oksan\Distributed_computing_labs\Lab1
java Example2SenderReceiver

## Example Interaction

### Terminal 1 (ReceiverSender):
Waiting to receive a message or 'exit' to quit
Received: Hello from sender
Reply: Hi back!
Received: How are you?
Reply: All good!

### Terminal 2 (SenderReceiver):
Enter a message to send or 'exit' to quit
Message:
Hello from sender
Received Message: Hi back!
Message:
How are you?
Received Message: All good!
Message:
exit
# Exercise 3: Stream Sockets
### Step 1: Compile all files
cd c:\Users\oksan\Distributed_computing_labs\Lab1
javac *.java

### Step 2: Start the Receiver (Server) - Terminal 1
cd c:\Users\oksan\Distributed_computing_labs\Lab1
java Example3Receiver 2000 "Hello and Welcome Client"

### Step 3: Start the Sender (Client) - Terminal 2
cd c:\Users\oksan\Distributed_computing_labs\Lab1
java Example3Sender localhost 2000

# Exercise 4: Stream Sockets with MyStreamSocket Wrapper (Homework)

### Step 1: Compile all files
cd c:\Users\oksan\Distributed_computing_labs\Lab1
javac *.java

### Step 2: Start the Receiver (Server) - Terminal 1
cd c:\Users\oksan\Distributed_computing_labs\Lab1
java Example4Receiver 12345 "Hello from wrapper"

### Step 3: Start the Sender (Client) - Terminal 2
cd c:\Users\oksan\Distributed_computing_labs\Lab1
java Example4Sender localhost 12345

## COMMANDS to fix terminal
### step1
$PROFILE
Split-Path $PROFILE
Test-Path (Split-Path $PROFILE)

### step2
$dir = Split-Path $PROFILE
New-Item -ItemType Directory -Force $dir
New-Item -ItemType File -Force $PROFILE
Test-Path $PROFILE

### step3
@'
Set-Alias java "C:\Users\T00243562\.jdks\openjdk-25.0.2\bin\java.exe"
Set-Alias javac "C:\Users\T00243562\.jdks\openjdk-25.0.2\bin\javac.exe"
'@ | Set-Content -Path $PROFILE -Encoding UTF8

### step4
. $PROFILE
java -version
javac -version

### step5
cd "C:\Users\T00243562\IdeaProjects\Distributed-computing-labs\Lab1"
javac *.java
java Example1Receiver 5000