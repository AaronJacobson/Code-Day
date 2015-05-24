package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Aaron Jacobson on 5/24/2015.
 */
public class Server {
    public static final int PORT_NUMBER = 80085;

    private ServerSocket serverSocket;
    private Socket socket;
    private ClientHandler clientHandler;

    public Server(){

    }

    public void startServer(){
        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
        } catch (IOException e) {
            System.out.println("Server: Unable to start the server.");
        }
    }

    public void waitForConnection(){
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Server: Unable to wait for a connection.");
        }
    }

    public void disconnectClient(){

    }
}
