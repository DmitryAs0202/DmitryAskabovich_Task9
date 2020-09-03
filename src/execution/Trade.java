package execution;

import enums.CarBrand;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import members.Consumer;
import members.Producer;
import movable.car.Car;
import store.Store;

public class Trade {

  public static List<Integer> integers = new ArrayList<>();

  public static void main(String[] args) throws InterruptedException {
    Store<Car> store = new Store<Car>();
    Producer producer = new Producer(store);
    Consumer consumer = new Consumer(store);

    Thread producerThread = new Thread(producer);
    Thread consumerThread = new Thread(consumer);

    System.out.println("Состояние потока клиента: " + consumerThread.getState());
    System.out.println("Состояние потока поставщика: " + producerThread.getState());

    producerThread.start();
    consumerThread.start();
    producerThread.join();
    consumerThread.join();
    System.out.println();
    System.out.println("Состояние потока клиента: " + consumerThread.getState());
    System.out.println("Состояние потока поставщика: " + producerThread.getState());

    new Worker().action();

    Consumer.money = 50000;

    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.submit(producer);
    executorService.submit(consumer);

    executorService.shutdown();
    System.out.println();
    System.out.println("Task submitted.");
    executorService.awaitTermination(2, TimeUnit.MINUTES);


  }

  static class Worker {

    Car car = new Car();
    Object lock = new Object();
    Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();


    public void addToList1() {
      synchronized (car) {
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        list1.add(random.nextInt(100));
      }
    }

    public void addToList2() {
      synchronized (lock) {
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        list2.add(random.nextInt());
      }
    }

    public void task() {
      for (int i = 0; i < 1000; i++) {
        addToList1();
        addToList2();
      }
    }

    public void action() {
      long before = System.currentTimeMillis();
      Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
          task();
        }
      });
      Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
          task();
        }
      });
      thread1.start();
      thread2.start();

      try {
        thread1.join();
        thread2.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      long after = System.currentTimeMillis();
      System.out.println("Adding to lists takes " + (after - before) + " ms.");
      System.out.println("List 1 size: " + list1.size());
      System.out.println("List 2 size: " + list2.size());
    }
  }
}
