public class ElasticTester {

  /**
   * Checks whether getName() and getValue() methods works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCoinInstantiableClass() {
    Coin penny = new Coin("PENNY", 1);
    Coin quarter = new Coin("QUARTER", 25);

    // scenario 1:
    if (!penny.getName().equals("PENNY"))
      return false;

    // scenario 2:
    if (penny.getValue() != 1)
      return false;

    // scenario 3:
    if (!quarter.getName().equals("QUARTER"))
      return false;

    // scenario 4:
    if (quarter.getValue() != 25)
      return false;

    return true;

  }

  /**
   * Checks whether capacity() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetCapacity() {
    Coin penny = new Coin("QUARTER", 25);
    Coin dime = new Coin("DIME", 10);

    ElasticBank one = new ElasticBank(5);

    one.addCoin(new Coin("DIME", 10));
    one.addCoin(penny);

    // scenario 1: capacity of 5 is passed

    if (one.capacity() != 5) {
      System.out.println("Problem detected. Your one.capacity did not return the "
          + "expected output when passed a bank that has the capacity of 5.");
      return false;
    }

    ElasticBank two = new ElasticBank();

    // scenario 2: default capacity if initial capacity is not passed
    if (two.capacity() != 10) {
      System.out.println("Problem detected. Your two.capacity did not return the "
          + "expected output when passed a bank that has the default initial capacity.");
      return false;
    }

    ElasticBank three = new ElasticBank(0);

    // scenario 3: capacity of 0 is passed
    if (three.capacity() != 0) {
      System.out.println("Problem detected. Your three.capacity did not return the "
          + "expected output when passed a bank that has the capacity of 0.");
    }

    ElasticBank four = new ElasticBank(3);

    four.addCoin(dime);
    four.addCoin(new Coin("QUARTER", 25));
    four.addCoin(penny);
    four.addCoin(dime);

    // scenario 4: capacity after the expansion is used
    if (four.capacity() != 13) {
      System.out.println("Problem detected. Your four.capacity did not return the "
          + "expected output when passed a bank that has the capacity of 10.");
    }
    return true;
  }

  /**
   * Checks whether getExpansions() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetExpansions() {
    Coin penny = new Coin("Penny", 1);
    Coin dime = new Coin("DIME", 10);

    ElasticBank one = new ElasticBank(4);

    one.addCoin(dime);
    one.addCoin(penny);

    // scenario 1: Using no expansions to the Elastic Bank
    if (one.getExpansions() != 2) {
      System.out.println("Problem detected. Your one.getExpansions did not return the "
          + "expected output when passed a bank that has 2 exansionsLeft.");
      return false;
    }

    ElasticBank two = new ElasticBank(2);

    two.addCoin(dime);
    two.addCoin(penny);
    two.addCoin(dime);

    // scenario 2: Using one expansion to the Elastic Bank
    if (two.getExpansions() != 1) {
      System.out.println("Problem detected. Your two.getExpansions did not return the "
          + "expected output when passed a bank that has 1 exansionsLeft.");
      return false;
    }

    ElasticBank three = new ElasticBank(1);
    three.addCoin(dime);
    three.addCoin(penny);
    three.addCoin(dime);
    three.addCoin(penny);
    three.addCoin(dime);
    three.addCoin(penny);
    three.addCoin(dime);
    three.addCoin(penny);
    three.addCoin(dime);
    three.addCoin(penny);
    three.addCoin(dime);
    three.addCoin(penny);

    // scenario 3: Using two expansions to the Elastic Bank
    if (three.getExpansions() != 0) {
      System.out.println("Problem detected. Your three.getExpansions did not return the "
          + "expected output when passed a bank that has 0 exansionsLeft.");
      return false;
    }
    return true;
  }

  /**
   * Checks whether getSize() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetSize() {
    Coin penny = new Coin("Penny", 1);
    Coin dime = new Coin("DIME", 10);

    ElasticBank one = new ElasticBank(6);

    // scenario 1: No coins in Elastic Bank
    if (one.getSize() != 0) {
      System.out.println("Problem detected. Your one.getSize did not return the "
          + "expected output when passed a bank that has 0 coins.");
      return false;
    }

    ElasticBank two = new ElasticBank(4);

    two.addCoin(dime);
    two.addCoin(penny);

    // scenario 2: No expansion
    if (two.getSize() != 2) {
      System.out.println("Problem detected. Your two.getSize did not return the "
          + "expected output when passed a bank that has 2 coins.");
      return false;
    }

    ElasticBank three = new ElasticBank(3);
    three.addCoin(dime);
    three.addCoin(penny);
    three.addCoin(penny);
    three.addCoin(dime);
    // scenario 3: With expansion
    if (three.getSize() != 4) {
      System.out.println("Problem detected. Your three.getSize did not return the "
          + "expected output when passed a bank that has 4 coins.");
      return false;
    }
    return true;
  }

  /**
   * Checks whether getBalance() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBalanceAccessors() {
    ElasticBank one = new ElasticBank(5);
    ElasticBank two = new ElasticBank(7);
    one.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("NICKEL", 5));

    // scenario 1: one penny
    if (one.getBalance() != 1) {
      System.out.println("Problem detected. Your one.getBalance did not return the "
          + "expected output when passed a bank that has a total balance of 1.");

      return false;
    }

    // scenario 2: one nickel
    if (two.getBalance() != 5) {
      System.out.println("Problem detected. Your one.getBalance did not return the "
          + "expected output when passed a bank that has a total balance of 5.");

      return false;
    }

    two.addCoin(new Coin("QUARTER", 25));

    // scenario 3: two coins
    if (two.getBalance() != 30) {
      System.out.println("Problem detected. Your one.getBalance did not return the "
          + "expected output when passed a bank that has a total balance of 30.");
      return false;
    }
    return true;
  }

  /**
   * Checks whether getCoins() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetCoins() {
    ElasticBank one = new ElasticBank(6);

    // scenario 1: empty bank

    if (!one.getCoins().equals("")) {
      System.out.println("Problem detected. Your one.getCoins did not return the "
          + "expected output when passed an empty bank");

      return false;
    }
    one.addCoin(new Coin("NICKEL", 5));

    // scenario 2: a coin in the bank
    if (!(one.getCoins().equals("(NICKEL, 5)"))) {
      System.out.println("Problem detected. Your one.getCoins did not return the "
          + "expected output when passed a bank with a nickel");

      return false;
    }
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("PENNY", 1));

    // scenario 3: more than one coin
    if (!(one.getCoins().equals("(NICKEL, 5) (QUARTER, 25) (DIME, 10) (DIME, 10) (PENNY, 1)"))) {
      System.out.println("Problem detected. Your one.getCoins did not return the "
          + "expected output when passed a bank with a nickel, quarter, dime, dime, and a penny");

      return false;
    }
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("PENNY", 1));
    // scenario 4: a bank that goes over the initial capacity
    if (!(one.getCoins().equals(
        "(NICKEL, 5) (QUARTER, 25) (DIME, 10) (DIME, 10) (PENNY, 1) (QUARTER, 25) (PENNY, 1)"))) {
      System.out.println("Problem detected. Your one.getCoins did not return the "
          + "expected output when passed a bank with a nickel, quarter, dime, dime, quarter, and a penny");
      return false;
    }

    return true;
  }

  /**
   * Checks whether addCoins() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoins() {
    ElasticBank one = new ElasticBank(2);

    // scenario 1: add one coin
    one.addCoin(new Coin("Quarter", 25));
    if (one.getSize() != 1) {
      System.out.println("Problem detected. Your one.addCoins() did not return the "
          + "expected output when passed a bank with one coin added");
      return false;
    }
    // scenario 2: adding coins over initial capacity
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    if (one.getSize() != 3) {
      System.out.println("Problem detected. Your one.addCoins() did not return the "
          + "expected output when passed a bank with 3 coins added");
      return false;
    }
    // scenario 3: adding coins over all expansions
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    one.addCoin(new Coin("Quarter", 25));
    if (one.getSize() != 0) {
      System.out.println("Problem detected. Your one.addCoins() did not return the "
          + "expected output when passed a bank with coins over the size added");
      return false;
    }
    return true;
  }

  /**
   * Checks whether removeCoins() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveCoins() {
    ElasticBank one = new ElasticBank(2);
    // scenario 1: empty bank
    if (one.removeCoin().getValue() != 0 && one.removeCoin().getName() != "") {
      System.out.println("Problem detected. Your one.removeCoins() did not return the "
          + "expected output when passed an empty bank");
      return false;
    }
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("PENNY", 1));
    // scenario 2: removing one coin
    Coin removed1 = one.removeCoin();
    if (removed1.getName() != "PENNY" && removed1.getValue() != 1) {
      System.out.println("Problem detected. Your one.removeCoins() did not return the "
          + "expected output when passed a bank with two coins");
      return false;
    }

    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("PENNY", 1));
    // scenario 3: removing a coin under the expansion
    Coin removed2 = one.removeCoin();
    if (removed2.getName() != "PENNY" && removed2.getValue() != 1) {
      System.out.println("Problem detected. Your one.removeCoins() did not return the "
          + "expected output when passed a bank with coins that had an expansion");
      return false;
    }
    return true;
  }

  /**
   * Checks whether empty() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testEmpty() {
    ElasticBank one = new ElasticBank(2);

    // scenario 1: Elastic Bank is already empty
    one.empty();
    if (one.getSize() != 0) {
      System.out.println("Problem detected. Your one.empty() did not return the "
          + "expected output when passed an empty bank");
      return false;
    }
    // scenario 2: Elastic Bank contains some coins
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.empty();
    if (one.getSize() != 0) {
      System.out.println("Problem detected. Your one.empty() did not return the "
          + "expected output when passed a bank with 2 coins");
      return false;
    }
    // scenario 3: bank with expansion
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.empty();
    if (one.getSize() != 0) {
      System.out.println("Problem detected. Your one.empty() did not return the "
          + "expected output when passed a bank with an expansion");
      return false;
    }
    return true;
  }

  /**
   * Calls the test methods implemented in this class and displays their output
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // System.out.println("coinInstantiableClassTest(): " + testCoinInstantiableClass());
    // System.out.println("balanceAccessorsTest(): " + testBalanceAccessors());
    // System.out.println("getCapacityTest(): " + testGetCapacity());
    // System.out.println("getCoinsTest(): " + testGetCoins());
    // System.out.println("getExpansionsLeftTest(): " + testGetExpansions());
    // System.out.println("getSizeTest(): " + testGetSize());
    // System.out.println("addCoinsTest(): " + testAddCoins());
    // System.out.println("removeCoinsTest(): " + testRemoveCoins());
    System.out.println("emptyTest(): " + testEmpty());


  }

}
