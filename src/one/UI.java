package one;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Objeto.OBJ_Lixeira_Plastico;

public class UI {
	
	Game g;
	Font comic_sans_40,comic_sans_60,comic_sans_20;
	BufferedImage lixeira_plastico;
	public boolean mensagemSim= false;
	public String mensagem = ""; //faz display de uma mensagem quando tocamos na placa
	int mensagemCont = 0;
	public boolean jogoFinal = false; //permitir� com que o jogo acabe quando uma condi��o for completa
	
	public UI(Game g) {
		this.g = g;
		comic_sans_40 = new Font("Comic Sans",Font.BOLD,40); //nome da fonte, seu formato e seu tamanho, Esse comando � instanciado aqui para poupar o programa de rodar isso durante o gameloop
		comic_sans_60 = new Font("Comic Sans",Font.BOLD,60);
		comic_sans_20 = new Font("Comic Sans",Font.BOLD,20);
		OBJ_Lixeira_Plastico lixeiraPl= new OBJ_Lixeira_Plastico();
		lixeira_plastico = lixeiraPl.imagem;
	}
	
	public void mostraMensagem(String texto) {
		
		mensagem = texto;
		mensagemSim = true;
		
	}
	
	
	public void draw(Graphics2D g2) {
		
		if(jogoFinal == true) {  //esse texto aparecer� quando o jogador cumprir sua tarefa
			
			String texto1= "PARAB�NS, VOC� RECICLOU :)";
			String texto2= "Voc� ganhou, por favor feche o jogo.";
			
			g2.setFont(comic_sans_60); 
			g2.setColor(Color.WHITE);
		    
			g2.drawString(texto1, g.telaHorizontal/2 - 500, g.telaVertical/2 + 150);
			
			g2.setFont(comic_sans_20); 
			g2.setColor(Color.WHITE);
			
			g2.drawString(texto2, g.telaHorizontal/2 - 500, g.telaVertical/2 + 200);
			
			g.tempoIngame = null;
			
		
			
			
		} 
		else {		
			g2.setFont(comic_sans_40); 
			g2.setColor(Color.ORANGE);
			//g2.drawImage(lixeira_plastico, g.tamanhoBloco/2, g.tamanhoBloco/2, g.tamanhoBloco, g.tamanhoBloco, null);
			//g2.drawString("Plastico = "+ g.jogador.papel , 14, 35); //esse x and y do drawString funciona diferente de como normalmente ele funcionaria no JAVA, tendo suas posi��es iniciais no centro da tela ao inv�z do canto superior esquerdo
	    
			if (mensagemSim == true) {
			
				g2.setColor(Color.WHITE);
				g2.drawString(mensagem, g.tamanhoBloco/2, g.tamanhoBloco*10);
			
				mensagemCont++;
			
				if(mensagemCont > 1800) {
				mensagemCont= 0;
				mensagemSim=false;
				
				
				}
			}
			
		}
		

	}

}
