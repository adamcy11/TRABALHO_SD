package cliente;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


import util.MsqReq;
import util.MsqResp;
import util.Status;

public class Cliente {
    public static void main(String args[])  {
        Socket socket;
        final String HOST = "localhost";
        final int PORT = 12345;
     

        try {
            socket = new Socket(HOST, PORT);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());


        } catch (Exception e) {
            System.out.println("Erro:  " + e.getMessage());
       }

    }  
}
