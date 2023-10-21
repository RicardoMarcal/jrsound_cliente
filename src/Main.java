import javax.sound.sampled.LineUnavailableException;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LineUnavailableException, IOException {
        new JRMIDecoder().decode("|>TITULO teste titulo;" +
                "|>AUTOR teste autor; |>DESC teste descricao;" +
                "|>G 5 800;\n" +
                "|>F 5 800;\n" +
                "|>E 5 400;\n" +
                "|>E 5 200;");

        try {
            Socket cliente = new Socket("127.0.0.1", 1122);
            System.out.println("O cliente se conectou ao servidor!");

            Runnable connectionHandler = new ConnectionHandler(cliente);
            new Thread(connectionHandler).start();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintStream ps = new PrintStream(cliente.getOutputStream());
            String s;
            while ((s = in.readLine()) != null) {
                ps.println(s);
            }

            ps.close();
            in.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}