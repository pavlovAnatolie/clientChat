package com.example;

import java.io.BufferedReader;

public class Ascoltatore extends Thread{
    
    private BufferedReader inServer;
    private boolean exit = false;

    public Ascoltatore(BufferedReader inServer){
        this.inServer = inServer; 
    }
    
    public void terminate(){
        exit  = true;
    }

    @Override
    public void run() {
        while(!exit){
            String risposta = "";
            try {
                //ascoltare
                risposta = inServer.readLine();

                //stampare cosa sente
                System.out.println(risposta);
                

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}