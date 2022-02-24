# Jakarta Concurrency
- Deploy JakartaConcurrency-1.0-SNAPSHOT

To test these examples, go to http://localhost:8080/JakartaConcurrency-1.0-SNAPSHOT/JakartaConcurrency/concurrency/{path-at-method} and in the logs you'll see the output of that showcase.

---
### Tutorial Notes (23/02/2022)

- Concurrency Jakarta EE vs Java SE
  - Java SE concurrency is executors, scheduled executors, future etc
  - Jakarta Concurrency is an extension to Java SE Concurrency API
  - When running in an application server environment - You want it to be managed for security and other managers like threadpools
    - Can define the thread pool in the application server and then have all applications used that server managed pool


- ManagedExecutorService - Used for submitting asynchronous tasks
- ManagedSchedulesExecutorServices - Used for scheduling asynchronous tasks
- ManagedThreadFactory - Used for creating managed threads
- ContextService - Used for creating contextual objects

Within an application, deployed to an EE application server - executorPool.newSingleThreadExecutor(future) wouldn't have any context. If you used the context service with the managed thread factory you will be able to do the same but have all the context.

- All looked up via JNDI or Resource annotation - Can't use @Inject, must use @Resource instead
- Default executor service always available, additional resources can be created
- You can define multiple executor services from within the application server eg to allocate different number of threads


#### Exceptions
- Future.get() throws Execution or Interrupted exception
- CompletableFuture methods:
  - exceptionally
  - handle
  - isCompletedExceptionally
- ManagedTaskListener - listen and react to lifecycle events of a ManagedTask (eg. taskAborted)

#### Extras
- Can configure managed executor pools with web.xml

#### Payara Concurrency
- Payara uses the reference implementation - concurrency-ri
  - Previously called cu-ri
- Implementation modules in appserver/concurrent
  - concurrent-connector module - Config beans for concurrent resources
  - concurrent-imp module - Implementation of default resources as HK2 services, admin commands, context propagation and GMBAL monitoring

#### Triggers
- Used to programmatically define when something should run
