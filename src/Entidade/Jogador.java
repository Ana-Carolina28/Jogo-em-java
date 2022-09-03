package Entidade;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import one.Game;
import one.Teclado;

public class Jogador extends Entidade {
	
	Game g;
	Teclado tecladinho;
	
	public final int  telaX; //essas duas váriaveis são estaticas, portanto, não mudam durante o jogo
	public final int  telaY;
	
	public boolean plastico = false;
	public boolean vidro = false;
	public boolean metal = false;
	public boolean papel = false;
	public boolean temLixo = false;
	public boolean tutorial = false;
	public int jogouFora = 0;
	 
	public Jogador(Game g,Teclado tecladinho) {
		
		this.g = g;
		this.tecladinho = tecladinho;
		
		telaX= g.telaHorizontal/2 - (g.tamanhoBloco/2); //esse calculo centraliza o jogador no cent
		telaY= g.telaVertical/2 - (g.tamanhoBloco/2);
		
		areaSolida = new Rectangle(); //tamanho da hitbox do personagem
		areaSolida.x=18;
		areaSolida.y=43;
		areaSolidaPadraoX= areaSolida.x; //utilizamos essa areaSolidaPadrao para guardar esses valores de x e y atuais, uma vez que os mudaremos no futuro
		areaSolidaPadraoY= areaSolida.y;
		areaSolida.width=28;
		areaSolida.height=21;
		
		
		valoresPadrao();          //chama a classe valoresPadrao
		getImagemJogador();
	}
	public void valoresPadrao() {
		
		mundoX= g.tamanhoBloco * 32;   //posição inicial do jogador quando este abrir o jogo
		mundoY= g.tamanhoBloco * 32;
		velocidade = 1; //quanto o jogador vai andar enquanto uma tecla estiver sendo pressionada
		direcao = "baixo"; //direcao que o jogador começa quando o jogo carrega
	
	}
		
	public void getImagemJogador() {
		
		try {
			System.out.println("Carregando imagens");
			cima1 = ImageIO.read(getClass().getResourceAsStream("/godo/godo_walking_back_1.png"));
			cima2 = ImageIO.read(getClass().getResourceAsStream("/godo/godo_walking_back_2.png"));
			baixo1 = ImageIO.read(getClass().getResourceAsStream("/godo/godo_walking_front_1.png"));
			baixo2 = ImageIO.read(getClass().getResourceAsStream("/godo/godo_walking_front_2.png"));
			direita1 = ImageIO.read(getClass().getResourceAsStream("/godo/godo_walking_right_1.png"));
			direita2 = ImageIO.read(getClass().getResourceAsStream("/godo/godo_walking_right_2.png"));
			esquerda1 = ImageIO.read(getClass().getResourceAsStream("/godo/godo_walking_left_2.png"));
			esquerda2 = ImageIO.read(getClass().getResourceAsStream("/godo/godo_walking_left_1.png"));
			System.out.println("Imagens foram carregadas");
		} 
		
		catch(IOException ie) {
			ie.printStackTrace();
		}
	
		
			
		
	}
	public void update() {
		if(tecladinho.upPres==true || tecladinho.downPres==true || tecladinho.rightPres==true || tecladinho.leftPres==true) {
			if (tecladinho.upPres == true) {
				direcao = "cima";
				//System.out.println("ta clicando bem cowboy");
				//System.out.println(g.mundoHorizontal+ " " +g.mundoVertical);
			}
			else if (tecladinho.downPres == true) {
				direcao = "baixo";
				//System.out.println("ta clicando bem cowboy");
			}
			else if (tecladinho.rightPres == true) {
				direcao = "direita";
				//System.out.println("ta clicando bem cowboy");
			}
			else if (tecladinho.leftPres == true) {
				direcao = "esquerda";
				//System.out.println("ta clicando bem cowboy");
			}
			//checar colisão do BLOCO
			
			colisaoAtiva= false;
			g.cColisao.checarBloco(this);
			
			
			//Se não houver colisão, o jogador poderá se mover
			if(colisaoAtiva == false) {
				
				switch(direcao) {
				case "cima":
					mundoY -= velocidade; //no java, a posição x:0 e y:0 se encontram no canto superior esquerdo da tela, ou seja, os valores aumentam de tamanho apenas quando vamos para a direita ou para baixo.
					break;
				case "baixo":
					mundoY += velocidade;
					break;
				case "esquerda":
					mundoX -= velocidade;
					break;
				case "direita":
					mundoX += velocidade;
					break;
				}
			}
			//checar colisao do objeto
			 int objIndex = g.cColisao.checarObjeto(this, true);
			 pegarObjeto(objIndex);
			
			spriteCont++;         //a cada frame que passa, é adicionado 1 a essa variavel Contador. Ou seja, esse comando faz com que haja uma mudança de sprite(direcao1 para direcao2 e vice versa) a cada 10 frames que se passam dentro do jogo.
			if(spriteCont > 150) {
				if(spriteNum==1) {
					spriteNum=2;
				}
				else if(spriteNum==2) {
					spriteNum=1;
				}
				spriteCont= 0;//este comando faz com que o personagem só se mexa enquanto o player clica nos botões de direcao
			}
		}  
		
		
		
	}
	
