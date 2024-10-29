package runnables;

class Job implements Runnable {
  @Override
  public void run() {
    System.out.println("Job starting");
    for (int x = 0; x < 1_000; x++) {
      System.out.println(Thread.currentThread().getName() + " x is " + x);
    }
    System.out.println("Job ending");
  }
}

public class Example1 {
  public static void main(String[] args) {
    Job j = new Job();
    Thread tr = new Thread(j);
    System.out.println("Starting the thread");
    tr.start();
    System.out.println("The thread has been started");
    System.out.println("main exiting");
  }
}
