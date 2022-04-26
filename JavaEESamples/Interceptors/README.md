## How to use Interceptor demo:

### Prerequisites

- Compile the Interceptors Module
- Deploy to any version of Payara

### EJB Timer
The EJB timer demo has 2 ejb timers which log a message every 15 and 30 seconds respectively. The TimerInterceptor checks the method name, and will only let methods not called "fifteenSeconds" proceed. 

You will observe the timer only logs a message every 30 seconds.

### Car Constructor
Navigate to http://localhost:8080/Interceptors-1.0-SNAPSHOT/Interceptors/simplecars and observe the logs, you will see the Around Construct, Post Construct and Invoke interceptor being hit.

### JAX-RS Car
After the Interceptors Module has been deployed to Payara, run the JaxRSCarDemo.http file to execute 3 sample requests. You will observe the car with the banned colour was not created, returning 500 and logging a warning to the server, as the interceptor did not allow for that method to proceed. The first two requests both execute successfully.