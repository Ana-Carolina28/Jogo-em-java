package one;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame tela = new JFrame();
		tela.setTitle("APS_2022_1");
		tela.setAlwaysOnTop(true);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
		
		Game joguito = new Game();
		tela.add(joguito);
		tela.pack(); // faz com que a tela Game se encaixe nessa janela
		
	
		joguito.setGame();
		joguito.startTempoIngame();
		
		
		
		

	}

}
