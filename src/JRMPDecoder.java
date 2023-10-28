import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Arrays;

public class JRMPDecoder implements JRMPInterface {

    private final Socket socket;
    private final PrintStream ps;

    public JRMPDecoder(Socket cliente) throws IOException {
        this.socket = cliente;
        this.ps = new PrintStream(socket.getOutputStream());
    }

    @Override
    public void decode(String mensagem) throws IOException {
        String rawScript = mensagem.replace("\n", "").replace("\r", "");
        String[] commands = rawScript.split("@\\{");
        for (String command: commands) {
            String[] commandParts = command.trim().replace("}", "").split(" ");
            if (commandParts[0].isEmpty())
                continue;
            execute(commandParts[0], Arrays.copyOfRange(commandParts, 1, commandParts.length));
        }
    }

    @Override
    public void execute(String mensagem, String[] params) {
        switch (mensagem.toLowerCase()) {
            case "tocar" -> tocar(params);
            case "listar" -> listar(params);
            default -> mensagemErro();
        }
    }

    @Override
    public void tocar(String[] params) {
        JRMIDecoder dec = null;
        try {
            dec = new JRMIDecoder();
            dec.decode(String.join(" ", params));
            dec.fechar();
        } catch (LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void listar(String[] params) {
        System.out.println("Lista de músicas:");

        for (String musica: params) {
            System.out.println(musica.substring(0, musica.length() - 5));
        }
    }

    @Override
    public void nomeMusica(String[] params) {

    }

    @Override
    public void enviar(String[] params) {

    }

    @Override
    public void sair(String[] params) throws IOException {

    }

    @Override
    public void mensagemErro() {
        System.out.println("Erro! Comando inválido!");
    }
}
