package Objeto;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import one.Game;

public class SuperObjeto {
	
	public BufferedImage imagem;
	public String nome;
	public boolean colisao = false;
	public int mundoX, mundoY;
	public Rectangle areaSolida = new Rectangle(0,0,64,64);
	public int areaSolidaPadraoX= 0;
	public int areaSolidaPadraoY= 0;
	
	public void draw(Graphics2D g2, Game g) {
		
		int telaX = mundoX - g.jogador.mundoX + g.jogador.telaX;
		int telaY = mundoY - g.jogador.mundoY + g.jogador.telaY;
        
		g2.drawImage(imagem, telaX, telaY, g.tamanhoBloco, g.tamanhoBloco, null);
		
	}

}
