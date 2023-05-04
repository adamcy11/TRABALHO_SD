package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Serve {
  
        public static void main(String[] args) {
         ServerSocket server;
    
        final int PORT = 12345;
    
          try {
            server = new  ServerSocket(PORT);
    
            //criando um laço para suportar mais de um cliente
            while ( true) {
                System.out.println("Aguardando um cliente...");
                Socket Cliente = server.accept(); // coloca o client dentro do while pra sempre ta criando uma nova conexão
                LogicaJogo logica = new LogicaJogo(Cliente);
                logica.start();
            }
    
        } catch (Exception e) {
            System.out.println("Erro:  " + e.getMessage());
        }
    }
        }
    