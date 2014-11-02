/******************************************************************************\
 * File: client.java
 * Project: xchj
 * Author: Abujaki21
 *
 * Version: 0.0.1
 * Date: 01 Nov 2014
 * Description: Base client class
\******************************************************************************/

package client;

//-----Imports-----//
import java.net.*;
import java.io.*;

class client{
  Socket sock = null;
  Printwriter out = null;
  BufferedReader in = null;
  boolean connected = false;

  public static void main(String[] eventArgs){
    // Main subroutine
    connect("localhost",51);
    //--Do stuff here
    String command;
    while(connected){
      command = System.in.readLine();
      out.printLine(command);
      command = in.readLine();
      System.out.printLine(command);
      if(command == "bye"){
        disconnect();
      }
    }
  }

  private connect(String hostname, int portNumber){
    //Connect to server
    try{
      //Create a socket and attach
      sock = new Socket(hostname, portNumber);
      out = new PrintWriter(sock.getOutputStream(), true);
      in = new BufferedReader(sock.getInputStream()));
      connected = true;
    }
  }

  private disconnect(){
    //close the socket connection
    sock.close();
    connected = false;
  }
}