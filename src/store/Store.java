package store;


import members.Consumer;
import movable.Movable;


public class Store<T extends Movable> {

  private int moneyAmount = 90000;
  private T[] products;

  public Store() {
    products = (T[]) new Movable[0];

  }

  public Store(T[] products) {
    this.products = products;
  }

  public void printProducts() {
    for (int i = 0; i < products.length; i++) {
      int number = i + 1;
      System.out.println(number + ". " + products[i]);
    }
  }

  public synchronized void get() {
    while (products.length < 1) {
      try {
        Thread.sleep(1000);
        wait();
      } catch (InterruptedException e) {
        System.out.println("Поток  get завершен");
      }
    }
    Movable item = products[products.length - 1];
    makeArraySmaller();
    System.out.println(item + " был куплен.");
    moneyAmount += item.getPrice();
    Consumer.money -= item.getPrice();
    notify();
    if (Consumer.money <= 0) {
      Thread.currentThread().interrupt();
    }
  }

  public synchronized void put(T item) {
    while (products.length >= 1) {
      try {
        Thread.sleep(1000);
        wait();
      } catch (InterruptedException e) {
        System.out.println("Поток put завершен");
      }
    }
    makeArrayLarger();
    products[products.length - 1] = item;
    System.out.println(item + " добавлен.");
    moneyAmount -= item.getPrice();
    if (Consumer.money <= 0) {
      Thread.currentThread().interrupt();
    }
    notify();
  }

  public synchronized void makeArraySmaller() {
    T[] remainingProducts = (T[]) new Movable[products.length - 1];
    for (int i = 0; i < remainingProducts.length; i++) {
      remainingProducts[i] = products[i];
    }
    products = remainingProducts;
  }

  public synchronized void makeArrayLarger() {
    T[] newProducts = (T[]) new Movable[products.length + 1];
    for (int i = 0; i < products.length; i++) {
      newProducts[i] = products[i];
    }
    products = newProducts;
  }

  public int getMoneyAmount() {
    return moneyAmount;
  }

  public T[] getProducts() {
    return products;
  }

  public void setProducts(T[] products) {
    this.products = products;
  }
}
