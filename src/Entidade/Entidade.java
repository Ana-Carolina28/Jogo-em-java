package Entidade;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entidade {          //essa classe será utilizada para guardar informações do jogador e das dem
	
	public int mundoX, mundoY;
	public int velocidade;
	
	public BufferedImage cima1,cima2,baixo1,baixo2,esquerda1,esquerda2,direita1,direita2;  //Recurso utilizado para guardar nossos arquivos de imagem com antecedencia
	public String direcao;
	
	public int spriteCont = 0;
	public int spriteNum = 1;
	
	public Rectangle areaSolida;
	public int areaSolidaPadraoX, areaSolidaPadraoY;
	public boolean colisaoAtiva= false;
	
	
	
}
 