package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Aaron Jacobson on 5/23/2015.
 */
public class ClientToServerHandler {

    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private Socket socket;
    private boolean shouldRun;

    public ClientToServerHandler(DataInputStream in,DataOutputStream out,Socket socket){
        this.dataIn = in;
        this.dataOut = out;
        this.socket = socket;
        shouldRun = true;
    }

    public void listenToClient(){
        while(shouldRun){
            try {
                String message = dataIn.readUTF();
                interpretData(message);
            } catch (IOException e) {
                System.out.println("Lost connection to the server.");
                shouldRun = false;
                break;
            }
        }
    }

    public void interpretData(String toIntperpret){

    }
}
