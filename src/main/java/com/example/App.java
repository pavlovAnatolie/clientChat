package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        

        try {
            //start

            //creating a socket nad streams of personal device
            Socket socket = new Socket("10.22.9.13", 3000);
            DataOutputStream outServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner in = new Scanner(System.in);
            Ascoltatore a = new Ascoltatore(inServer);

            String messaggio = "";
            //inserting the username
            System.out.println("---- inserisci il nome con cui verrai riconosciuto ----");
            outServer.writeBytes(in.nextLine()+"\n");
            System.out.println("mandato il nome");
            //creathg a thread
            a.start();

            do{
                //getting a string
                System.out.print("<==\t");
                messaggio = in.nextLine();

                // closing the chat for the user
                if(messaggio.equals("/close")){ 
                    System.out.println("--- chiusa la connessione ---");
                    //invoking termiate method that end the cycle inisde the thread
                    a.terminate();
                }
                
                //sending
                outServer.writeBytes(messaggio + "\n");


            }while(!messaggio.equals("/close"));
            System.out.println("chiusio");
        } catch (Exception e) {
            System.out.println();
        }
    }
}

