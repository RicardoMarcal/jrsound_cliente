import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.util.Arrays;

public class JRMIDecoder {
    private final FrequencyPlayer fp;
    private String titulo = "";
    private String autor = "";
    private String descricao = "";

    public JRMIDecoder() throws LineUnavailableException {
        this.fp = new FrequencyPlayer();
    }

    public void decode(String mensagem) throws IOException {
        String rawScript = mensagem.replace("\n", "").replace("\r", "");
        String[] commands = rawScript.split("\\|>");
        for (String command: commands) {
            String[] commandParts = command.trim().replace(";", "").split(" ");
            execute(commandParts[0], Arrays.copyOfRange(commandParts, 1, commandParts.length));
        }
    }

    public void execute(String mensagem, String[] params) {
        switch (mensagem.toLowerCase()) {
            case "titulo":
                titulo(params);
                break;
            case "autor":
                autor(params);
                break;
            case "desc":
                descricao(params);
                break;
            case "c":
                tocarNota(Notas.C, params);
                break;
            case "c#":
                tocarNota(Notas.CS, params);
                break;
            case "d":
                tocarNota(Notas.D, params);
                break;
            case "d#":
                tocarNota(Notas.DS, params);
                break;
            case "e":
                tocarNota(Notas.E, params);
                break;
            case "f":
                tocarNota(Notas.F, params);
                break;
            case "f#":
                tocarNota(Notas.FS, params);
                break;
            case "g":
                tocarNota(Notas.G, params);
                break;
            case "g#":
                tocarNota(Notas.GS, params);
                break;
            case "a":
                tocarNota(Notas.A, params);
                break;
            case "a#":
                tocarNota(Notas.AS, params);
                break;
            case "b":
                tocarNota(Notas.B, params);
                break;
            case "x":
                pausa(params);
                break;
        }
    }

    private void titulo(String[] params){
        String temp = String.join(" ", params);
        titulo = temp;
        System.out.println("Título: " + titulo);
    }

    private void autor(String[] params){
        String temp = String.join(" ", params);
        autor = temp;
        System.out.println("Autor: " + autor);
    }

    private void descricao(String[] params){
        String temp = String.join(" ", params);
        descricao = temp;
        System.out.println("Descrição: " + descricao);
    }

    private void tocarNota(float nota, String[] params){
        int octave = Integer.parseInt(params[0]);
        int time = Integer.parseInt(params[1]);
        fp.playNote(Notas.getNota(nota, octave), time);
    }

    private void pausa(String[] params){
        int time = Integer.parseInt(params[0]);
        fp.playNote(Notas.X, time);
    }

    public void fechar(){
        fp.close();
    }
}
