package one;

import Entidade.Entidade;

public class ChecarColisao {

	Game g;
	
	public ChecarColisao(Game g) {
		this.g = g;
	}
	
	public void checarBloco(Entidade entidade) {
		
		int entidadeEsqMundoX = entidade.mundoX + entidade.areaSolida.x;
		int entidadeDirMundoX = entidade.mundoX + entidade.areaSolida.x + entidade.areaSolida.width;
		int entidadeCimaMundoY = entidade.mundoY + entidade.areaSolida.y;
		int entidadeBaixoMundoY = entidade.mundoY + entidade.areaSolida.y + entidade.areaSolida.height;
		//System.out.println(entidadeEsqMundoX+","+entidadeDirMundoX+","+entidadeCimaMundoY+","+entidadeBaixoMundoY);
		
		int entidadeEsqCol = entidadeEsqMundoX / g.tamanhoBloco;
		int entidadeDirCol = entidadeDirMundoX / g.tamanhoBloco;
		int entidadeCimaLinha = entidadeCimaMundoY / g.tamanhoBloco;
		int entidadeBaixoLinha = entidadeBaixoMundoY / g.tamanhoBloco;
		//System.out.println(entidadeEsqCol+","+entidadeDirCol+","+entidadeCimaLinha+","+entidadeBaixoLinha);
		
		int blocoNum1, blocoNum2;
		
		switch(entidade.direcao) {
		case"cima":
			entidadeCimaLinha = +(entidadeCimaMundoY - entidade.velocidade) / g.tamanhoBloco;
			blocoNum1 = g.blocoM.mapaBlocoNum[entidadeEsqCol][entidadeCimaLinha];
			blocoNum2 = g.blocoM.mapaBlocoNum[entidadeDirCol][entidadeCimaLinha];
			if(g.blocoM.bloquinho[blocoNum1].colisao == true || g.blocoM.bloquinho[blocoNum2].colisao) { 
				entidade.colisaoAtiva = true;
			}
			break;
		case"baixo":
			entidadeBaixoLinha = +(entidadeBaixoMundoY + entidade.velocidade) / g.tamanhoBloco;
			blocoNum1 = g.blocoM.mapaBlocoNum[entidadeEsqCol][entidadeBaixoLinha];
			blocoNum2 = g.blocoM.mapaBlocoNum[entidadeDirCol][entidadeBaixoLinha];
			if(g.blocoM.bloquinho[blocoNum1].colisao == true || g.blocoM.bloquinho[blocoNum2].colisao) { 
				entidade.colisaoAtiva = true;
			}
			break;
		case"esquerda":
			entidadeEsqCol = +(entidadeEsqMundoX - entidade.velocidade) / g.tamanhoBloco;
			blocoNum1 = g.blocoM.mapaBlocoNum[entidadeEsqCol][entidadeCimaLinha];
			blocoNum2 = g.blocoM.mapaBlocoNum[entidadeEsqCol][entidadeBaixoLinha];
			if(g.blocoM.bloquinho[blocoNum1].colisao == true || g.blocoM.bloquinho[blocoNum2].colisao) { 
				entidade.colisaoAtiva = true;
			}
			break;
		case"direita":
			entidadeDirCol = +(entidadeDirMundoX + entidade.velocidade) / g.tamanhoBloco; //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH
			blocoNum1 = g.blocoM.mapaBlocoNum[entidadeDirCol][entidadeCimaLinha];
			blocoNum2 = g.blocoM.mapaBlocoNum[entidadeDirCol][entidadeBaixoLinha];
			if(g.blocoM.bloquinho[blocoNum1].colisao == true || g.blocoM.bloquinho[blocoNum2].colisao) { 
				entidade.colisaoAtiva = true;
			}
			break;
		}	
	}
	
	public int checarObjeto(Entidade entidade, boolean jogador) { //checa se o plauer está tocando em um objeto, retornando esse index
		
		int index = 999;
		
		for(int i=0; i< g.obj.length; i++) {
			
			if(g.obj[i] !=null) {
				
				entidade.areaSolida.x= entidade.mundoX + entidade.areaSolida.x;
				entidade.areaSolida.y= entidade.mundoY + entidade.areaSolida.y;
				
				g.obj[i].areaSolida.x = g.obj[i].mundoX;
				g.obj[i].areaSolida.y = g.obj[i].mundoY;
				
				switch(entidade.direcao) { //antecipamos o movimento da entidade e checamos sua posição  
				case "cima":
					entidade.areaSolida.y -= entidade.velocidade;
					if(entidade.areaSolida.intersects(g.obj[i].areaSolida)) { //intersects checa se dois retangulos estão tocando um ao outro automaticamente
						if(g.obj[i].colisao == true) {
							entidade.colisaoAtiva= true;
						}
						if(jogador == true) {
							index=i;
						}
						//System.out.println("colisao encima");
					}
					break;
				case "baixo":
					entidade.areaSolida.y += entidade.velocidade;
					if(entidade.areaSolida.intersects(g.obj[i].areaSolida)) { //intersects checa se dois retangulos estão tocando um ao outro automaticamente.Apesar de sua utilidade, ele é melhor reservado para poucas entidades(nesse caso, apenas 10) por causa de seu custo de performance, tendo que checar cada um dos blocos e suas hitboxes individualmente
						if(g.obj[i].colisao == true) {
							entidade.colisaoAtiva= true;
						}
						if(jogador == true) {
							index=i;
						}
						//System.out.println("colisao enbaixo");
					}
					break;
				case "esquerda":
					entidade.areaSolida.x -= entidade.velocidade;
					if(entidade.areaSolida.intersects(g.obj[i].areaSolida)) { //intersects checa se dois retangulos estão tocando um ao outro automaticamente
						if(g.obj[i].colisao == true) {
							entidade.colisaoAtiva= true;
						}
						if(jogador == true) {
							index=i;
						}
						//System.out.println("colisao a esquerda");
					}	
					break;
				case "direita":
					entidade.areaSolida.x += entidade.velocidade;
					if(entidade.areaSolida.intersects(g.obj[i].areaSolida)) { //intersects checa se dois retangulos estão tocando um ao outro automaticamente
						if(g.obj[i].colisao == true) {
							entidade.colisaoAtiva= true;
						}
						if(jogador == true) {
							index=i;
						}
						//System.out.println("colisao a direita");
					}	
					break;
				}
				entidade.areaSolida.x= entidade.areaSolidaPadraoX; //resetamos esses valores senão eles aumentariam com cada frame do jogo
				entidade.areaSolida.y= entidade.areaSolidaPadraoY;
				g.obj[i].areaSolida.x = g.obj[i].areaSolidaPadraoX;
				g.obj[i].areaSolida.y = g.obj[i].areaSolidaPadraoY;
			
			}
		}
		
		return index;
		
	}
}
