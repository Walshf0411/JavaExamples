# Mutli-threading
## Basic multi threading
We can perform multi threading in the following ways
* Extending `Thread` class
* Implementing `Runnable` interface

When we extend `Thread` class, our thread can be started simply by calling the start method on the thread object.
However, when we implement `Runnable` interface, we have to create the object of our class and create a thread
object using it.

But if we implement `Runnable` interface, we can extend other classes & interfaces.
Another benefit is that we `Runnable` objects are used for many other threading frameworks like ExecutorService, 
ForkJoin, etc & even in `Callable`.

**Note:** If we extend `Thread` class and call the run method on the object, it will run like any other class method, 
it won't start the thread.

## Advanced multi threading

### Fork/Join Framework
This framework works by dividing tasks into smaller tasks, complete all the tasks, get results from all of them and 
join and return the result.

To create a ForkJoinPool, you can 
`ForkJoinPool pool = ForkJoinPool.commonPool()`

Alternatively it can be instantiated by using the constructor, the thread count, exception handler etc can be set.

#### Submitting tasks to the pool

* Submitting tasks using Runnable/Callable implmentations

```java
pool.submit(() -> System.out.println("asdas")); // Runnable
ForkJoinTask<String> callableTask = pool.submit(() -> "Walsh"); // Callable
ForkJoinTask<String> runnableTask2 = pool.submit(() -> System.out.println("asdas"), "walsh"); // Runnable with result
```

* Submitting tasks using ForkJoinTask implementation

```java
// RecursiveAction -> for tasks that need not return data.
RecursiveAction recursiveAction = new CustomRecursiveAction(generateRandomString(100));
pool.submit(recursiveAction).get();

// RecursiveTask -> for tasks that return data.
RecursiveTask<Integer> recursiveTask = new CustomRecursiveTask(generateRandomArray(100));
		logger.info("Final sum: " + pool.submit(recursiveTask).get());
```

**Note:** The get method blocks the current thread until execution is completed. However, if we dont call the get method, and simply submit the task to the pool & the main method has nothing else to do the application would exit, without the tasks completing.


Source: [https://www.baeldung.com/java-fork-join](https://www.baeldung.com/java-fork-join)










