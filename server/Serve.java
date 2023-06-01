package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import util.MsqReq;
import util.MsqResp;
import util.Status;

public class Serve {
    public static void main(String[] args) {
        ServerSocket server;
        int port = 12345;
        Socket[] clientes = new Socket[2]; // Vetor para armazenar os clientes conectados

        try {
            server = new ServerSocket(port);
            System.out.println("Servidor em espera...");

            int clientesConectados = 0; // Contador de clientes conectados

            while (clientesConectados < 2) {
                Socket cliente = server.accept();
                System.out.println("Cliente Conectado");

                clientes[clientesConectados] = cliente; // Armazena o cliente no vetor
                clientesConectados++;

                if (clientesConectados == 1) {
                    // Informa ao primeiro cliente que está esperando o segundo cliente
                    ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                    MsqResp response = new MsqResp(Status.Aguardando_Jogador);
                    out.writeObject(response);
                    out.flush();
                } else {
                    // Verifica a escolha do primeiro cliente
                    ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
                    MsqReq request = (MsqReq) in.readObject();

                    if (request.getValorEscolha() == 1) {
                        // Inicia o jogo PvP
                        LogicaJogoPvP logica = new LogicaJogoPvP(clientes);
                        logica.start();
                    } else if (request.getValorEscolha() == 2) {
                        // Inicia o jogo PvE
                        LogicaJogoPve logica = new LogicaJogoPve(cliente);
                        logica.start();
                    } else {
                        // Lógica para lidar com a escolha inválida do primeiro cliente
                        // ...
                    }
                    clientesConectados = 0; // Reseta o contador de clientes conectados
                    clientes = new Socket[2]; // Reseta o vetor de clientes
                }

                //cliente.close(); // Fecha a conexão com o cliente atual
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
