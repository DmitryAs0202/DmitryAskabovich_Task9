package enums;

public enum CarBrand {

  MAZ("МАЗ", "Belarus", 1944),
  MERCEDES("Мерседес-Бенц", "Germany", 1926),
  BMW("БМВ", "Germany", 1916),
  TOYOTA("Тойота", "Japan", 1937),
  TESLA("Тесла", "USA", 2003),
  VAZ("ВАЗ", "USSR", 1966),
  SCANIA("Скания", "Sweden", 1891);

  private String name;
  private String country;
  private int yearOfFoundation;

  CarBrand(String name, String country, int yearOfFoundation) {
    this.name = name;
    this.country = country;
    this.yearOfFoundation = yearOfFoundation;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public int getYearOfFoundation() {
    return yearOfFoundation;
  }

  public void setYearOfFoundation(int yearOfFoundation) {
    this.yearOfFoundation = yearOfFoundation;
  }
}
