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
       
      

        Socket socket;
        double value;
        String EscolhaImpOuPar;
        int port, ValorEscolha;
        String host;
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o HOST: ");
        host = entrada.nextLine();

        System.out.print("Digite a PORTA: ");
        port = entrada.nextInt();
        entrada.nextLine();
        
        System.out.println("Digite 1 para jogar online ou digite 2 para jogar contra a maquina");
         ValorEscolha = Integer.parseInt(entrada.nextLine());

       

        try {

            socket = new Socket(host, port);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());


            MsqReq request = new MsqReq(ValorEscolha);

            out.writeObject(request);

            MsqResp response = (MsqResp) in.readObject();

//fazendo com que apenas o primeiro cliente que digitou 1, apareça a msg de aguardando o proximo jogador
            if (response.getStatus() == Status.Aguardando_Jogador && ValorEscolha == 1) {
                System.out.println("Aguardando outro jogador...");
            }
            
     

    


        } catch (Exception e) {
            System.out.println("Erro:  " + e.getMessage());
       }

       entrada.close();
      

    }  
}
