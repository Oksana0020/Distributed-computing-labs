# Exercise 1

## Overview
This exercise demonstrates UDP communication between a receiver and sender using Java's DatagramSocket.

## Commands

### Step 1: Compile all Java files
```bash
cd c:\Users\oksan\Distributed_computing_labs\Lab1
javac *.java
```

### Step 2: Start the Receiver
Open a terminal and execute:
```bash
cd c:\Users\oksan\Distributed_computing_labs\Lab1
java Example1Receiver 5000
```
The receiver will wait on port 5000 for incoming UDP packets.

### Step 3: Send a Message
Open another terminal and execute:
```bash
cd c:\Users\oksan\Distributed_computing_labs\Lab1
java Example1Sender localhost 5000 "Hello world"
```

## Execution Results

### Sender Output:
```
Host Name: localhost
Host Address: 127.0.0.1
to String: localhost/127.0.0.1
Bound to port: 61223
Hello world
```

### Receiver Output:
```
Hello world
```

## Key Details
- **Receiver port:** 5000
- **Message sent:** "Hello world" (11 characters)
- **Maximum length allowed in receiver:** 12 characters
- **Status:** Successfully transmitted and received

## Requirements
- Java Development Kit (JDK) installed
- Both programs run on localhost (127.0.0.1)
- Message length must not exceed the buffer size (12 characters in my case)


# Exercise 2

## Overview
Exercise 2 demonstrates **bidirectional UDP communication** between two programs using custom MyDatagramSocket class. The programs can send and receive messages interactively in a conversation pattern.

## Program Description

### Example2ReceiverSender
- **Port:** 2000 (listening port)
- **Function:** Receives messages and sends replies
- **Interaction:** Waits for incoming messages, displays them, then prompts for a reply to send back

### Example2SenderReceiver
- **Port:** 2001 (listening port)
- **Target:** Sends to localhost:2000 (ReceiverSender)
- **Function:** Sends messages and receives replies
- **Interaction:** Prompts for user input, sends message, then waits for reply

## Commands

### Step 1: Compile all Java files 
```bash
cd c:\Users\oksan\Distributed_computing_labs\Lab1
javac *.java
```

### Step 2: Start ReceiverSender in Terminal 1
```bash
cd c:\Users\oksan\Distributed_computing_labs\Lab1
java Example2ReceiverSender
```
**Expected Output:**
```
Waiting to receive a message or 'exit' to quit
```

### Step 3: Start SenderReceiver in Terminal 2
```bash
cd c:\Users\oksan\Distributed_computing_labs\Lab1
java Example2SenderReceiver
```
**Expected Output:**
```
Enter a message to send or 'exit' to quit
Message:
```

## Example Interaction

### Terminal 1 (ReceiverSender):
```
Waiting to receive a message or 'exit' to quit
Received: Hello from sender
Reply: Hi back!
Received: How are you?
Reply: All good!
```

### Terminal 2 (SenderReceiver):
```
Enter a message to send or 'exit' to quit
Message:
Hello from sender
Received Message: Hi back!
Message:
How are you?
Received Message: All good!
Message:
exit
```

## Key Details
- **Bidirectional Communication:** Both programs can send and receive
- **Custom Socket Class:** Uses MyDatagramSocket wrapper for easier message handling
- **Interactive Mode:** Uses Scanner for user input
- **Termination:** Type "exit" in SenderReceiver to quit
- **Ports Used:** 
  - ReceiverSender: port 2000
  - SenderReceiver: port 2001
- **Network:** All communication on localhost (127.0.0.1)

## Requirements
- Both programs must be running simultaneously
- SenderReceiver initiates the conversation
- ReceiverSender waits for incoming messages
- Messages are not size-limited in this exercise (unlike Exercise 1)

