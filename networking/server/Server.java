package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Aaron Jacobson on 5/24/2015.
 * The server for the desktop version of gobblet. It will take in one connection and then start the game
 */
public class Server {
    public static final int PORT_NUMBER = 9057;
    public static final String COM_START_GAME = "START_GAME ";
    public static final String COM_MOVE = "MOVE_PLOX ";

    private ServerSocket serverSocket;
    private Socket socket;
    private ClientHandler clientHandler;

    /**
     * Initializes the Server
     */
    public Server(){

    }

    /**
     * Initializes the ServerSocket on the port number. It handles the IOException.
     */
    public void startServer(){
        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
            System.out.println("Created a server on: " + InetAddress.getLocalHost());
        } catch (IOException e) {
            System.out.println("Server: Unable to start the server.");
        }
    }

    /**
     * Waits for a single client to connect, creates a clientHandler thread and resolves
     */
    public void waitForConnection(){
        System.out.println("Waiting for client connections.");
        try {
            socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Server: Connection from " + socket.getInetAddress() + " has been established.");
            clientHandler = new ClientHandler(in,out,socket);
            clientHandler.sendCommand("Hello World!");
            Thread clientHandlerThread = new Thread(clientHandler);
            clientHandlerThread.start();
        } catch (IOException e) {
            System.out.println("Server: Unable to wait for a connection.");
        }
    }

    /**
     * Closes the connection with the client.
     */
    public void disconnectClient(){
        clientHandler.stopListening();
    }
}
