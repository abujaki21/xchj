/******************************************************************************\
 * File: client.java
 * Project: xchj
 * Author: Abujaki21
 *
 * Version: 0.0.3
 * Date: 08 Nov 2014
 * Description: Base client class
\******************************************************************************/

//-----Imports-----//
import java.net.*;
import java.io.*;

class client{

  public static void main(String[] eventArgs){

    Socket sock = null;
    PrintWriter nout = null;
    BufferedReader nin = null;
    boolean connected = false;

    BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
/*
    System.out.print("User: ");
    String user = sin.readLine();
    System.out.print("Passcode: ");
    char[] passcode = sin.readPassword();
*/
    String command;//, response;

    //-----Authentication Block-----//
    //Initiate connection
    //Connect to server
    try{
      //Create a socket and attach
      sock = new Socket("localhost",51);
      nout = new PrintWriter(sock.getOutputStream(), true);
      nin = new BufferedReader(new InputStreamReader(sock.getInputStream()));
      connected = true;

    while(connected){
      System.out.print("> ");
      command = sin.readLine();
      nout.println(command);
      command = nin.readLine();
      System.out.println("Server: " + command);
      if(command == "bye"){
        connected = false;
      }
    }
    //Send connection request
    //  out.println(user);
    //Read challenge
    //  response = in.readLine();
    //Calculate response
    //Send response
    //  out.println(generateResponse(response,passcode));
    //Read accept/deny
    //    If deny, close connection
    //    Else continue sending requests

    sock.close();
    }
    catch(IOException e){
      //El no connecto
      System.err.println("Cannot connect on port 51.");
    }
  }
/*
  private static String generateResponse(String response, String passcode){
    return response + passcode;
  }
*/
}