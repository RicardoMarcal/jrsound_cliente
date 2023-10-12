import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LineUnavailableException, IOException {
        Socket cliente = new Socket("127.0.0.1", 1122);
        System.out.println("O cliente se conectou ao servidor!");
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
        }
        saida.close();
        teclado.close();
        cliente.close();

        FrequencyPlayer fp = new FrequencyPlayer();

        fp.tocarNota(Notas.getNota(Notas.C, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.D, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.E, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.F, 4), 500);
        fp.tocarNota(Notas.getNota(Notas.F, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.F, 4), 500);
        fp.tocarNota(Notas.getNota(Notas.C, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.D, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.C, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.D, 4), 500);
        fp.tocarNota(Notas.getNota(Notas.D, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.D, 4), 500);
        fp.tocarNota(Notas.getNota(Notas.C, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.G, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.F, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.E, 4), 500);
        fp.tocarNota(Notas.getNota(Notas.E, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.E, 4), 500);
        fp.tocarNota(Notas.getNota(Notas.C, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.D, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.E, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.F, 4), 500);
        fp.tocarNota(Notas.getNota(Notas.F, 4), 250);
        fp.tocarNota(Notas.getNota(Notas.F, 4), 500);

        fp.close();
    }
}