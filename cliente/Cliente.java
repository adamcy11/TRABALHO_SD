package cliente;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

import util.MsqReq;
import util.MsqResp;

public class Cliente {

    public static void main(String[] args) {
        Socket socket;
;
        double value1;
        char escolha;
        String input;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o HOST: ");
        
        String HOST = entrada.nextLine();

        System.out.print("Digite a PORTA: ");
        int PORT = entrada.nextInt();
        entrada.nextLine();
        
        try {
           while(true){
            socket = new Socket(HOST, PORT);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            System.out.println("Digite uma operação (I para ímpar e P para par): ");
            escolha = entrada.nextLine().charAt(0); // pega apenas o primeiro caractere
            System.out.println("Digite um numero de 0 a 5: ");
            value1 = Double.parseDouble(entrada.nextLine());
            Random nuRandom = new Random();
            int value2 = nuRandom.nextInt(5);
            int resposta = (int) (value2 + value1);

            System.out.println("Seu número: " + value1);
            System.out.println("Número do adversário: " + (resposta - value1));
            System.out.println("Resultado: " + resposta);

            MsqReq request = new MsqReq(value1, value2, escolha);
            out.writeObject(request);

            MsqResp response = (MsqResp) in.readObject();

            System.out.println("Resultado do jogo: " + response.getResultado());

            System.out.println("Digite um comando ('Q' para sair e qualquer outra tecla para continuar): ");
            input = entrada.nextLine();

            if (input.equalsIgnoreCase("Q")) {
                System.out.println("Programa encerrado");
                break;
           }
        }
        } catch (Exception e) {
            System.out.println("error" +e.getMessage());
        }
       entrada.close();
}
        
    }