import java.util.Random;

public class Coin {
  // private fields
  private String name;
  private int value;

  /**
   * Constructor that initializes the name and value of Coin
   * 
   * @param name  the name of the coin
   * @param value the value of the coin
   */
  public Coin(String name, int value) {
    this.name = name;
    this.value = value;
  }

  /**
   * Accessor method that gets the name of the coin
   * 
   * @return name of the coin
   */
  public String getName() {
    return name;
  }

  /**
   * Accessor method that gets the value of the coin
   * 
   * @return value of the coin
   */
  public int getValue() {
    return value;
  }
}

