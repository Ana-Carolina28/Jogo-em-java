package one;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import Entidade.Jogador;
import Objeto.SuperObjeto;
import world.BlocoManager;

public class Game extends JPanel implements Runnable {
	
	//Gráficos
	
	final int bloco = 32; // tamanho de 32x32 dos sprites
	final int escala = 2; // para aumentar o tamanho dos sprites
	
	public final int tamanhoBloco = bloco * escala; // faz o bloco ter 64 pixels, tem que ser publico para usa-lo em outro pacote
	
	public final int numeroColunas = 64;
	public final int numeroLinhas = 64;
	public final int telaHorizontal = 1024;
	public final int telaVertical= 768;
	
	//Gráficos
	
	//CONFIGURAÇÃO MAPA

	public final int numeroMundoColuna = 64;
	public final int numeroMundoLinha = 64;
	public final int mundoHorizontal= tamanhoBloco * numeroMundoColuna; //gera o tamanho do mapa_grande(que chamamos como mundo dado seu tamanho)
	public final int mundoVertical=tamanhoBloco * numeroMundoLinha;
		
	
	//CONFIGURAÇÃO MAPA
	
	//GAME
	
	Teclado tecladinho= new Teclado(); //dando acesso a classe teclado
	
	public Game() {
		this.setPreferredSize(new Dimension(telaHorizontal, telaVertical)); //necessário dar um import na classe Dimension para ter as dimenções corretas)
		this.setBackground(Color.red); //necessário dar um import na classe Color para conseguir colorir o background(talvez abandone isso quando conseguir passar os sprites pra ca)
		this.setDoubleBuffered(true); //utiliza um buffer para desenhar os gráficos associados com a classe game antes da tela aparecer(ajuda na performance do jogo basicamente)
		this.addKeyListener(tecladinho); //Game recebe input do teclado agora por meio da instanciação tecladinho
		this.setFocusable(true); //Game será o foco das inputs		
	}
	
	public void setGame() {
		
		sAssets.setObjeto();
		
		tocarMusica(0);
		
	}
	//GAME
	
	//TEMPO E OUTROS
	
	int FPS = 60; //Quantidade de frames por segundo, ou seja, 60 frames por segunod
	
	Thread tempoIngame; //faz com que o programa continue rodando após ser aberto(comando principal para que o jogo funcione)
	
	public void startTempoIngame() {
		tempoIngame = new Thread(this); //faz com que ele utilize as configurações da classe Game
		tempoIngame.start();
		
		
	}
	public ChecarColisao cColisao = new ChecarColisao(this); //instanciando a classe que checa a aplica a colisão dos blocos
	public Jogador jogador =new Jogador(this,tecladinho);  //instanciando a classe jogador
    public SuperObjeto obj[] = new SuperObjeto[20]; //intanciando a classe objeto. Com esse comando também ditamos quantos objetos podem aparecer por vez na tela
	public SetAssets sAssets = new SetAssets(this); //instanciado a classe Monta Assets
	public UI ui= new UI(this);
    Som som = new Som();
	BlocoManager blocoM = new BlocoManager(this);   //instanciando a classe contendo os blocos do background
    
	
	@Override
	public void run() {    //objeto que é chamado quando se começa uma Thread, graças ao runnable
		
		double drawInterval = 100000000/FPS; //um segundo em nanosegundos divido pelo fps(60)
		double delta = 0;
		long tempoUltimo = System.nanoTime(); //devolve o tempo do sistema em nanosegundo
		long tempoAtual;
		
		while(tempoIngame != null) {  //enquanto tempoIngame estiver rodando, ela repete o processo
			
			tempoAtual = System.nanoTime();
			
			delta += (tempoAtual - tempoUltimo) / drawInterval; //quanto tempo se passou desde o ultimo tempo atual, depois transforma esse tempoAtual em tempoUltimo e recomeça o processo
			
			tempoUltimo = tempoAtual;
			
			if(delta >=1) {
				update();
				repaint();
				delta --;
			
				this.requestFocusInWindow(); //faz com que o botão fique focado na jogo
			}
			
			
			//Todo loop vai chamar este update e esse repaint
		}
		
	}
	public void update() {
		
		jogador.update();


	}
	public void paintComponent(Graphics g) {  //classe utilizada para pintar os blocos, derivada da classe Jpanel. g será a variavel qual receberemos os graficos
		
		super.paintComponent(g); //super=superclass(JPanel)
		
		Graphics2D g2= (Graphics2D)g;  //Graphics 2D é da mais liberdade para desenhar, por isso essa transformação
		
		blocoM.draw(g2);  // é importante que esse comando seja executado antes do jogador.draw, uma vez que isso é visto como uma espécie de layers pelo programa, criando primeiro os blocos e depois o jogador por cima
		
		for (int i = 0; i < obj.length; i++) { //isso faz com que ele pegue os objeto baseado na matriz de 0 a 9.
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
			
		}
		
		jogador.draw(g2);
		ui.draw(g2);
	} 
	
	//TEMPO E OUTROS
	
	public void tocarMusica(int i) {
		som.setArquivo(i);
		som.tocar();
		som.loop();
		
	}
	
	public void pararMusica(){
		som.parar();
	}
	
	public void tocarSFX(int i){
		som.setArquivo(i);
		som.tocar();
	}
}
