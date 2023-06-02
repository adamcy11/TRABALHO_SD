package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Serve {

    public static void main(String[] args) {
        
        ServerSocket server;
       final int PORT = 12345;
        try {
            server = new  ServerSocket(PORT);
            System.out.println("servidor disponivel");
            while(true){
                System.out.println("aguardando cliente");
                Socket client = server.accept();
                
                LogicaJogoPve imparOuPar = new LogicaJogoPve(client);
                imparOuPar.start();

        } 
                }catch (Exception e) {
            
                System.out.println("error" + e.getMessage());

        }
    }
    


}