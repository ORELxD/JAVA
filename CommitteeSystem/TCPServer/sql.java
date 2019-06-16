package TCPServer;

import java.sql.*;


public class sql {

    private static Connection connect;

    public static synchronized Connection connect() {
        return connect;
    }

    public static void connection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void ConnectingToSQL()
    {
        connection();
        String host = "jdbc:mysql://localhost:3306/java";
        String username = "orel";
        String password = "orel1234";


        try {
            connect = (Connection) DriverManager.getConnection(host, username, password);
            System.out.println("work");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    sql(){
        connection();
        ConnectingToSQL();
    }
}
