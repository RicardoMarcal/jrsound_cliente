import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class FrequencyPlayer {
    private final int SAMPLE_RATE = 16 * 1024;
    private float volume = 100f;
    private final SourceDataLine line;

    public FrequencyPlayer() throws LineUnavailableException {
        final AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 1, true, true);
        this.line = AudioSystem.getSourceDataLine(af);
        line.open(af, SAMPLE_RATE);
        line.start();
    }

    private byte[] createSinWaveBuffer(double freq, int ms) {
        int samples = (ms * this.SAMPLE_RATE) / 1000;
        byte[] output = new byte[samples];
        //
        double period = (double) this.SAMPLE_RATE / freq;
        for (int i = 0; i < output.length; i++) {
            double angle = 2.0 * Math.PI * i / period;
            output[i] = (byte) (Math.sin(angle) * this.volume);
        }

        return output;
    }

    public void tocarNota(float nota, int tempo){
        byte [] toneBuffer = createSinWaveBuffer(nota, tempo);
        this.line.write(toneBuffer, 0, toneBuffer.length);
    }

    public void close(){
        this.line.drain();
        this.line.close();
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }
}
