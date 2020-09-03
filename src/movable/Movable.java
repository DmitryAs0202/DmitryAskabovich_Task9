package movable;

public interface Movable {

  void move();

  int getPrice();

  int getId();

  String getName();

  boolean equals(Object o);

  int hashCode();

  default void brake() {
    System.out.println("Braking...");
  }

}
