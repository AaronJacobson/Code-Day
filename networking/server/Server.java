package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Aaron Jacobson on 5/23/2015.
 */
public class Server {

    public static final int PORT_NUMBER = 80085;
    private ServerSocket serverSocket;
    private Socket socket;
    private ClientToServerHandler clientHandler;

    public Server(){

    }

    public void startServer(){
        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
        } catch (IOException e) {
            System.out.println("Unable to start the server.");
        }
    }

    public void waitForClientConnection(){
        try {
            socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            clientHandler = new ClientToServerHandler(in,out,socket);
            Thread clientHandlerThread = new Thread(new ClientHandlerRun(clientHandler));
            clientHandlerThread.start();
        } catch (IOException e) {
            System.out.println("Unable to accept an incoming connection.");
        }
    }
}
class ClientHandlerRun implements Runnable{

    private ClientToServerHandler handler;

    public ClientHandlerRun(ClientToServerHandler handler){
        this.handler = handler;
    }
    @Override
    public void run() {
        handler.listenToClient();
    }
}