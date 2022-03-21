/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chatmultipleclients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author OMEN
 */
public class ServerThread implements Runnable{

    Server server=null;
    Socket client=null;
    BufferedReader cin;
    PrintStream cout;
    Scanner sc=new Scanner(System.in);
   // BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        
    int clientCount;
    String message;
    
    ServerThread(Socket client,int clientCount,Server server) throws IOException{
        this.client=client;
        this.clientCount=clientCount;
        this.server=server;
        System.out.println("Connection "+clientCount+" established with client "+client);
        
        cin =new BufferedReader(new InputStreamReader(client.getInputStream()));
        cout= new PrintStream(client.getOutputStream());
    }
    
    
    @Override
    public void run() {
        int x=1;
        try {
            while(true){
                message=cin.readLine();
                System.out.println("Client ("+clientCount+") : "+message+"");
                System.out.println("\n");
      
                 
        
       
        message=sc.nextLine();
        
        if(message.equals(-1)){
            System.out.println("Connection ended by the client");
            x=-1;
            break;
        }
        cout.println(message);
              
       }
       cin.close();
       cout.close();
       client.close();
       if(x==-1){
           System.exit(0);
       }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
}
