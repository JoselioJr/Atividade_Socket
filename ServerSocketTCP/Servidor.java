import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(12345)) {
            System.out.println("Servidor aguardando conexão...");
            
            Socket socket = servidor.accept();

            System.out.println("Cliente conectado!");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);

            String mensagem;

            while ((mensagem = entrada.readLine()) != null) {
                if (mensagem.equalsIgnoreCase("sair")) {
                    System.out.println("Conexão encerrada!");
                    saida.println("Conexão encerrada!");
                    break;
                }

                System.out.println("Cliente: " + mensagem);
                saida.println("Mensagem recebida: " + mensagem);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}