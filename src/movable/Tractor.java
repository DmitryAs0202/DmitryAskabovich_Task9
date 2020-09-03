package movable;

import java.io.Serializable;
import java.util.Objects;

public class Tractor implements Movable, Serializable {

  private String name;
  private int licensePlate;
  private boolean isMoving;
  private boolean isEquipment;
  private int loadCapacity;
  private int price;

  public Tractor() {

  }

  public Tractor(String name, int licensePlate, boolean isMoving, boolean isEquipment,
      int loadCapacity, int price) {
    this.name = name;
    this.licensePlate = licensePlate;
    this.isMoving = isMoving;
    this.isEquipment = isEquipment;
    this.loadCapacity = loadCapacity;
    this.price = price;
  }

  public void goWork() {
    if (isEquipment) {
      System.out.println("Tractor " + name + " started working...");
    } else {
      System.out.println("Tractor " + name + " need equipment");
    }
  }

  public void load(int weight) {
    if (weight <= loadCapacity) {
      System.out.println("Трактор загружен");
    } else {
      System.out.println("Слишком много груза!!!");
    }
  }

  @Override
  public void move() {
    if (isMoving) {
      System.out.println("Tractor " + name + " is already moving...");
    } else {
      System.out.println("Tractor " + name + " starts moving...");
      isMoving = true;
    }
  }

  public void move(int distanceInKilometers, boolean isForWork) {
    if (isMoving) {
      System.out.println("Tractor " + name + " is already moving...");
    } else {
      System.out.println("Tractor " + name + " starts moving...");
      isMoving = true;
      brake();
      System.out.println("Tractor " + name + " passed " + distanceInKilometers + " kilometres");
      if (isForWork) {
        goWork();
      }
    }
  }

  @Override
  public void brake() {
    if (isMoving) {
      System.out.println("Tractor " + name + " started braking...");
      isMoving = false;
    } else {
      System.out.println("Tractor " + name + " has already been stopped");
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(int licensePlate) {
    this.licensePlate = licensePlate;
  }

  public boolean isMoving() {
    return isMoving;
  }

  public void setMoving(boolean moving) {
    isMoving = moving;
  }

  public boolean isEquipment() {
    return isEquipment;
  }

  public void setEquipment(boolean equipment) {
    isEquipment = equipment;
  }

  public int getLoadCapacity() {
    return loadCapacity;
  }

  public void setLoadCapacity(int loadCapacity) {
    this.loadCapacity = loadCapacity;
  }

  public int getPrice() {
    return price;
  }

  @Override
  public int getId() {
    return 0;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Tractor)) {
      return false;
    }
    Tractor tractor = (Tractor) o;
    return isEquipment() == tractor.isEquipment() &&
        Objects.equals(getName(), tractor.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), isEquipment());
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Tractor{");
    sb.append("name='").append(name).append('\'');
    sb.append(", licensePlate= ").append(licensePlate);
    sb.append(", isMoving= ").append(isMoving);
    sb.append(", isEquipment= ").append(isEquipment);
    sb.append(", PRICE = ").append(price).append('}');
    return sb.toString();
  }

}
