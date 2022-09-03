package one;

import Objeto.OBJ_Garrafa;
import Objeto.OBJ_Garrafa_Tutorial;
import Objeto.OBJ_Latinha;
import Objeto.OBJ_Lixeira_Metal;
import Objeto.OBJ_Lixeira_Papel;
import Objeto.OBJ_Lixeira_Plastico;
import Objeto.OBJ_Lixeira_Vidro;
import Objeto.OBJ_Lixeira_Vidro_Tutorial;
import Objeto.OBJ_Missao;
import Objeto.OBJ_Papel;
import Objeto.OBJ_Sacola;

public class SetAssets {
	
	Game g;
	
	public SetAssets(Game g) {
		this.g = g;
	}
	
	public void setObjeto() {
		
		g.obj[0] = new OBJ_Papel();
		g.obj[0].mundoX = 12 * g.tamanhoBloco;
		g.obj[0].mundoY = 46 * g.tamanhoBloco;
		
		g.obj[1] = new OBJ_Garrafa();
		g.obj[1].mundoX = 10 * g.tamanhoBloco;
		g.obj[1].mundoY = 7 * g.tamanhoBloco;
		
		g.obj[2] = new OBJ_Latinha();
		g.obj[2].mundoX = 52 * g.tamanhoBloco;
		g.obj[2].mundoY = 55 * g.tamanhoBloco;
		
		g.obj[3] = new OBJ_Sacola();
		g.obj[3].mundoX = 55 * g.tamanhoBloco;
		g.obj[3].mundoY = 17 * g.tamanhoBloco;
		
		g.obj[4] = new OBJ_Lixeira_Papel();
		g.obj[4].mundoX = 31 * g.tamanhoBloco;
		g.obj[4].mundoY = 34 * g.tamanhoBloco;
		
		g.obj[5] = new OBJ_Lixeira_Metal();
		g.obj[5].mundoX = 35 * g.tamanhoBloco;
		g.obj[5].mundoY = 34 * g.tamanhoBloco;
		
		g.obj[6] = new OBJ_Lixeira_Vidro();
		g.obj[6].mundoX = 33 * g.tamanhoBloco;
		g.obj[6].mundoY = 34 * g.tamanhoBloco;
		
		g.obj[7] = new OBJ_Lixeira_Plastico();
		g.obj[7].mundoX = 37 * g.tamanhoBloco;
		g.obj[7].mundoY = 34 * g.tamanhoBloco; 
		
		g.obj[8] = new OBJ_Missao();
		g.obj[8].mundoX = 32 * g.tamanhoBloco;
		g.obj[8].mundoY = 28 * g.tamanhoBloco;
		
		g.obj[9] = new OBJ_Garrafa_Tutorial();
		g.obj[9].mundoX = 31 * g.tamanhoBloco;
		g.obj[9].mundoY = 28 * g.tamanhoBloco;
		
		g.obj[10] = new OBJ_Lixeira_Vidro_Tutorial();
		g.obj[10].mundoX = 33 * g.tamanhoBloco;
		g.obj[10].mundoY = 28 * g.tamanhoBloco;
	}

}
