package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Latinha extends SuperObjeto {
	
	public OBJ_Latinha() {
		
		nome = "Latinha";
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/latinha.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
