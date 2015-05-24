package client;

import server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Aaron Jacobson on 5/24/2015.
 * Handles the connections and disconnection from the server when give the ip address
 * */
public class Client {
    /*
     * The Socket which handles
     */
    private Socket socket;
    private ServerHandler serverHandler;

    /**
     * The constructor which only initializes the class
     */
    public Client(){

    }

    /**
     * Connects the client to the server and starts the ServerHandlerThread
     * @param ip The ip address of the machine the program will try to connect to
     */
    public void connectToServer(String ip){
        try {
            socket = new Socket(ip, Server.PORT_NUMBER);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            serverHandler = new ServerHandler(in,out,socket);
            Thread serverHandlerThread = new Thread(serverHandler);
            System.out.println("Client: Starting ServerHandler thread.");
            serverHandlerThread.start();
        } catch (IOException e) {
            System.out.println("Client: Unable to connect to the server.");
        }
    }

    /**
     * Disconnects the client from the server which it is connected to.
     */
    public void disconnectFromServer(){
        System.out.println("Client: Closing connection with the server.");
        serverHandler.stopListening();
    }

    /**
     * Sends a command from the client to the server and handles it's own errors
     * @param toSend The string command which will be sent
     */
    public void sendMessage(String toSend){
        serverHandler.sendCommand(toSend);
    }
}
