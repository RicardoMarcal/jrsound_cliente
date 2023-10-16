import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.util.Arrays;

public class JRMIDecoder {
    private final FrequencyPlayer frequency;

    public JRMIDecoder() throws LineUnavailableException {
        this.frequency = new FrequencyPlayer();
    }

    public void decode(String mensagem) throws IOException {
        String rawScript = mensagem.replace("\n", "").replace("\r", "");
        String[] commands = rawScript.split("\\|>");
        for (String command: commands) {
            String[] commandParts = command.replace(";", "").split(" ");
            execute(commandParts[0], Arrays.copyOfRange(commandParts, 1, commandParts.length));
        }
    }

    public void execute(String mensagem, String[] params) {
        switch (mensagem.toLowerCase()) {
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
                tocarNota(Notas.X, params);
                break;
        }
    }

    private void tocarNota(float nota, String[] params){
        int octave = Integer.parseInt(params[0]);
        int time = Integer.parseInt(params[1]);
        frequency.playNote(Notas.getNota(nota, octave), time);
    }
}
