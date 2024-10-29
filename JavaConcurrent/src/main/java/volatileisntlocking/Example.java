package volatileisntlocking;

import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

class Counter implements Runnable {
//  /*volatile*/ long counter = 0;
  AtomicLong counter = new AtomicLong();
  ReentrantLock lock = new ReentrantLock();

  @Override
  public void run() {
    for (int x = 0; x < 1_000_000_000; x++) {
      // like a door that has a single key hanging outside
      // succeeding with the call (and proceeding) implies THIS THREAD took that key
//      lock.lock();
//      try {
//        counter++;
//      } finally {
//        lock.unlock(); // hand the key back outside the door
//      }
      counter.incrementAndGet();
    }
  }
}

public class Example {
  public static void main(String[] args) throws InterruptedException {
    Counter c = new Counter();
    Thread t1 = new Thread(c);
    Thread t2 = new Thread(c);

    long start = System.nanoTime();
    t1.start();
    t2.start();

    t1.join();
    t2.join();
    long totalTime = System.nanoTime() - start;
    System.out.println("counter value is " + c.counter + " time was " + totalTime);
  }
}
