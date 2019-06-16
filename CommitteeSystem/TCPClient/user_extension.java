package TCPClient;

import java.io.IOException;

public class user_extension{


    /* Function that will pop a message "PRESS ENTER TO CONTINUE" */
    static void press_enter() throws IOException {
        System.out.println("Press enter to continue");
        System.in.read();
    }

    public void menu() throws IOException {}

    protected static server_connector s;
}
