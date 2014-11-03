/******************************************************************************\
 * File: client.java
 * Project: xchj
 * Author: Abujaki21
 *
 * Version: 0.0.1
 * Date: 02 Nov 2014
 * Description: Base client class
\******************************************************************************/

package client;

//-----Imports-----//
import java.net.*;
import java.io.*;

class client{
  private static Socket sock = null;
  private static Printwriter out = null;
  private static BufferedReader in = null;
  private static boolean connected = false;

  public static void main(String[] eventArgs){
    // Main subroutine
    connect("localhost",51);
    //--Do stuff here
    String command;
    while(connected){
      command = System.in.readLine();
      out.println(command);
      command = in.readLine();
      System.out.printLine(command);
      if(command == "bye"){
        disconnect();
      }
    }
  }

  private static connect(String hostname, int portNumber){
    //Connect to server
    try{
      //Create a socket and attach
      sock = new Socket(hostname, portNumber);
      out = new PrintWriter(sock.getOutputStream(), true);
      in = new BufferedReader(sock.getInputStream());
      connected = true;
    }
    catch(IOException e){
      //El no connecto
      System.err.println("Cannot connect on port 51.");
    }
  }

  private static disconnect(){
    //close the socket connection
    sock.close();
    connected = false;
  }
}