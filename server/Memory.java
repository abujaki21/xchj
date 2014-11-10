/******************************************************************************\
 * File: Memory.java
 * Project: xchj
 * Author: Abujaki21
 *
 * Version: 0.0.2
 * Date: 05 Nov 2014
 * Description: Memory abstraction to be used until there's something more
 *     permanent in place
\******************************************************************************/


import java.io.*;
import java.util.HashMap;

class Memory{

  HashMap OwnedStocks = new HashMap<Pair<String,String>,int>;
  //TODO: Look into synchronized maps if multiple login threads are implemented

  //-----Public Getters and Setters-----//
  //* Note: These assume the error and idiot-checking has already been done. *//
  public int getStock(String user, String stockCode){
    Pair<String,String> key = new Pair(user,stockCode);
    if(OwnedStocks.containsKey(key))
      return get(key);
    else
    return 0;
  }

  public void addStock(String user, String stockCode, int amount){
    Pair<String,String> key = new Pair(user, stockCode);

    //Check if it exists. If so, add the prescribed amount to the existing amt
    if(OwnedStocks.containsKey(key))
      OwnedStocks.put(key,OwnedStocks.get(key) + amount);
    else{
      //If not, add the prescribed amount to 0.
      OwnedStocks.put(key,amount);
    }
  }

  public void subtractStock(String user, String stockCode, int amount){
    Pair<String,String> key = new Pair(user, stockCode);

    //Check if it exists, then subtract the prescribed amount.
    if(OwnedStocks.containsKey(key))
      OwnedStocks.put(key,OwnedStocks.get(key) - amount);

    if(OwnedStocks.get(key) <= 0)
      OwnedStocks.remove(key);
      //No fiddling around with empty entries or negatives. Whisk them away, I say.
  }

  //-----Nested Classes-----//
  class Pair<L,R>{
    private final L left;
    private final R right;

    public Pair(L left, R right) {
      this.left = left;
      this.right = right;
    }

    public L getLeft(){return left;}
    public R getRight(){return right;}

    @Override
    public int hashcode(){return (left.hashCode() ^ right.hashCode());}

    @Override
    public boolean equals(Object O){
      if(O == null)
        return false;
      if(!(O instanceof Pair))
        return false;
      Pair OPair = (Pair) O;
      return this.left.equals(OPair.getLeft()) && this.right.equals(OPair.getRight());
    }
  }
}