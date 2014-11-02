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
  BifferedReader in = null;

  public static void main(String[] eventArgs){
    // Main subroutine
    connect("localhost",51);
    //--Do stuff here
    disconnect();
  }

  private connect(String hostname, int portNumber){
    //Connect to server
    try{
      //Create a socket and attach
      sock = new Socket(hostname, portNumber);
      out = new PrintWriter(sock.getOutputStream(), true);
      in = new BufferedReader(sock.getInputStream()));
    }
  }

  private disconnect(){
    //close the socket connection
    sock.close();
  }
}