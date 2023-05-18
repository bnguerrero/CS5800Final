# CS5800Final
## Strategy and Observer Design Patterns
Design a weather forecasting system that allows multiple weather services to be used to get weather
updates. Each weather service (weatherapi, weather.gov and open-Meteo) has its own API and data
format, and the system should be able to work with any combination of services. The system should also
allow users to subscribe to specific weather updates and receive real-time notifications.


1) Create a Class UML showing your overall design (Due by end of day Friday, 5/12)
2) Implement the solution in Java with a Driver utilizing all the features


## Command and Template Design Pattern
Design a Digital Assistant Application that can process user requests and execute them using the
Command design pattern. The application must be able to handle different types of requests such as
making phone calls, sending emails, playing music, and setting reminders. Additionally, the application
must utilize the Template design pattern to provide a consistent structure for handling user requests.

The Template design pattern will be used to define a template for processing user requests. The
template will have a series of steps that are common to all requests, such as validating user input,
logging the request, and notifying the user of the request status. The specific implementation of each
step can be left to the subclasses of the template.

The Command design pattern will be used to encapsulate the user request as an object that can be
executed by the application. Each command will have a specific receiver, which will be responsible for
executing the command. For example, the receiver for a command to make a phone call could be the
phone dialer application on the user's device.

Driver:
Implement the solution in Java with a Driver utilizing all the features