	public void pegarObjeto(int i) {
		if (i != 999) {
			String nomeObjeto = g.obj[i].nome;
			
			switch(nomeObjeto) {
			case "Garrafa_Tutorial":
				if(temLixo == false) {
					g.tocarSFX(1);
					tutorial = true;
					temLixo = true;
					g.obj[i] = null;
					g.ui.mostraMensagem("Você achou um Vidro!");
				}
				break;
			case "Lixeira_Vidro_Tutorial":
				if(tutorial) {
					g.tocarSFX(2);
					tutorial = false;
					temLixo = false;
					g.obj[i] = null;
					g.ui.mostraMensagem("Reciclou um Vidro");
				} 
			case "Missao":
				g.ui.mostraMensagem("Recicle os lixos de acordo com a correta coloração");
				break;
			case "Papel":
				if(temLixo == false) {
					g.tocarSFX(1);
					papel = true;
					temLixo = true;
					g.obj[i] = null;
					g.ui.mostraMensagem("Você achou um Papel!");
				}
				break;
			case "Garrafa":
				if(temLixo == false) {
					g.tocarSFX(1);
					vidro = true;
					temLixo = true;
					g.obj[i] = null;
					g.ui.mostraMensagem("Você achou um Vidro!");
				}
				break;
			case "Sacola":
				if(temLixo == false) {
					g.tocarSFX(1);
					plastico = true;
					temLixo = true;
					g.obj[i] = null;
					g.ui.mostraMensagem("Você achou um Plástico!");
				}
				break;
			case "Latinha":
				if(temLixo == false) {
					g.tocarSFX(1);
					metal = true;
					temLixo = true;
					g.obj[i] = null;
					g.ui.mostraMensagem("Você achou um Metal!");
				}
				break;
			case "Lixeira_Papel":
				if(papel) {
					g.tocarSFX(2);
					papel = false;
					temLixo = false;
					jogouFora++;
					g.ui.mostraMensagem("Reciclou um Papel");
				} 			
				break;
			case "Lixeira_Vidro":
				if(vidro) {
					g.tocarSFX(2);
					vidro = false;
					temLixo = false;
					jogouFora++;
					g.ui.mostraMensagem("Reciclou um Vidro");
				} 
				break;
			case "Lixeira_Plastico":
				if(plastico) {
					g.tocarSFX(2);
					plastico = false;
					temLixo = false;
					jogouFora++;
					g.ui.mostraMensagem("Reciclou um Plástico");
				} 
				break;
			case "Lixeira_Metal":
				if(metal) {
					g.tocarSFX(2);
					metal = false;
					temLixo = false;
					jogouFora++;
					g.ui.mostraMensagem("Reciclou um Metal");
				} 
				break;
			}
		}if(jogouFora==4) {
			g.pararMusica();
			g.ui.jogoFinal =true;     //finaliza o jogo quando essa condição for cumprida
		    }
		
	}
	
	
	
	
	public void draw(Graphics2D g2) { //comando que alterna entre os sprites de animaçao
		
		BufferedImage image = null;
		switch(direcao) {
		case "cima":
			if(spriteNum==1) {
				image= cima1;
			}
			if(spriteNum==2) {
				image= cima2;
			}
			break;
		case "baixo":
			if(spriteNum==1) {
				image= baixo1;
			}
			if(spriteNum==2) {
				image= baixo2;
			}
			break;
		case "esquerda":
			if(spriteNum==1) {
				image= esquerda1;
			}
			if(spriteNum==2) {
				image= esquerda2;
			}
			break;
		case "direita":
			if(spriteNum==1) {
				image= direita1;
			}
			if(spriteNum==2) {
				image= direita2;
			}
			break;
		}
		g2.drawImage(image, telaX, telaY, g.tamanhoBloco, g.tamanhoBloco, null);  //esse comando desenha o personagem baseado nas imagens já carregadas no sistema, 
		//g2.fillRect(telaX + areaSolida.x, telaY + areaSolida.y, areaSolida.width, areaSolida.height); // Draw collision rectangle
	}

}
