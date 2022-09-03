package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Garrafa extends SuperObjeto{
	
	public OBJ_Garrafa() {
		
		nome = "Garrafa";
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/garrafa.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
