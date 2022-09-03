package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Sacola extends SuperObjeto {
	
	public OBJ_Sacola() {
		
		nome = "Sacola";
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/sacola.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
