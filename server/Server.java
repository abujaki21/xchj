/******************************************************************************\
 * File: Server.java
 * Project: xchj
 * Author: Abujaki21
 *
 * Version: 0.0.8
 * Date: 08 Nov 2014
 * Description: Base server class
\******************************************************************************/

package server;

//-----Imports-----//
import java.net.*;
import java.io.*;


class Server{
  //in case the port needs to be changed
  private static int port = 51;

  public static void main(String[] eventArgs){
    try{
      //Create a new socket and listen to it
      ServerSocket sock = new ServerSocket(port);
      //Accept the connection, and attach IO objects
      Socket client = sock.accept();
      PrintWriter out = new PrintWriter(client.getOutputStream(),true);
      BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      //         !!REVISE!!                      ^

      String command = in.readLine();

      //-----Authentication Block-----//
      //read request
      /*String request = in.readLine();
      //Challenge request
      String challenge = generateChallenge(request);
      out.println(challenge);
      //Read response
      request = in.readLine();
      //Calculate answer
      //Compare response to answer

      //Respond with accept/deny
      //    If deny, close connection
      //    else serve incoming requests
      */
      //Wait for commands and reply to them
      while(command != null){
        out.println(command);
        if(command == "bye"){break;}
        command = in.readLine();
      }
    }
    catch(IOException e){
      //Socket cannot bind -- Likely in use
      System.out.println("Unable to listen on port " + port + ". Please ensure the port is free and try again.");
      System.out.println(e.getMessage());
    }
  } //-- End main class
  /*private static String generateChallenge(String request){
    return request; //TODO: Actually do the thing
  }*/
}