package TCPServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class main {

    public static class mainServer {
        public static void main(String[] args) {
            /* vars  */
            ServerSocket s = null;
            sql data;

            /* A server socket waits for requests to come in over the network. It performs some operation based on that request, and then possibly returns a result to the requester.  */
            try {
                s = new ServerSocket(10001);
                data = new sql();

            } catch (IOException e) {
                System.out.println(e);
                System.exit(1);
            }

            while (true) {
                Socket incoming = null;
                try {
                    incoming = s.accept();

                } catch (IOException e) {
                    System.out.println(e);
                    continue;
                }

                System.out.println(incoming);
                new socketHandler(incoming).start();

            }
        }
    }
}
