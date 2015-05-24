import client.Client;

/**
 * Created by Aaron Jacobson on 5/24/2015.
 */
public class TestClientRunner {
    public static Client testClient;
    public static void main(String[] args) {
        testClient = new Client();
        testClient.connectToServer("192.168.128.117");
        while(true){

        }
    }
}
