package client;

import server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Aaron Jacobson on 5/23/2015.
 */
public class Client {

    private Socket socket;
    private ServerToClientHandler serverHandler;

    public Client(){

    }

    public void connectToServer(String ip){
        try {
            socket = new Socket(ip, Server.PORT_NUMBER);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            serverHandler = new ServerToClientHandler(in,out,socket);
        } catch (IOException e) {
            System.out.println("Unable to connect to the server.");
        }
    }

    public void disconnectFromServer(){
        serverHandler.stopListening();
    }
}
