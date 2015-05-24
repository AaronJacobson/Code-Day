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

    public ServerHandler(DataInputStream in, DataOutputStream out,Socket socket){
        this.dataIn = in;
        this.dataOut = out;
        this.socket = socket;
    }

    @Override
    public void run() {
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

    public void stopListening(){
        shouldListen = false;
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("ServerHandler: Unable to close the connection.");
        }
    }

    public void interpretMessage(String message){

    }

    public void sendCommand(String toSend){
        try {
            dataOut.writeUTF(toSend);
        } catch (IOException e) {
            System.out.println("ServerHandler: Lost connection to the server.");
            stopListening();
        }
    }
}
