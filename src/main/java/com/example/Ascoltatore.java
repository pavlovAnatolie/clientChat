package com.example;

import java.io.BufferedReader;

public class Ascoltatore extends Thread{
    
    BufferedReader inServer;

    public Ascoltatore(BufferedReader inServer){
        this.inServer = inServer; 
    }
    
    @Override
    public void run() {
        while(true){
            String risposta = "";
            try {
                //ascoltare
                risposta = inServer.readLine();

                //stampare cosa sente
                System.out.println(risposta);
                System.err.println(risposta);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
