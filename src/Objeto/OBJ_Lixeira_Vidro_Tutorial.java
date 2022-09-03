package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Lixeira_Vidro_Tutorial extends SuperObjeto{
	
	public OBJ_Lixeira_Vidro_Tutorial() {
		
		nome = "Lixeira_Vidro_Tutorial";
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/lixeira_vidro.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		colisao = true;
			
	}

}
