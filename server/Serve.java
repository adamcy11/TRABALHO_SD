package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import util.MsqReq;
import util.MsqResp;

public class Serve {
  
        public static void main(String[] args) {
         ServerSocket server;
    
         int port = 12345;
         boolean jogador1Conectado = false;
         boolean jogador2Conectado = false;
         Socket jogador1 = null;
         Socket jogador2 = null;
    

       
          try {

            server = new  ServerSocket(port);
    
            //criando um laço para suportar mais de um cliente

          
            if ( true) {

             System.out.println("Servidor em espera...");

                Socket Cliente = server.accept(); // coloca o client dentro do while pra sempre ta criando uma nova conexão
            

                System.out.println("Cliente Conectado");

         // Recebe a mensagem de requisição do cliente
            ObjectInputStream in = new ObjectInputStream(Cliente.getInputStream());
            MsqReq request = (MsqReq) in.readObject();



            if (request.getValorEscolha() == 2) {
                // Redireciona o cliente para o jogo contra a máquina
                LogicaJogoPve logica = new LogicaJogoPve(Cliente);
                logica.start();

            } else {
                // Lida com a lógica para jogar online
                // ...
            }
        }

               
    
        } catch (Exception e) {
            System.out.println("Erro:  " + e.getMessage());
        }
          
    
    }
}
    
        




    


//LogicaJogoPvP logica = new LogicaJogoPvP(Cliente);
               // logica.start();



        