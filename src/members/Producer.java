package members;

import enums.CarBrand;
import movable.car.Car;
import store.Store;

public class Producer implements Runnable {

  private Store store;
  int counter;

  public Producer(Store store) {
    this.store = store;
  }

  @Override
  public void run() {
    while (!Thread.currentThread().isInterrupted()) {
      store.put(new Car(++counter, "TOYOTA RAV4", CarBrand.TOYOTA, 10000));
    }
    System.out.println("У клиента недостаточно средств. Торговля завершена.");
    System.out.println("Баланс клиента: " + Consumer.money);
  }
}
