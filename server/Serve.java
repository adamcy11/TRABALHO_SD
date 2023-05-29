package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Serve {
  
        public static void main(String[] args) {
         ServerSocket server;
    
         int port = 12345;
    
          try {
            server = new  ServerSocket(port);
    
            //criando um laço para suportar mais de um cliente
            while ( true) {
                System.out.println("Aguardando um cliente...");


                Socket Cliente = server.accept(); // coloca o client dentro do while pra sempre ta criando uma nova conexão
                

          
            }
    
        } catch (Exception e) {
            System.out.println("Erro:  " + e.getMessage());
        }
    }
        }
    


      //  LogicaJogo logica = new LogicaJogo(Cliente);
       // logica.start();