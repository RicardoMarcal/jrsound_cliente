import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
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