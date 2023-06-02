package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Serve {
    public static int vitorias = 0;
    public static int derrotas = 0;

    public static void main(String[] args) {
        ServerSocket server;
        final int PORT = 12345;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Servidor disponível");
            while (true) {
                System.out.println("Aguardando cliente");
                Socket client = server.accept();

                LogicaJogoPve imparOuPar = new LogicaJogoPve(client);
                imparOuPar.start();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
