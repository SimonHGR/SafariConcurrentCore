package runnables;

class Job implements Runnable {
  private int x = 0;

  @Override
  public void run() {
    System.out.println("Job starting");
    for (; x < 1_000; x++) {
      System.out.println(Thread.currentThread().getName() + " x is " + x);
    }
    System.out.println("Job ending");
  }
}

//class Job implements Runnable {
//  @Override
//  public void run() {
//    System.out.println("Job starting");
//    for (int x = 0; x < 1_000; x++) {
//      System.out.println(Thread.currentThread().getName() + " x is " + x);
//    }
//    System.out.println("Job ending");
//  }
//}
//
public class Example1 {
  public static void main(String[] args) {
    Job j = new Job();
    Thread tr = new Thread(j);
    Thread tr2 = new Thread(j);
    System.out.println("Starting the threads");
    tr.start();
    tr2.start();
    System.out.println("The thread has been started");
    System.out.println("main exiting");
  }
}
