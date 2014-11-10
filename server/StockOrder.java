/******************************************************************************\
 * File: StockOrder.java
 * Project: xchj
 * Author: Abujaki21
 *
 * Version: 0.0.1
 * Date: 05 Nov 2014
 * Description: Memory abstraction to be used until there's something more
 *     permanent in place
\******************************************************************************/


class StockOrder{
  final String code, user; //Stock Code, User
  final boolean buy; //Is this a request to buy?
  int amount; //How many stocks?
  final double price; //How much per stock?

  public StockOrder(String code, String user, boolean buy, int amount, double price){
    this.code = code;
    this.user = user;
    this.buy = buy;
    this.amount = amount;
    this.price = price;
  }

  //-----Public getters and setters-----//
  public String getCode(){return code;}
  public String getUser(){return user;}
  public boolean isBuy(){return buy;}
  public int getAmount(){return amount;}
  public double getPriceEach(){return price;}
  public double getPriceTotal(){return amount * price;}

  //*Note: This assumes logic/idiot tests have already been done*//
  public void deductStock(int amt){
    if(amount > amt)
      amount -= amt;
    else
      amount = 0;
  }
}