package com.mycompany.chatmultipleclients;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OMEN
 */
public class Server {
    int port;
    ServerSocket serverSocket = null;
    Socket client =null;
    ExecutorService pool =null;
    int clientCount=0;
    
    public static void main(String[] args) throws IOException{
        Server serverObj=new Server(3000);
        serverObj.startServer();
    }

    private Server(int port) {
        this.port=port;
        pool=Executors.newFixedThreadPool(5);
    }

    private void startServer() throws IOException{
        serverSocket = new ServerSocket(3000);
        System.out.println("Server Started");
        
        while(true){
            client = serverSocket.accept();
            clientCount++;
            ServerThread newThread = new ServerThread(client,clientCount,this);
            pool.execute(newThread);
        }
        
    }
}
