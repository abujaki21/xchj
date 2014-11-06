/******************************************************************************\
 * File: Stock.java
 * Project: xchj
 * Author: Abujaki21
 *
 * Version: 0.1.0
 * Date: 05 Nov 2014
 * Description: Memory abstraction to be used until there's something more
 *     permanent in place
\******************************************************************************/

package server;

class Stock{
  String friendly, code, resp;
  int amount;
  double open, high, low, close;

  //-----Public Constructors-----//
  public Stock(String code, String friendly, String resp, int amount){Stock(code, friendly, resp, amount, 0.0);}
  public Stock(String code, String friendly, String resp, int amount, double price){
    this.code = code; //Caps code to uniquely identify the stock
    this.friendly = friendly; //Human-friendly name of the stock
    this.resp = resp; //User responsible for the creation of the stock
    //TODO: Change it to point to an existing user
    this.amount = amount; //Number of stocks available
    this.open = this.high = this.low = this.close = price; //Set initial values based on IPO launch
    //Open: Price the stock opens at
    //High: highest price the stock sold at
    //Low: lowest price the stock sold at
    //Close: the last price the stock sold at.
  }

  //-----Public getters and setters-----//
  public String getCode(){return code;}
  public String getFriendly(){return friendly;}
  public String getResponsible(){return resp;}
  public int getAmount(){return amount;}
  public double[] getPrices(){return {open,high,low,close};}
  public double getLastPrice(){return close;}
  //Hopefully this block of code can go without explanation. If not, I'm not
  //sure I want you dabbling with it anyway.

  public boolean setOpeningPrice(double price){
    open = high = low = close = price;
    //Dawn of the second day. 48 Hours remain.
  }

  public boolean sellStocks(double price, int amount{ return sellStock(price/amount);
    //used when selling multiple stocks because who sells just one?
    //"One art please" ~Dr. Zoidberg
  }

  public boolean sellStock(double price){
    close = price;
    if(close>high){
      //Set the new high price
      high = close;
    }
    else if(close < low){
      //Set the new low price
      low = close;
    }
    return true; //Placeholder in case there's some error-checking to do later.
  }
}