package server;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import util.MsqReq;
import util.MsqResp;

    
    
    //puxando o cliente para a thread
    
    public class LogicaJogoPvP extends Thread {
        private Socket Cliente;
    
       
    
        public LogicaJogoPvP(Socket cliente) {
            this.Cliente = Cliente;
        }
    


        
    
        //o que o thread vai fzr 
        @Override
        public void run() {
           try {
               System.out.println("Conected with" + Cliente.getInetAddress().getHostAddress());
    
               ObjectInputStream in = new ObjectInputStream(Cliente.getInputStream());
               ObjectOutputStream out = new ObjectOutputStream(Cliente.getOutputStream());
    
             //pegando oque o cliente mandou para resolução
    
               MsqReq request = (MsqReq) in.readObject();
    
               

            } catch (Exception e) {
                System.out.println("Erro:  " + e.getMessage());
           }
     
        }
    }
    
    
     

