package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Missao extends SuperObjeto {
	
	public OBJ_Missao() {
		
			nome = "Missao";
			try {
			
				imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/missao.png"));
			
			}catch(IOException e) {
			e.printStackTrace();
			}
		
	}

}
