package com.example;

import java.io.BufferedReader;

public class Ascoltatore extends Thread{
    
    private BufferedReader inServer;
    private boolean exit = false;

    //construnctor
    public Ascoltatore(BufferedReader inServer){
        this.inServer = inServer; 
    }
    //make the Thread to disconnect
    public void terminate(){
        exit  = true;
    }

    @Override
    public void run() {
        //cycle that work while exit== false
        while(!exit){
            String risposta = "";
            try {
                //listenig
                risposta = inServer.readLine();

                //stmping every received string
                System.out.println(risposta);
                

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
