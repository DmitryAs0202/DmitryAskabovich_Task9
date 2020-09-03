package members;

import store.Store;

public class Consumer implements Runnable {

  private Store store;
  public static int money = 100000;

  public Consumer(Store store) {
    this.store = store;
  }

  @Override
  public void run() {
    while (!Thread.currentThread().isInterrupted()) {
      store.get();
    }
  }


}
