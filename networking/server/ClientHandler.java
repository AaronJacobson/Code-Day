package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Aaron Jacobson on 5/24/2015.
 */
public class ClientHandler implements Runnable{

    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private Socket socket;
    private boolean shouldListen;

    /**
     * The constructor which initializes all the parameters and the shouldListen boolean
     * @param in The DataInputStream from the Socket
     * @param out The DataOutputStream from the Socket
     * @param socket The socket which connects the server to the client
     */
    public ClientHandler(DataInputStream in,DataOutputStream out,Socket socket){
        this.dataIn = in;
        this.dataOut = out;
        this.socket = socket;
        shouldListen = true;
    }

    /**
     * The loop which continually checks to receive information from the client.
     * It will automatically call interpretMessage() whenever it receives information
     */
    @Override
    public void run() {
        while(shouldListen){
            try {
                String message = dataIn.readUTF();
                interpretMessage(message);
            } catch (IOException e) {
                System.out.println("ClientHandler: Lost connection to the server.");
                stopListening();
                break;
            }
        }
    }

    /**
     * Stops the server from receiving anything from the client once the method is called.
     * Also ends the connection between the server and the client.
     */
    public void stopListening(){
        shouldListen = false;
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("ClientHandler: Unable to close the connection.");
        }
    }

    /**
     * Interprets the information received from the client
     * @param message The string to be interpreted
     */
    public void interpretMessage(String message){
        System.out.println("ClientHandler: Incoming message- " + message);
        Scanner messageScanner = new Scanner(message);
        if(message.equals("Hello World!")){
            sendCommand("Hello to you too!");
        }
    }

    /**
     * Will handle the IOException from sending a strign through UTF-8
     * @param toSend The string to send
     */
    public void sendCommand(String toSend){
        try {
            dataOut.writeUTF(toSend);
        } catch (IOException e) {
            System.out.println("ClientHandler: Lost connection to the server.");
            stopListening();
        }
    }
}
