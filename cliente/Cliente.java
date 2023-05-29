package cliente;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;                    
import java.util.Scanner;

import util.MsqReq;
import util.MsqResp;
import util.Status;

public class Cliente {
    public static void main(String args[])  {
       
        final String HOST;
        final double PORT;

        Socket socket;
        double value1;
        String getEscolhaImpOuPar;
        String ValorEscolha;
        int port;
        String host;
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o HOST: ");
        host = entrada.nextLine();

        System.out.print("Digite a PORTA: ");
        port = entrada.nextInt();
        entrada.nextLine();
  
        try {

            socket = new Socket(host, port);

 
            

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());


        } catch (Exception e) {
            System.out.println("Erro:  " + e.getMessage());
       }

       entrada.close();
    }  
}
