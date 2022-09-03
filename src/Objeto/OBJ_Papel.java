package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Papel extends SuperObjeto{
	
	public OBJ_Papel() {
		
		nome = "Papel";
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/papel_amassado.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
