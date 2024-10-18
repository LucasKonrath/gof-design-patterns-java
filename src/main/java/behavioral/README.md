# Behavioral GOF Design Patterns

Behavioral patterns are concerned with algorithms and the assignment of responsibilities between objects. They characterize complex control flow that's difficult to follow at run-time. Here's a summary of the eleven Behavioral GOF Design Patterns:

## 1. [Chain of Responsibility](/src/main/java/behavioral/chain/of/responsibility/)

- Passes a request along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
- Decouples sender and receiver of a request based on type of request.

## 2. [Command](/src/main/java/behavioral/command/)

- Encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.
- Turns a request into a stand-alone object that contains all information about the request.

## 3. [Interpreter](/src/main/java/behavioral/interpreter/)

- Given a language, defines a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.
- Used to evaluate sentences or expressions in a simple language.

## 4. [Iterator](/src/main/java/behavioral/iterator/)

- Provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
- Allows traversing collections without exposing their internal structure.

## 5. [Mediator](/src/main/java/behavioral/mediator/)

- Defines an object that encapsulates how a set of objects interact.
- Promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently.

## 6. [Memento](/src/main/java/behavioral/memento/)

- Without violating encapsulation, captures and externalizes an object's internal state so that the object can be restored to this state later.
- Allows making snapshots of an object's state and restoring it in the future.

## 7. [Observer](/src/main/java/behavioral/observer/)

- Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- Allows defining a subscription mechanism to notify multiple objects about any events that happen to the object they're observing.

## 8. [State](/src/main/java/behavioral/state/)

- Allows an object to alter its behavior when its internal state changes. The object will appear to change its class.
- Lets an object change its behavior when its internal state changes, appearing as if the object changed its class.

## 9. [Strategy](/src/main/java/behavioral/strategy/)

- Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.
- Enables selecting an algorithm at runtime. Instead of implementing a single algorithm directly, code receives run-time instructions as to which in a family of algorithms to use.

## 10. [Template Method](/src/main/java/behavioral/template/method/)

- Defines the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
- Defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

## 11. [Visitor](/src/main/java/behavioral/visitor/)

- Represents an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.
- Lets you separate algorithms from the objects on which they operate.

These patterns address different behavioral challenges in software design, providing solutions for managing algorithms, relationships, and responsibilities between objects.
