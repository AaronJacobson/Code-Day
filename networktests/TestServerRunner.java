import server.Server;

/**
 * Created by Aaron Jacobson on 5/24/2015.
 */
public class TestServerRunner {
    public static Server testServer;
    public static void main(String[] args) {
        testServer = new Server();
        testServer.startServer();
        testServer.waitForConnection();
        while(true){

        }
    }
}
