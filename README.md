# *Thread Example with Java*

### Multi-Thread & Concurrency

---
I'm open to any contribution.

---

```
ExampleClass extends Thread OR ExampleClass implements Runnable{

    @Override
    public void run(){
        Write the recommended actions here
    }

    ExampleClass instance = new ExampleClass();
    Thread t1 = new Thread(instance);

    // runs the thread
    t1.start();

    //all commands below last join() method line waits for threads to finish process
    t1.join();

    //Creates a thread pool with size many elements
    ExecutorService pool = Executors.newFixedThreadPool(size);

    for(int i = 0; i < size, i++){
        pool.execute(instance) || pool.submit(instance);
    }

    //If not shutDown, app continues running 
    pool.shutDown();
    
}
