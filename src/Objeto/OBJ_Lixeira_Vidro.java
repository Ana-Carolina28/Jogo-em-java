package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Lixeira_Vidro extends SuperObjeto{
	
	public OBJ_Lixeira_Vidro() {
		
		nome = "Lixeira_Vidro";
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/lixeira_vidro.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		colisao = true;
			
	}

}
