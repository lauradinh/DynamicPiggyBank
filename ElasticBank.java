import java.util.Random;

public class ElasticBank {
  // private fields
  private Coin[] coins;;
  private int size;
  private int expansionsLeft = 2;
  private static Random rand = new Random(55);

  /**
   * Constructor that initializes the capacity of the Elastic Bank to 10
   */
  public ElasticBank() {
    coins = new Coin[10];
  }

  /**
   * Constructor that initializes the capacity of the Elastic Bank to intialCapacity
   * 
   * @param initialCapacity the original capacity of the Elastic Bank
   */
  public ElasticBank(int initialCapacity) {
    coins = new Coin[initialCapacity];
  }

  /**
   * Accessor method that gets the capacity of Elastic Bank
   * 
   * @return the number of coins that could fit in Elastic Bank
   */
  public int capacity() {
    return coins.length;
  }

  /**
   * Accessor method that gets the number of expansions left
   * 
   * @return expansions left in the Elastic Bank
   */
  public int getExpansions() {
    return expansionsLeft;
  }

  /**
   * Acessor method that gets the number of Coins in the Elastic Bank
   * 
   * @return the current number of Coins in the ElasticBank
   */
  public int getSize() {
    return size;
  }

  /**
   * Adds up all the values of coins to get the balance of Elastic Bank
   * 
   * @return the current total value of coins in the ElasticBank
   */
  public int getBalance() {
    int balance = 0;
    int index;
    for (index = 0; index < size; index++) {
      balance = balance + coins[index].getValue();
    }
    return balance;
  }

  /**
   * Gets the Name and value of the coins in the bank
   * 
   * @return a String representation of the Coins in the bank
   */
  public String getCoins() {
    String coinName;
    int coinValue;
    String coinArrayContents = "";

    for (int i = 0; i < size; i++) {
      coinName = coins[i].getName();
      coinValue = coins[i].getValue();

      coinArrayContents = coinArrayContents + "(" + coinName + ", " + coinValue + ")";

      if (i < size - 1) {
        coinArrayContents = coinArrayContents + " ";
      }
    }
    return coinArrayContents;

  }

  /**
   * removes a Coin from coins at random and returns it, replacing it with a null reference in the
   * coins array
   * 
   * @return the coin that is removed from coins
   */
  public Coin removeCoin() {
    Coin removedCoin = new Coin("", 0);

    if (size == 0) {
      System.out.println("Tried to remove a coin, but could not because the piggy bank is empty.");

    } else {
      int index = rand.nextInt(size);
      removedCoin = coins[index];
      coins[index] = null;
      size = size - 1;
      System.out.println("Removed a " + removedCoin.getName() + ".");
    }
    return removedCoin;
  }

  /**
   * empties the ElasticBank entirely, replacing all Coins in coins with null
   */
  public void empty() {
    int index;
    if (size == 0) {
      System.out.println("Zero coin removed. The piggy bank is already empty.");
    } else {
      System.out.println("All done. " + getBalance() + " cents removed.");
      for (index = 0; index < size; index++) {
        coins[index] = null;
      }
      size = 0;
    }
  }


  /**
   * adds a Coin to the bank and adjusts the capacity of coins if necessary and possible
   * 
   * @param c the coin object that is added to the Elastic Bank
   */
  public void addCoin(Coin c) {
    Coin[] newCoinsArray;
    int index;
    if (size >= coins.length && expansionsLeft > 0) {
      newCoinsArray = new Coin[coins.length + 10];

      for (index = 0; index < size; index++) {
        newCoinsArray[index] = coins[index];
      }
      newCoinsArray[size] = c;
      coins = newCoinsArray;
      expansionsLeft = expansionsLeft - 1;
      size = size + 1;
    } else if (size >= coins.length && expansionsLeft == 0) {
      empty();
      coins[size] = c;
      System.out.println("The number of expansions is zero and the bank has lost its elasticity.");
    } else {
      coins[size] = c;
      size = size + 1;
    }
  }
}
