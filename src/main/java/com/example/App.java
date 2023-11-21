package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        

        try {
            //inizio

            Socket socket = new Socket("10.22.9.13", 3000);
            DataOutputStream outServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner in = new Scanner(System.in);
            Ascoltatore a = new Ascoltatore(inServer);

            String messaggio = "";
            
            System.out.println("---- inserisci il nome con cui verrai riconosciuto ----");
            outServer.writeBytes(in.nextLine()+ "\n");
            System.out.println("mandato il nome");

            a.start();

            do{
                //prendiamo la stringa
                System.out.print("<==\t");
                messaggio = in.nextLine();

                // chiusura /close
                if(messaggio.equals("/close")){ 
                    System.out.println("--- chiusa la connessione ---");
                    socket.close();
                    //break
                }
                
                //manda
                
                outServer.writeBytes(messaggio + "\n");

            }while(socket.isClosed());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
