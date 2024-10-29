package visibility;

public class Example {
  static boolean stop = false;

  public static void main(String[] args) throws Throwable {
    Runnable stopper = () -> {
      System.out.println("stopper starting");
      while (!stop) // busy waiting (generally very bad)
        ;
      System.out.println("stopper stopping");
    };
    new Thread(stopper).start();
    Thread.sleep(1000);
    System.out.println("setting stop flag");
    stop = true;
    System.out.println("stop flag is " + stop);
  }
}
