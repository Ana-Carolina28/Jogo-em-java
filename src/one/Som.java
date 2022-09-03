package one;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Som {  // " https://www.fesliyanstudios.com/sound-effects-search.php?q= " <-- Link do site onde pegamos os sons do jogo
	
	Clip clip;
	URL somURL[] = new URL[30];
	
	public Som() {
		
		somURL[0] = getClass().getResource("/som/Musica_de_Fundo.wav");
		somURL[1] = getClass().getResource("/som/Pegando_Lixo.wav");
		somURL[2] = getClass().getResource("/som/Jogando_Lixo.wav");
		
	}
	
	public void setArquivo(int i) {
		
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(somURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		} catch (Exception e) {
			
		}
		
	}
	
	public void tocar() {
		
		clip.start();
		
	}
	
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	
	public void parar() {
		
		clip.stop();
		
	}

}
