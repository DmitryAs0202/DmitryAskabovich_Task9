package movable.car;

import enums.CarBrand;
import enums.FuelType;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import movable.Movable;

public class Car implements Movable, Serializable {

  public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

  protected int id;
  protected String name;
  protected CarBrand carBrand;
  protected int price;
  protected FuelType fuelType;
  private byte numberOfWheels;


  public Car() {

  }

  public Car(int id, String name, CarBrand carBrand, int price) {
    this.id = id;
    this.name = name;
    this.carBrand = carBrand;
    this.price = price;
  }

  private class Motor {

    FuelType fuelType;

    public Motor(FuelType fuelType) {
      this.fuelType = fuelType;
    }
  }

  @Override
  public void brake() {

  }

  @Override
  public void move() {

  }

  @Override
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CarBrand getCarBrand() {
    return carBrand;
  }

  public void setCarBrand(CarBrand carBrand) {
    this.carBrand = carBrand;
  }


  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public byte getNumberOfWheels() {
    return numberOfWheels;
  }

  public void setNumberOfWheels(byte numberOfWheels) {
    this.numberOfWheels = numberOfWheels;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Car)) {
      return false;
    }
    Car car = (Car) o;
    return Objects.equals(getName(), car.getName()) &&
        getCarBrand() == car.getCarBrand();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getCarBrand());
  }

  @Override
  public String toString() {
    return "Car{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", carBrand=" + carBrand +
        '}';
  }
}
