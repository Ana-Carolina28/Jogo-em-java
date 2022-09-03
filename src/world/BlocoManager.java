package world;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import one.Game;
public class BlocoManager {
	
	Game g;
	public Bloco[] bloquinho;  //"[] é chamado de array, e é uma matriz com um range de numeros
	public int mapaBlocoNum [] []; //esse comando vai possibilitar editar os blocos apartir de um arquivo de texto
	
	public BlocoManager (Game g) {
		
		this.g = g;
		
		bloquinho = new Bloco[10];
		mapaBlocoNum = new int [g.numeroMundoColuna] [g.numeroMundoLinha];
		
		getImagemBloco();
		carregaMapa("/mapas/mapa_grande.txt");
		
	}
	
	public void getImagemBloco() {   //mesmo processo de quando colocamos os sprites nos personagens
		
		try {
			
			bloquinho[0] = new Bloco();
			bloquinho[0].bloco= ImageIO.read(getClass().getResourceAsStream("/world/grama_1.png"));
			
			bloquinho[1] = new Bloco();
			bloquinho[1].bloco= ImageIO.read(getClass().getResourceAsStream("/world/asfalto.png"));
			
			bloquinho[2] = new Bloco();
			bloquinho[2].bloco= ImageIO.read(getClass().getResourceAsStream("/world/brick.png"));
			bloquinho[2].colisao= true;
			
			bloquinho[3] = new Bloco();
			bloquinho[3].bloco= ImageIO.read(getClass().getResourceAsStream("/world/grama_2.png"));
			
			bloquinho[4] = new Bloco();
			bloquinho[4].bloco= ImageIO.read(getClass().getResourceAsStream("/world/agua.png"));
			bloquinho[4].colisao= true;
			
			bloquinho[7] = new Bloco();
			bloquinho[7].bloco= ImageIO.read(getClass().getResourceAsStream("/world/fall_1.png"));
			bloquinho[7].colisao= true;
			
			bloquinho[8] = new Bloco();
			bloquinho[8].bloco= ImageIO.read(getClass().getResourceAsStream("/world/chao.png"));
					
			bloquinho[9] = new Bloco();
			bloquinho[9].bloco= ImageIO.read(getClass().getResourceAsStream("/world/fall.png"));
			bloquinho[9].colisao= true;
			
		}
		catch(IOException ie) {
			ie.printStackTrace();
			
			
		}
		
	}
	
	public void carregaMapa(String lerMapa ) { //utilizando essa string lerMapa, conseguimos importar com facilidade mais do que um mapa
		try {
			InputStream is = getClass().getResourceAsStream(lerMapa); //importa o file de texto e possibilita sua leitura com o comando abaixo
			BufferedReader br = new BufferedReader(new InputStreamReader(is)); //
			
			int col = 0;
			int row = 0;
			
			while (col < g.numeroMundoColuna && row < g.numeroMundoLinha) {
				
				String linha = br.readLine(); //esse comando le uma linha do arquivo de texto
				
				while(col < g.numeroMundoColuna) {
					
					String numeros[] = linha.split(" "); //divide a string sobre os casos de sua ocorrencia
					int numero = Integer.parseInt(numeros[col]); //utiliza 'col' como um index para a matriz numeros[]
					mapaBlocoNum[col] [row] = numero;
					col++;
					System.out.println("numero de colunas é " + col);
				}
				if (col == g.numeroMundoColuna) {
					col = 0;
					row++;
				} 
				
			}
			br.close(); 
		}
		catch(Exception e){
			
		}
	}
	public void draw(Graphics2D g2) {  //isso controlará a camera que segue o jogador
		
		int mundoCol = 0;
		int mundoRow = 0;
		
		while (mundoCol < g.numeroMundoColuna && mundoRow < g.numeroMundoLinha) { //maneira de automatizar o processo de organização dos blocos
			
			int blocoNum = mapaBlocoNum [mundoCol] [mundoRow];
			
			int mundoX = mundoCol * g.tamanhoBloco;
			int mundoY = mundoRow * g.tamanhoBloco;
			int telaX = mundoX - g.jogador.mundoX + g.jogador.telaX; //esse cálculo faz com que o personagem fique sempre no centro da tela, mesmo em uma situação onde o certo seria o player estar em um dos cantos( um caso disso é quando uma das coordenadas X ou Y são iguais a 0
			int telaY = mundoY - g.jogador.mundoY + g.jogador.telaY;
			                                          
			g2.drawImage(bloquinho[blocoNum].bloco, telaX, telaY, g.tamanhoBloco, g.tamanhoBloco, null);
			mundoCol++;
			
			if (mundoCol == g.numeroMundoColuna) {
			
				mundoCol = 0;
				mundoRow ++;
				
			}
		}
		
		
	}

}
