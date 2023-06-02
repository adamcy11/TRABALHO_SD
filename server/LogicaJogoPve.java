package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import util.MsgReq;
import util.MsgResp;


public class LogicaJogoPve extends Thread {
    private Socket client;
    private int vitorias;
    private int derrotas;

    public LogicaJogoPve(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());

            while (true) {
                MsgReq request = (MsgReq) in.readObject();

                double value1 = request.getValue1();
                int value2 = request.getValue2();
                char escolha = request.getEscolha();

                int resposta = value2 + (int) value1;
                String resultado;
                String placar;

                if ((resposta % 2 == 0 && escolha == 'P') || (resposta % 2 != 0 && escolha == 'I')) {
                    resultado = "Você ganhou!";
                    vitorias++;
                } else {
                    resultado = "Você perdeu!";
                    derrotas++;
                }

                placar = " Cliente: " + vitorias + " X " + " Computador: " + derrotas;
                MsgResp response = new MsgResp(resultado, placar);
                out.writeObject(response);

                // Atualiza o placar no servidor
                Serve.vitorias = vitorias;
                Serve.derrotas = derrotas;

                if (request.getEscolha() == 'Q') {
                    break;
                }
            }

            out.close();
            in.close();
            client.close();
        } catch (Exception e) {
            System.out.println("Erro na lógica do jogo: " + e.getMessage());
        }
    }
}
