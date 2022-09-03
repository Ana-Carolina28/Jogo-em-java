package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Lixeira_Plastico extends SuperObjeto{
	
	public OBJ_Lixeira_Plastico() {
		
		nome = "Lixeira_Plastico";
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/lixeira_plastico.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		colisao = true;
			
	}

}
