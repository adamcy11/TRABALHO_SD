package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import util.MsqReq;
import util.MsqResp;
import util.MsqResp;

public class LogicaJogoPve extends Thread {

    private Socket cliente;

    public LogicaJogoPve(Socket cliente) {
        this.cliente = cliente;

    }

    @Override
    public void run() {
        System.out.println("Conectado ao cliente: " + cliente.getInetAddress().getHostAddress());

        try {
            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());

            MsqReq request = (MsqReq) in.readObject();

            char escolha = request.getEscolha();
            double valor1 = request.getValue1();
            double value2 = request.getvalue2();
            boolean resp;
            MsqResp response;

            switch (escolha) {
                case 'P':
                    resp = jogarPar(value2, valor1);
                    response = new MsqResp();
                    response.setResultado(resp  ? "Par" : "Ímpar");
                    out.writeObject(response);
                    break;

                case 'I':
                    resp = jogarImpar(value2, valor1);
                    response = new MsqResp();
                    response.setResultado(resp  ? "Ímpar" : "Par");
                    out.writeObject(response);
                    break;

                default:
                    System.out.println("Escolha inválida.");
                    break;
            }

            in.close();
            out.close();
            cliente.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        synchronized (Server.class) {
            System.out.println("Vitórias do Jogador: " + Server.vitorias);
            System.out.println("Derrotas do Jogador: " + Server.derrotas);
           
           
            if (Server.vitorias > Server.derrotas) {
                System.out.println("O jogador ganhou!");
            } else if (Server.vitorias < Server.derrotas) {
                System.out.println("O computador ganhou!");
            } 
        }
    }

    private boolean jogarPar(double value2, double valor1) {
        double valorComputador = value2;  // Gera um número aleatório para o computador
        double soma = valor1 + valorComputador;

        if ((int) soma % 2 == 0) {
            System.out.println("A soma é par.");
            Server.vitorias++; // Incrementar o contador de vitórias
            return true;
        } else {
            System.out.println("A soma é ímpar.");
            Server.derrotas++; // Incrementar o contador de derrotas
            return false;
        }
    }

    private boolean jogarImpar(double value2, double valor1) {
        double valorComputador = value2;  // Gera um número aleatório para o computador
        double soma = valor1 + valorComputador;
        
        if ((int) soma % 2 != 0) {
            System.out.println("A soma é ímpar.");
            Server.vitorias++; // Incrementar o contador de vitórias
            return true;
        } else {
            System.out.println("A soma é par.");
            Server.derrotas++; // Incrementar o contador de derrotas
            return false;
        }
    }
    public static class Server {
        public static int vitorias = 0;
        public static int derrotas = 0;
    }
}