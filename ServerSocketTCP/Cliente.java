import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            String mensagem;
            System.out.print("Digite uma mensagem (ou 'sair' para encerrar): ");

            while ((mensagem = teclado.readLine()) != null) {
                saida.println(mensagem);
                String resposta = entrada.readLine();
                System.out.println("Servidor: " + resposta);

                if (mensagem.equalsIgnoreCase("sair")) {
                    break;
                }

                System.out.print("Digite uma mensagem (ou 'sair' para encerrar): ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}