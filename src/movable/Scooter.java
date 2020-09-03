package movable;

import java.io.Serializable;
import java.util.Objects;

public class Scooter implements Movable, Serializable {

  private String name;
  private int licensePlate;
  private boolean isMoving;
  private boolean isExtraTrunk;
  private int price;

  public Scooter() {

  }

  public Scooter(String name, int licensePlate, boolean isMoving, boolean isExtraTrunk, int price) {
    this.name = name;
    this.licensePlate = licensePlate;
    this.isMoving = isMoving;
    this.isExtraTrunk = isExtraTrunk;
    this.price = price;
  }

  @Override
  public void move() {
    if (isMoving) {
      System.out.println("Scooter " + name + " is already moving...");
    } else {
      System.out.println("Scooter " + name + " starts moving...");
      isMoving = true;
    }
  }

  @Override
  public void brake() {
    if (isMoving) {
      System.out.println("Scooter " + name + " started braking...");
      isMoving = false;
    } else {
      System.out.println("Scooter " + name + " has already been stopped");
    }
  }

  public void delivery() {
    if (isExtraTrunk) {
      move();
      System.out.println(name + " начал доставку");
    } else {
      System.out.println("Необходима установка багажника");
    }
  }

  public void delivery(String address) {
    if (isExtraTrunk) {
      move();
      System.out.println(name + " начал доставку на " + address);
    } else {
      System.out.println("Необходима установка багажника");
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

  public boolean isExtraTrunk() {
    return isExtraTrunk;
  }

  public void setExtraTrunk(boolean extraTrunk) {
    isExtraTrunk = extraTrunk;
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
    if (!(o instanceof Scooter)) {
      return false;
    }
    Scooter scooter = (Scooter) o;
    return isExtraTrunk() == scooter.isExtraTrunk() &&
        Objects.equals(getName(), scooter.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), isExtraTrunk());
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Scooter{");
    sb.append("name='").append(name).append('\'');
    sb.append(", licensePlate= ").append(licensePlate);
    sb.append(", isMoving= ").append(isMoving);
    sb.append(", isExtraTrunk= ").append(isExtraTrunk).append('}');
    return sb.toString();
  }

}
