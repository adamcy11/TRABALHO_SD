package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import util.MsqReq;
import util.MsqResp;

public class LogicaJogoPvP extends Thread {
    private Socket[] clientes;

    public LogicaJogoPvP(Socket[] clientes) {
        this.clientes = clientes;
    }

    @Override
    public void run() {
        //tratando para receber os dois clientes
        try {
            System.out.println("Connected with " + clientes[0].getInetAddress().getHostAddress() +
                    " and " + clientes[1].getInetAddress().getHostAddress());

            // Criando streams de entrada e saída para cada cliente
            ObjectInputStream[] in = new ObjectInputStream[2];
            ObjectOutputStream[] out = new ObjectOutputStream[2];
            for (int i = 0; i < 2; i++) {
                in[i] = new ObjectInputStream(clientes[i].getInputStream());
                out[i] = new ObjectOutputStream(clientes[i].getOutputStream());
            }

            // Lógica do jogo PvP futuramente
        

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
    
     

