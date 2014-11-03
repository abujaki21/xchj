/******************************************************************************\
 * File: Server.java
 * Project: xchj
 * Author: Abujaki21
 *
 * Version: 0.0.1
 * Date: 02 Nov 2014
 * Description: Base server class
\******************************************************************************/

package server;

//-----Imports-----//
import java.net.*;
import java.io.PrintWriter;
import java.io.BufferedReader;


class Server{
  //in case the port needs to be changed
  private static int port = 51;

  public static void main(String[] eventArgs){
    try{
      //Create a new socket and listen to it
      ServerSocket sock = new ServerSocket(port);
      //Accept the connection, and attach IO objects
      Socket client = serverSocket.accept();
      PrintWriter out = new PrintWriter(client.getOutputStream(),true);
      BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      String command = in.readLine();
      //Wait for commands and reply to them
      while(command != null){ //<== This feels wrong
        out.println(command);
        command = in.readLine();
      }
    }
    catch(IOException e){
      //Socket cannot bind -- Likely in use
      System.out.println("Unable to listen on port " + port + ". Please ensure the port is free and try again.");
      System.out.println(e.getMessage());
    }
  }
}