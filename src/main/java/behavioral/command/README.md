# Command Design Pattern

The Command pattern is a behavioral design pattern that encapsulates a request as an object, thereby allowing for the parameterization of clients with different requests, queue or log requests, and support undoable operations.

The pattern consists of the following components:

1. **Command**: An interface or abstract class that defines the contract for executing an operation.
2. **Concrete Commands**: Implementations of the Command interface that encapsulate specific operations.
3. **Receiver**: The component that performs the actual operation when the `execute` method of a concrete command is called.
4. **Invoker**: The component that initiates the execution of a command by calling its `execute` method.
5. **Client**: The component that creates concrete command objects and associates them with receivers.

The key benefits of using the Command pattern include:

- Decoupling the object that invokes the operation from the object that performs the operation
- Allowing for the creation of composite commands (a series of commands)
- Supporting undo/redo operations
- Allowing for the logging and queueing of commands

## Java Code Example

```java
// Command interface
public interface Command {
    void execute();
}

// Concrete Command
public class OpenCameraCommand implements Command {

    private MobilePlatformReceiver mobilePlatform;

    public OpenCameraCommand(MobilePlatformReceiver mobilePlatform){
        this.mobilePlatform = mobilePlatform;
    }

    @Override
    public void execute() {
        this.mobilePlatform.openCamera();
    }
}

// Receiver
public interface MobilePlatformReceiver {
    void openCamera();
}

// Concrete receiver 1
public class AndroidMobilePlatform implements MobilePlatformReceiver {
    @Override
    public void openCamera() {
        System.out.println("Opening camera in Android");
    }
}

// Concrete receiver 2
public class IosMobilePlatform implements MobilePlatformReceiver {
    @Override
    public void openCamera() {
        System.out.println("Opening camera in iOS");
    }
}

// Invoker
public class CommandInvoker {

    public Command command;

    public CommandInvoker(Command command) {
        this.command = command;
    }

    public void execute() {
        this.command.execute();
    }
}
```

### Test
```java
    @Test
    public void test(){
        MobilePlatformReceiver ios = new IosMobilePlatform();

        OpenCameraCommand openCameraCommandIos = new OpenCameraCommand(ios);
        openCameraCommandIos.execute();

        MobilePlatformReceiver android = new AndroidMobilePlatform();
        OpenCameraCommand openCameraCommandAndroid = new OpenCameraCommand(android);
        openCameraCommandAndroid.execute();
    }
```
### Output
```
Opening camera in iOS
Opening camera in Android
```

In this example, we have one concrete commands, `OpenCameraCommand` that implements the `Command` interface. The `MobilePlatformReceiver` class is the interface receiver, and it has implementations that perform the actual operations of opening the camera.

The `CommandInvoker` class is the invoker, which holds a reference to a command object and executes its `execute` method when the `openCamera` method is called.

This example demonstrates how the Command pattern decouples the object that invokes the operation (the invoker) from the object that performs the operation (the receiver), allowing for the parameterization of clients with different requests.

Tests found [here](../../../../../src/test/java/behavioral/command)