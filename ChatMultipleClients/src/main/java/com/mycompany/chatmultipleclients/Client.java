/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chatmultipleclients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author OMEN
 */
public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",3000);
        
        Scanner sc=new Scanner(System.in);
        BufferedReader sin =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream sout= new PrintStream(socket.getOutputStream());
       // BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        
        
        String message;
       while(true){
       System.out.println("Client:");
        message=sc.nextLine();
        sout.println(message);
        
        if("-1".equals(message)){
            System.out.println("Connection ended by the client");
            break;
        }
        message=sin.readLine();
           System.out.println("Server : "+message+"");
        
       }
       sout.close();
       sin.close();
       sc.close();
       socket.close();
       
       
    }
   
}
