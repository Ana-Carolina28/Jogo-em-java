package one;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener{  //Vai permitir que o programa seja capaz de ler suas inputs do teclado,possibilitando também que sejamos capazes de jogar o jogo) 

	public boolean upPres, downPres, leftPres, rightPres; 
	
	@Override
	public void keyTyped(KeyEvent e) { //apesar de não ser utilizado para o jogo, é necessário que ele exista para que o comando funcione
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int cod = e.getKeyCode();  //Entrega o código relacionado com a tecla pressionada
		
		if(cod ==KeyEvent.VK_W) {
			upPres=true;
		}
		if(cod ==KeyEvent.VK_S) {
			downPres=true;
		}
		if(cod ==KeyEvent.VK_A) {
			leftPres=true;
		}
		if(cod ==KeyEvent.VK_D) {
			rightPres=true;
		}
		
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int cod = e.getKeyCode();  //Entrega o código relacionado com a tecla liberdada
		
		if(cod ==KeyEvent.VK_W) {
			upPres=false;
		}
		if(cod ==KeyEvent.VK_S) {
			downPres=false;
		}
		if(cod ==KeyEvent.VK_A) {
			leftPres=false;
		}
		if(cod ==KeyEvent.VK_D) {
			rightPres=false;
		}
		
		
		
		
	}

}
