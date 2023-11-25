import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AudioControl {

    private String filepath = "src/main/resources/remainder.wav";
    private File f = new File(filepath);
    Clip clip;
    AudioInputStream audioIn;

    AudioControl() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            this.clip = AudioSystem.getClip();
            this.clip.open(audioIn);
        } catch (Exception e) {
            System.out.println("Failed to initialize AudioControl class");
        }
    }

    public void play() {
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }

}
