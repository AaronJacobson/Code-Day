package client;

import server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Aaron Jacobson on 5/24/2015.
 */
public class Client {
    private Socket socket;
    private ServerHandler serverHandler;

    public Client(){

    }

    public void connectToServer(String ip){
        try {
            socket = new Socket(ip, Server.PORT_NUMBER);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            serverHandler = new ServerHandler(in,out,socket);
            Thread serverHandlerThread = new Thread(serverHandler);
            serverHandlerThread.start();
        } catch (IOException e) {
            System.out.println("Client: Unable to connect to the server.");
        }
    }

    public void disconnectFromServer(){
        System.out.println("Client: Closing connection with the server.");
        serverHandler.stopListening();
    }
}
