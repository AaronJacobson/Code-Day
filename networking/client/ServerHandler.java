package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Aaron Jacobson on 5/24/2015.
 */
public class ServerHandler implements Runnable{
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private Socket socket;
    private boolean shouldListen;

    /**
     * The constructor which initializes both the class and the variables which it stores.
     * @param in The DataInputStream which is obatined from the socket.getInputStream()
     * @param out The DataOutputStream which is obtained from the socket
     * @param socket The Socket which is used to maintain the connection with the server
     */
    public ServerHandler(DataInputStream in, DataOutputStream out,Socket socket){
        this.dataIn = in;
        this.dataOut = out;
        this.socket = socket;
        shouldListen = true;
    }

    /**
     * The loop which continually checks to receive information from the server.
     * It will automatically call interpretMessage().
     */
    @Override
    public void run() {
        sendCommand("Hello World!");
        while(shouldListen){
            try {
                String message = dataIn.readUTF();
                interpretMessage(message);
            } catch (IOException e) {
                System.out.println("ServerHandler: Lost connection to the server.");
                stopListening();
                break;
            }
        }
    }

    /**
     * Stops the client from recieving anything from the server once the method is called.
     * Also ends the connection between the client and the server.
     */
    public void stopListening(){
        shouldListen = false;
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("ServerHandler: Unable to close the connection.");
        }
    }

    /**
     * Interprets the information received from the server.
     * @param message The string to be interpreted
     */
    public void interpretMessage(String message){
        System.out.println("ServerHandler: Incoming message- " + message);
    }

    /**
     * Will handle the IOException from sending a message through UTF-8
     * @param toSend The message which will be sent ot the server
     */
    public void sendCommand(String toSend){
        try {
            dataOut.writeUTF(toSend);
        } catch (IOException e) {
            System.out.println("ServerHandler: Lost connection to the server.");
            stopListening();
        }
    }
}
