package TCPClient;

   import TCPUtil.user;

import java.io.*;
import java.util.Scanner;

public class main {
    public static void main(String args[]) {
        server_connector s = new server_connector(); // connecting to server
        try {
            s.create_connection();
            if (connection_menu())
                User.menu();
            else s.closeSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            s.closeSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean connection_menu() throws IOException {
        Scanner scan = new Scanner(System.in);
        /* vars */
        String resident_committee = null;
        String change_or_connect = null;
        Boolean bool = false;

        /*user picking if he's resident or committee*/
        System.out.println("I am a" + "\n" + "\t 1. Resident" + "\n" + "\t 2. Committee");
        while (!bool) {
            bool = true;
            resident_committee = scan.nextLine();
            switch (resident_committee) {
                case "1":
                    resident_committee = "resident";
                    break;
                case "2":
                    resident_committee = "committee";
                    break;
                default:
                    System.out.println("WRONG CREDENTIALS! TRY AGAIN");
                    bool = false;
                    break;
            }
        }

        server_connector.OutToServer().writeBytes(resident_committee + "\n");
        bool = false;

        /*user picking if connecting or change username/password*/
        while (!bool) {
            bool = true;
            System.out.println("" +
                    "Would you like to connect or to change password?" + "\n"
                    + "\t1. Connect" + "\n" + "\t2. Change password");
            change_or_connect = scan.nextLine();
            switch (change_or_connect) {
                case "1":
                    change_or_connect = "connect";
                    break;
                case "2":
                    change_or_connect = "change";
                    break;
                default:
                    System.out.println("WRONG CREDENTIALS, TRY AGAIN!");
                    bool = false;
                    break;
            }
        }

        server_connector.OutToServer().writeBytes(change_or_connect + "\n");

        /*creating user*/
        String username, password;
        System.out.print("Username: ");
        username = scan.nextLine();
        System.out.print("Password: ");
        password = scan.nextLine();

        User = new user(username, password); // create new object user that contain username and password
        System.out.println(User.get_username() + " " + User.get_password());
        server_connector.OutToServerObject().writeObject(User); // send this obj to the server

        switch (resident_committee){
            case "resident":
                live_user = new resident();
                break;
            case "committee":
                live_user = new committee();
                break;
        }

        String answer = server_connector.InFromServer().readLine();
        if (answer.matches("ok")){
            System.out.println("Connection succeed!");
            //live_user.enter_connection();
            live_user.menu();
            return true;
        }
        else{
            System.out.println("Connection failed and aborted!");
            return false;
        }
    }

    /* vars */
    private static user User;
    private static user_extension live_user;
}